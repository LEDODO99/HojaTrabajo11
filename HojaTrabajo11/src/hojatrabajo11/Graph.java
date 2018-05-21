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
public interface Graph<E> {
    public abstract void addNode(Node nodo);
    public abstract void addConection(Node nodoInicial, Node nodoFinal, int peso);
}
