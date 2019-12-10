package obligatorio;
import java.util.*;

/* 
 * Esta clase modela y gestiona un grafo no dirigido
 * usando una estructura de listas para representar
 * las adyacencias. Además contiene métodos para
 * gestionar vértices y aristas.
 * Los vértices se distinguen por su etiqueta.
 * Un par de vértices solo permite una arista entre ellos
 */

public class Grafo{

    private HashMap<String, Vertice> vertices;
    private HashMap<Integer, Arista> aristas;
    Hashtable <String, POI> htPOIxNombre=new Hashtable<>();

    /**
     * Construcción de un grafo vacío
     **/
    public Grafo()
    {
	this.vertices = new HashMap<String, Vertice>();
	this.aristas = new HashMap<Integer, Arista>();
    }

    public List<Object> obtenerListadoPOI(Hashtable<String, POI> ht){
        List<Object> listadoPOI = new ArrayList();
        
        Enumeration e = htPOIxNombre.keys();
        Object clave;
        while (e.hasMoreElements()){
            clave = e.nextElement();
            listadoPOI.add(clave);
           
            
        }
    
    
        
    return  listadoPOI;
    }
    /**
     * Construcción de un grafo que acepta una lista
     * de vertices por parámetro de entrada
     *
     *@param vertices. Array de lista usado para llenar el grafo
     **/
    public Grafo(ArrayList<Vertice> vertices)
    {
	this.vertices = new HashMap<String, Vertice>();
	this.aristas = new HashMap<Integer, Arista>();

	for(Vertice v : vertices )
	    {
		this.vertices.put(v.getEtiqueta(), v);
	    }
	
    }


    /**
     * Inserta una arista unitaria entre los vertices v1 y v2
     * si y solo si no exista ya una arista que los una
     *
     * @param v1. Un extremo de la arista
     * @param v2. Otro extremo de la arista
     * @return true. Si y solo si la arista no existe previamente
     **/
    public Arista insertarArista(Vertice v1, Vertice v2)
    {
    return insertarArista(v1, v2, 1);
    }



    public List<Object> buscarRuta(String a, String b){
        List<Object> ListaRecorrido = new ArrayList();
        int cuadras=-1;
        Dijkstra d = new Dijkstra(this);
        d.ejecutar(htPOIxNombre.get(a).getEsquina_mas_cercana());
        LinkedList<Vertice> d_l = d.getRutas(htPOIxNombre.get(b).getEsquina_mas_cercana());
        for (Vertice v : d_l){
            System.out.println(v.getEtiqueta());
            ListaRecorrido.add(v.getEtiqueta());
            
            cuadras++;
        }
        System.out.println("Cuadras: "+String.valueOf(cuadras));
        return ListaRecorrido;
    }

    
    /**
     * Inserta una arista entre los vertices v1 y v2
     * y un coste o peso especificado por parámetro de entrada. 
     * La arista se insertará con éxito siempre que sea única y además
     * no haya otra uniendo actualmente v1 y v2. Finalmente v1 y v2 no
     * deben ser el mismo vértice (v1 != v2)
     *
     * @param v1. Un extremo de la arista
     * @param v2. Otro extremo de la arista
     * @param peso. Coste para llegar de v1 a v2 o viceversa
     * @return true. Si y solo si la arista no existe previamente
     **/
    public Arista insertarArista(Vertice v1, Vertice v2, int peso)
    {
	if(v1.equals(v2)) //vertices identicos?
	    return null;

	Arista arista = new Arista(v1, v2, peso);

	if(aristas.containsKey(arista.hashCode())) //arista ya está en el grafo?
	    return null;
	else if( v1.contieneUnVecino(arista)) //arista ya une a v1 o v2?
	    return null;

	aristas.put(arista.hashCode(), arista);
	v1.insertarVecino(arista);
	//v2.insertarVecino(arista); //para dar direccion
	return arista;
    }

    /** 
     * @param arista. Arista que estamos buscando
     * @return true. Si y solo si el grafo contiene a la arista
     **/
    public boolean contieneLaArista(Arista arista)
    {
	if(arista.getVertice1() == null || arista.getVertice2() == null)
	    return false;
	return this.aristas.containsKey(arista.hashCode());
    }


    /**
     * Elimina una arista del grafo. Por tanto, los vertices que unían
     * pierden la adyacencia entre ellos
     *
     *@param arista. Arista que se quiere eliminar del grafo
     *@return Arista. Arista borrada del grafo
     */
    public Arista eliminarArista(Arista arista)
    {
	arista.getVertice1().eliminarVecino(arista);
	return this.aristas.remove(arista.hashCode());
    }

    /**
     * Nos devuelve true si encuentra el vértice que se pasa
     * como parámetro de entrada
     * 
     * @param vertice. Vértice que buscamos
     * @return boolean. True si el vertice se encuentra.
     **/    
    public boolean contieneElVertice(Vertice vertice)
    {
	return (this.vertices.get(vertice.getEtiqueta()) != null);
    }

    /**
     * @param etiqueta. Distintivo de cada vértice
     * @return Vertice. Devuelve el vértice asociado a la etiqueta
     **/
    public Vertice getVertice(String etiqueta)
    {
	return this.vertices.get(etiqueta);
    }

    /**
     * Inserta un nuevo vértice. Si el vértice existe previamente entonces
     * se consulta si puede ser sobreescrito. En tal caso se elimina las adyacencias
     * existentes.
     *
     * @param vertice. Vértice a insertar
     * @param sobreescribeVertice. Permiso para sobreescribir el vértice
     * @return boolean. Verdarero si el vértice se inserta con éxito
     **/
    public boolean insertarVertice(Vertice vertice, boolean sobreescribeVertice)
    {
	vertices.put(vertice.getEtiqueta(), vertice);
	return true;
    }
    public boolean insertarPOI(String nombre,POI a)
    {
	htPOIxNombre.put(nombre, a);
	return true;
    }

    /**
     * Elimina el vértice especificado mediante la etiqueta
     * distintiva por parámetro de entrada. Al eliminar el vértice
     * se elimina también todas las adyancencias que poseía este.
     *
     * @param etiqueta. Cadena distintiva de cada vértice
     * @return Vertice. Devuelve el vértice eliminado
     **/
    public Vertice eliminarVertice(String etiqueta)
    {
	Vertice vertice = vertices.remove(etiqueta);

	while(vertice.getContarVecinos() >= 0)
	    this.eliminarArista(vertice.getVecino(0));

	return vertice;
    }

    /**
     * @return Set<String>. Devuelve las etiquetas, que son el distintivo
     * único de cada objeto Vertice en el Grafo
     **/
    public Set<String> verticeKeys()
    {
	return this.vertices.keySet();
    }

    /**
     * @return Set<Arista>. Devuelve todos los objetos Arista del Grafo
     **/
    public Set<Arista> getAristas()
    {
	return new HashSet<Arista>(this.aristas.values());
    }
    public Set<Vertice> getVertices()
    {
    return new HashSet<Vertice>(this.vertices.values());
    }
    
}
