/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo11;

/**
 * Clase que contiene las conecciones que apuntan a un nodo con el peso de la coneccion
 * @author Luis Delgado 17187 
 */
public class Connection {
    protected Node nodeFinal;
    protected int peso;
    /**
     * Constructor
     * @param nodeFinal El nodo al que apunta
     * @param peso El peso de la coneccion
     */
    public Connection( Node nodeFinal, int peso) {
        this.nodeFinal = nodeFinal;
        this.peso = peso;
    }
    
    
}
