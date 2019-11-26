/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;

/**
 *
 * @author Joaquin Peraza
 */
public class POI {
    private String name;
    private Arista cuadra;
    private Vertice esquina_mas_cercana;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cuadra
     */
    public Arista getCuadra() {
        return cuadra;
    }

    /**
     * @param cuadra the cuadra to set
     */
    public void setCuadra(Arista cuadra) {
        this.cuadra = cuadra;
    }

    /**
     * @return the esquina_mas_cercana
     */
    public Vertice getEsquina_mas_cercana() {
        return esquina_mas_cercana;
    }

    /**
     * @param esquina_mas_cercana the esquina_mas_cercana to set
     */
    public void setEsquina_mas_cercana(Vertice esquina_mas_cercana) {
        this.esquina_mas_cercana = esquina_mas_cercana;
    }
       
}
