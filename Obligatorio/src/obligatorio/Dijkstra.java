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
    private Set<Vertice> settledNodes;
    private Set<Vertice> unSettledNodes;
    private Map<Vertice, Vertice> predecessors;
    private Map<Vertice, Integer> distance;

    public Dijkstra(Grafo grafo) {
        // create a copy of the array so that we can operate on this array
        this.nodos = new ArrayList<Vertice>(grafo.getVertices());
        this.aristas = new ArrayList<Arista>(grafo.getAristas());
    }

    public void execute(Vertice  source) {
        System.out.println("||||||||||||||");
        System.out.println("Partir de: "+source.getEtiqueta());
        settledNodes = new HashSet<Vertice >();
        unSettledNodes = new HashSet<Vertice >();
        distance = new HashMap<Vertice , Integer>();
        predecessors = new HashMap<Vertice , Vertice >();
        distance.put(source, 0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            Vertice  node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
        System.out.println("||||||||||||||");
        System.out.println(unSettledNodes);
        System.out.println(settledNodes);
        System.out.println(distance);
        System.out.println("||||||||||||||");
    }

    private void findMinimalDistances(Vertice  node) {
        List<Vertice > adjacentNodes = getNeighbors(node);
        System.out.println("Adyacentes de: "+node.getEtiqueta());
        System.out.println(adjacentNodes);
        System.out.println("||||||||2||||||");
        for (Vertice  target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
        

    }

    private int getDistance(Vertice  node, Vertice  target) {
        for (Arista edge : aristas) {
            if (edge.getVertice1().equals(node)
                    && edge.getVertice2().equals(target)) {
                return edge.getPeso();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertice > getNeighbors(Vertice  node) {
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
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertice  vertex) {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(Vertice  destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<Vertice> getPath(Vertice  target) {
        LinkedList<Vertice > path = new LinkedList<Vertice >();
        Vertice  step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

}