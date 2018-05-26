/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo11;

/**
 *
 * @author ledod
 */
public class Connection {
    Node nodeInicial;
    Node nodeFinal;
    float peso;

    public Connection(Node nodeInicial, Node nodeFinal, float peso) {
        this.nodeInicial = nodeInicial;
        this.nodeFinal = nodeFinal;
        this.peso = peso;
    }
    
    
}
