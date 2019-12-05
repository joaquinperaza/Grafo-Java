
package obligatorio;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class Obligatorio {

   
    public static void main(String[] args) {
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
        miGrafo.insertarVertice(new Vertice("Charruas y Setembrino"), true);
        miGrafo.insertarVertice(new Vertice("Charruas y 33"), true);
        miGrafo.insertarVertice(new Vertice("Uruguay y Setembrino"), true);
        miGrafo.insertarVertice(new Vertice("Uruguay y 33"), true);
       
        
        
        //Manzana 1 
	Arista Cuadra1 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y Setembrino"), miGrafo.getVertice("Uruguay y Setembrino"), 1);
        Arista Cuadra2 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y Setembrino"), miGrafo.getVertice("Uruguay y 33"), 1);
        Arista Cuadra3 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y Setembrino"), miGrafo.getVertice("Charruas y Setembrino"), 1);
        POI Escuela_94 = new POI();
        Escuela_94.setCuadra(Cuadra3);
        Escuela_94.setEsquina_mas_cercana(Cuadra3.getVertice2());
        htPOIxNombre.put("Escuela 94", Escuela_94);
        Arista Cuadra4 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y Setembrino"), miGrafo.getVertice("Charruas y 33"), 1);
        
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
        miGrafo.insertarVertice(new Vertice("Charruas y 19 de abril"),true);//6
        miGrafo.insertarVertice(new Vertice("Uruguay y 19 de abril"),true);//7
        
        Arista Cuadra7 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y 19 de abril"), miGrafo.getVertice("Charruas y Montevideo"), 1);
        Arista Cuadra8 = miGrafo.insertarArista(miGrafo.getVertice("Montevideo y Uruguay"), miGrafo.getVertice("Uruguay y 19 de abril"), 1);
        POI Juaro_motos = new POI();
        Juaro_motos.setCuadra(Cuadra8);
        Juaro_motos.setEsquina_mas_cercana(Cuadra8.getVertice2());
        htPOIxNombre.put("Juaro Motos", Juaro_motos);
        Arista Cuadra9 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y 19 de abril"), miGrafo.getVertice("Charruas y 19 de abril"), 1);
        
        //Manzana 4
         miGrafo.insertarVertice(new Vertice("Charruas y Herrera"), true);//10
         miGrafo.insertarVertice(new Vertice("Uruguay y Herrera"), true);//11
         Arista Cuadra10 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y Herrera"), miGrafo.getVertice("Charruas y 19 de abril"), 1);
         Arista Cuadra11 = miGrafo.insertarArista(miGrafo.getVertice("Charruas y Herrera"), miGrafo.getVertice("Uruguay y Herrera"), 1);
         Arista Cuadra12 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y 19 de abril"), miGrafo.getVertice("Uruguay y Herrera"), 1);
         //Manzana 5
         miGrafo.insertarVertice(new Vertice("Herrera y Florida"), true);//12
         miGrafo.insertarVertice(new Vertice("Florida y 19 de abril"), true);//13
         Arista Cuadra13 = miGrafo.insertarArista(miGrafo.getVertice("Uruguay y Herrera"), miGrafo.getVertice("Herrera y Florida"), 1);
        POI ColegioYLiceo_Huerto = new POI();
        ColegioYLiceo_Huerto.setCuadra(Cuadra13);
        ColegioYLiceo_Huerto.setEsquina_mas_cercana(Cuadra13.getVertice2());
        htPOIxNombre.put("Colegio y Liceo Nuestra Señora del Huerto", ColegioYLiceo_Huerto);
         Arista Cuadra14 = miGrafo.insertarArista(miGrafo.getVertice("Herrera y Florida"), miGrafo.getVertice("Florida y 19 de abril"), 1);
         Arista Cuadra15 = miGrafo.insertarArista(miGrafo.getVertice("Florida y 19 de abril"), miGrafo.getVertice("Uruguay y 19 de abril"), 1);
         
         Dijkstra d = new Dijkstra(miGrafo);
         d.execute(htPOIxNombre.get("Escuela 94").getEsquina_mas_cercana());
         LinkedList<Vertice> d_l = d.getPath(htPOIxNombre.get("Juaro Motos").getEsquina_mas_cercana());
         System.out.println(htPOIxNombre.size());
         System.out.println(miGrafo.getVertices());
         System.out.println(miGrafo.getAristas());
         System.out.println(htPOIxNombre.size());
         for (Vertice v : d_l){
             System.out.println(v.getEtiqueta());
        }
    }
    
}
