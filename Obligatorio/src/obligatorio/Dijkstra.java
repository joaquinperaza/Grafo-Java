package obligatorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Dijkstra {

    private final List<Vertice> nodos; //ex-vertex|nodes
    private final List<Arista> aristas; // ex-edges
    private Set<Vertice> colocados;
    private Set<Vertice> noColocados;
    private Map<Vertice, Vertice> previos;
    private Map<Vertice, Integer> distance;

    public Dijkstra(Grafo grafo) {
        this.nodos = new ArrayList<Vertice>(grafo.getVertices());
        this.aristas = new ArrayList<Arista>(grafo.getAristas());
    }

    public void ejecutar(Vertice  source) {
        colocados = new HashSet<Vertice >();
        noColocados = new HashSet<Vertice >();
        distance = new HashMap<Vertice , Integer>();
        previos = new HashMap<Vertice , Vertice >();
        distance.put(source, 0);
        noColocados.add(source);
        while (noColocados.size() > 0) {
            Vertice  nodo = getMinimum(noColocados);
            colocados.add(nodo);
            noColocados.remove(nodo);
            findMinimalDistances(nodo);
        }

    }

    private void findMinimalDistances(Vertice  node) {
        List<Vertice > nodosAdyacentes = getVecinos(node);
        for (Vertice  target : nodosAdyacentes) {
            if (getMinDistancia(target) > getMinDistancia(node)
                    + getDistance(node, target)) {
                distance.put(target, getMinDistancia(node)
                        + getDistance(node, target));
                previos.put(target, node);
                noColocados.add(target);
            }
        }
        

    }

    private int getDistance(Vertice  node, Vertice  target) {
        for (Arista arista : aristas) {
            if (arista.getVertice1().equals(node)
                    && arista.getVertice2().equals(target)) {
                return arista.getPeso();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertice > getVecinos(Vertice  node) {
        List<Vertice > vecinos = new ArrayList<Vertice>();
        for (Arista edge : aristas) {
            if (edge.getVertice1().equals(node)
                    && !isSettled(edge.getVertice2())) {
                vecinos.add(edge.getVertice2());
            }
        }
        return vecinos;
    }

    private Vertice  getMinimum(Set<Vertice> vertexes) {
        Vertice  minimum = null;
        for (Vertice  vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getMinDistancia(vertex) < getMinDistancia(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertice  vertex) {
        return colocados.contains(vertex);
    }

    private int getMinDistancia(Vertice  destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * NULL si no hay ruta
     */
    public LinkedList<Vertice> getRuta(Vertice  target) {
        LinkedList<Vertice > path = new LinkedList<Vertice >();
        Vertice  step = target;
        if (previos.get(step) == null) {
            return null;
        }
        path.add(step);
        while (previos.get(step) != null) {
            step = previos.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }

}