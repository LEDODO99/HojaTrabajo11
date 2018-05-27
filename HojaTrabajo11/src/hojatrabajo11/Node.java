/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo11;

import java.util.ArrayList;

/**
 *
 * @author ledod
 */
public class Node {
    protected String nombre;
    protected ArrayList<Connection> connections;

    public Node(String nombre) {
        this.nombre = nombre;
        connections= new ArrayList<>();
    }
    
    public void addAdjacent(Node node,int peso){
        connections.add(new Connection(node,peso));
    }
}
