/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo11;

import java.util.ArrayList;

/**
 * Implementacion del grafo
 * @author Luis Delgao 17187
 * @author Mario Sarmientos 17055
 */
public class GraphImplementacion implements Graph{
    protected ArrayList<Node> nodos;
    protected int[][] MatrizAdyacencia;
    protected int[][] MatrizFloyd;
    protected int[][] MatrizPath;
    /**
     * Contructor
     */
    public GraphImplementacion(){
        nodos = new ArrayList();
    }
    /**
     * Agrega un nodo
     * @param nodo Nodo a agregarse
     */
    @Override
    public void addNode(Node nodo) {
        if (nodos.size()!=0){
            int coincidencias=0;
            for (int i=0;i<nodos.size();i++){
                if (nodo.nombre.equals(nodos.get(i).nombre))
                    coincidencias++;
            }
            if (coincidencias==0){
                nodos.add(nodo);
            }
        }else{
            nodos.add(nodo);
        }
    }
    /**
     * Metodo para crear  una adyacencia
     * @param nodoInicial El nodo de donde se parte
     * @param nodoFinal El nodo a donde se llega
     * @param peso  El peso de la connecion
     */
    @Override
    public void addConection(Node nodoInicial, Node nodoFinal, int peso) {
        for (int i=0;i<nodos.size();i++){
            if (nodoInicial.nombre.equals(nodos.get(i).nombre)){
                for (int j=0;j<nodos.size();j++){
                    if (nodoFinal.nombre.equals(nodos.get(j).nombre)){
                        nodos.get(i).addAdjacent(nodos.get(j), peso);
                    }
                }
            }
        }
    }
    /**
     * Obtiene la matriz de ayacencia
     */
    public void obtenerMatrizAdj(){
        int [][] matriz= new int[nodos.size()][nodos.size()];
        for (int i=0; i<nodos.size();i++){
            for (int j=0; j<nodos.get(i).connections.size();j++){
                for (int k=0;k<nodos.size();k++){
                    if (nodos.get(i).connections.get(j).nodeFinal.nombre.equals(nodos.get(k).nombre)){
                        matriz[i][k]=nodos.get(i).connections.get(j).peso;
                    }
                }
            }
        }
        for (int i=0; i<nodos.size();i++){
            for (int j=0; j<nodos.size();j++){
                if ((matriz[i][j]==0)&&(i!=j)){
                    matriz[i][j]=99999;
                }
            }
        }
        MatrizAdyacencia=matriz;
    }
    
    /**
     * Ejecuta el algoritmo de floyd y lo guarda en una matriz al igual que el camino;
     */
    public void floyd()
    {
        int V=nodos.size();
        int [][] graph=new int[V][V];
        int [][] path=new int[V][V];
        int dist[][] = new int[V][V];
        int i, j, k;
        graph=MatrizAdyacencia;
 
        /* Initialize the solution matrix same as input graph matrix.
           Or we can say the initial values of shortest distances
           are based on shortest paths considering no intermediate
           vertex. */
        dist= graph;
 
        /* Add all vertices one by one to the set of intermediate
           vertices.
          ---> Before start of a iteration, we have shortest
               distances between all pairs of vertices such that
               the shortest distances consider only the vertices in
               set {0, 1, 2, .. k-1} as intermediate vertices.
          ----> After the end of a iteration, vertex no. k is added
                to the set of intermediate vertices and the set
                becomes {0, 1, 2, .. k} */
        for (k = 0; k < V; k++)
        {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++)
                {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j]=k;
                    }
                }
            }
        }
        MatrizPath=path;
        MatrizFloyd=dist;
    }
    /**
     * Devuelve la matriz de caminos mas cortos
     * @return Matriz de enteros que marcan el camino
     */
    public int[][] getPath(){
        return MatrizPath;
    }
    
    /**
     * Devuelve la matriz de floyd
     * @return Matriz de enteros por Floyd
     */
    public int[][] getFloyd(){
        return MatrizFloyd;
    }
    
    /**
     * Devuelve la matriz de adyacencia
     * @return Matriz de adyacencia
     */
    public int[][] getAdy(){
        return MatrizAdyacencia;
    }
    /**
     * Evalua si un nodo existe a partir de su nombre
     * @param n nombre del nodo
     * @return T/F si existe un nodo con ese nombre o no
     */
    public boolean isNode(String n){
        boolean concide=false;
        for (int i=0;i<nodos.size();i++){
            if (n.equals(nodos.get(i).nombre))
                concide=true;
        }
        return concide;
    }
}
