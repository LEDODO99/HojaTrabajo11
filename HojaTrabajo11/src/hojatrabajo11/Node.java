/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo11;

import java.util.ArrayList;

/**
 *
 * @author Luis Delgado 17187
 */
public class Node {
    protected String nombre;
    protected ArrayList<Connection> connections;

    /**
     * Contructor que crea un nuevo nodo vacia sin adyacencia.
     * @param nombre El nombre del nodo
     */
    public Node(String nombre) {
        this.nombre = nombre;
        connections= new ArrayList<>();
    }
    /**
     * Metodo que agrega una adyacencia a un nodo
     * @param node El nodo a donde se conecta
     * @param peso El peso de la adyacencia
     */
    public void addAdjacent(Node node,int peso){
        connections.add(new Connection(node,peso));
    }
}
