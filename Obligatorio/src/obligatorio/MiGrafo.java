
package obligatorio;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * En esta clase se demuestra como funciona la clase Grafo
 * Comenzaremos creando un objeto Grafo vacío.
 * Se crean 6 vértices: V{A, B, C, D, E, F} y sus adyacencias insertando
 * aristas de tal forma que {A, B, C} y {D, E, F} forman dos triángulos isósceles,
 * a continuación, el vértice A se une con el vértice D; y el C con el E; de esta forma
 * quedan comunicados ambos triángulos.   
 */

public class MiGrafo{
    public static void main (String [] args){
	Grafo miGrafo = new Grafo();

	Vertice [] vertices = new Vertice[49];
        Hashtable <String, POI> htPOIxNombre=new Hashtable<>();
	/*char [] etiquetas = {'Charruas','B','C','D','E','F'};
	int i = 0;
	boolean sobreescribe = true;
	
	for(i = 0; i < vertices.length; i++)
	    {
	    	vertices[i] = new Vertice(Character.toString(etiquetas[i]));
	     	System.out.println(vertices[i]);	    	
	    }

	System.out.println();
        */
        vertices[0] = new Vertice("Charruas y Setembrino");
        vertices[1] = new Vertice("Charruas y 33");
        vertices[2] = new Vertice("Uruguay y Setembrino");
        vertices[3] = new Vertice("Uruguay y 33");
       
        
        
        //Manzana 1 
		Arista Cuadra1 = miGrafo.insertarArista(vertices[0], vertices[2], 1);
        Arista Cuadra2 = miGrafo.insertarArista(vertices[2], vertices[3], 1);
        Arista Cuadra3 = miGrafo.insertarArista(vertices[3], vertices[1], 1);
        POI Escuela_94 = new POI();
        Escuela_94.setCuadra(Cuadra3);
        Escuela_94.setEsquina_mas_cercana(Cuadra3.getVertice2());
        htPOIxNombre.put("Escuela 94", Escuela_94);
        Arista Cuadra4 = miGrafo.insertarArista(vertices[1], vertices[0], 1);
        
        //Manzana 2
        vertices[4] = new Vertice("Charruas y Montevideo");
        vertices[5] = new Vertice("Uruguay y Montevideo");
        
        Arista Cuadra5 = miGrafo.insertarArista(vertices[4], vertices[1], 1);
        Arista Cuadra6 = miGrafo.insertarArista(vertices[4], vertices[5], 1);
        POI El_Jardin = new POI();
        El_Jardin.setCuadra(Cuadra6);
        El_Jardin.setEsquina_mas_cercana(Cuadra6.getVertice2());
        htPOIxNombre.put("El Jardin", El_Jardin);
        
        //Manzana 3 
        vertices[6] = new Vertice("Charruas y 19 de abril");
        vertices[7] = new Vertice("Uruguay y 19 de abril");
        
        Arista Cuadra7 = miGrafo.insertarArista(vertices[6], vertices[4], 1);
        Arista Cuadra8 = miGrafo.insertarArista(vertices[5], vertices[7], 1);
        POI Juaro_motos = new POI();
        Juaro_motos.setCuadra(Cuadra8);
        Juaro_motos.setEsquina_mas_cercana(Cuadra8.getVertice2());
        Juaro_motos.setName("Juaro Motos");
        Arista Cuadra9 = miGrafo.insertarArista(vertices[7], vertices[6], 1);
        
        //Manzana 4
         vertices[10] = new Vertice("Charruas y Herrera");
         vertices[11] = new Vertice("Uruguay y Herrera");
         
         Arista Cuadra10 = miGrafo.insertarArista(vertices[10], vertices[6], 1);
         Arista Cuadra11 = miGrafo.insertarArista(vertices[10], vertices[11], 1);
         Arista Cuadra12 = miGrafo.insertarArista(vertices[7], vertices[11], 1);


         
         

    }
}
