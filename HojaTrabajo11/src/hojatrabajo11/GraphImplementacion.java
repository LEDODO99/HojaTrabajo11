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
public class GraphImplementacion implements Graph{
    private ArrayList<Node> nodos;
    private int[][] MatrizAdyacencia;
    
    public GraphImplementacion(){
        nodos = new ArrayList();
    }
    
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
    
    public int[][] obtenerMatrizAdj(){
        int [][] matriz= new int[nodos.size()][nodos.size()];
        for (int i=0; i<nodos.size();i++){
            for (int j=0; j<nodos.get(i).connections.size();j++){
                for (int k=0;k<nodos.size();k++){
                    if (nodos.get(i).connections.get(j).nodeFinal.nombre.equals(nodos.get(k))){
                        matriz[i][k]=nodos.get(i).connections.get(j).peso;
                    }
                }
            }
        }
        return matriz;
    }
    public int[][] floyd()
    {
        int V=nodos.size();
        int [][] graph=new int[V][V];
        int dist[][] = new int[V][V];
        int i, j, k;
 
        /* Initialize the solution matrix same as input graph matrix.
           Or we can say the initial values of shortest distances
           are based on shortest paths considering no intermediate
           vertex. */
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
 
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
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        return dist;
    }
}
