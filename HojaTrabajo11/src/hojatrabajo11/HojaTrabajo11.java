/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * programa principal para manejo de Grafos
 * @author Luis Delgado 17187
 * @author Mario Sarmientos 17055
 */
public class HojaTrabajo11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          Scanner ingreso = new Scanner(System.in);
        String source = "";
        ArrayList<String> dictionary;
        dictionary = new ArrayList<String>();
   
        String textoTraducido = "";

        GraphImplementacion grafo=new GraphImplementacion();
        
        System.out.println("ESCOGER DICCIONARIO");
        //ingreso.nextLine();
      
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("./src"));
        chooser.setDialogTitle("Seleccione su archivo");
        chooser.setFileFilter(new FileNameExtensionFilter("Text files (.txt)", "txt"));
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {
						/*Lee el archivo y obtiene la cadena*/
                FileInputStream fstream = new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

                String strLine;
                while ((strLine = br.readLine()) != null) {
                    dictionary.add(strLine); //agregar cada linea al dictionary
                }

                /* Separar cadenas y hacer asociacion */
                for (int i = 0; i < dictionary.size(); i++) {
                    String temp = dictionary.get(i).substring(0, dictionary.get(i).length());
                    String[] partes = temp.split(", ");
                    Node nodo1=new Node(partes[0]);
                    Node nodo2=new Node(partes[1]);
                    int peso=Integer.parseInt(partes[2]);
                    grafo.addNode(nodo1);
                    grafo.addNode(nodo2);
                    grafo.addConection(nodo1, nodo2, peso);
                }
            } catch (Exception e) {
                System.out.println("Archivo no valido!!!");
            }
        }
        grafo.obtenerMatrizAdj();
        grafo.floyd();
        boolean salir=false;
        while (!salir){
            System.out.println("Ingrese el numero de la opcion que desea ingresar");
            System.out.println("1. Distancia y camino de una ciudad a otra.\n2. Ciudad centro.\n3. Modificar Infromacion.\n4.Salir");
            String opcion=ingreso.nextLine();
            if (opcion.equals("1")){
                
                System.out.println("Ingrese el nombre de la ciudad de salida");
                String ciudadDeSalida=ingreso.nextLine();
                System.out.println("Ingrese el nombre de la ciudad destino");
                String ciudadDestino=ingreso.nextLine();
                if (grafo.isNode(ciudadDeSalida)&&grafo.isNode(ciudadDestino)){
                    int numeroinicial=0;
                    int numerofinal=0;
                    for (int i=0;i<grafo.nodos.size();i++){
                        if (ciudadDeSalida.equals(grafo.nodos.get(i).nombre))
                            numeroinicial=i;
                        if (ciudadDestino.equals(grafo.nodos.get(i).nombre))
                            numerofinal=i;
                    }
                    if (numeroinicial==numerofinal){
                        System.out.println("No se puede ingresar la misma ciudad dos veces");
                    }else{
                        int longitudCamino=grafo.MatrizFloyd[numeroinicial][numerofinal];
                        ArrayList<String> camino=new ArrayList<>();
                        camino.add(grafo.nodos.get(numeroinicial).nombre);
                        boolean llego=false;
                        int numeroActual=numeroinicial;
                        while (!llego){
                            if (grafo.MatrizPath[numeroActual][numerofinal]!=0){
                                numeroActual=grafo.MatrizPath[numeroActual][numerofinal];
                                camino.add(grafo.nodos.get(numeroActual).nombre);
                            }else{
                                llego=true;
                            }
                        }
                        System.out.println("Distancia: "+longitudCamino+" \nPasando por:\n");
                        for(int i=0;i<camino.size ();i++){
                            System.out.println(camino.get(i));
                        }
                    }
                }else{
                    System.out.println("Una o ambas ciudades ingresadas no existen en la base de datos.");
                }
            }else if(opcion.equals("2")){
                int[] distanciasParaCento=new int[grafo.nodos.size()];
                for (int i=0;i<grafo.nodos.size();i++){
                    int distancia=0;
                    for (int j=0;j<grafo.nodos.size();j++){
                        distancia+=grafo.MatrizFloyd[i][j];
                    }
                    distanciasParaCento[i]=distancia;
                }
                int ciudadCentro=0;
                int minValue = distanciasParaCento[0];
                for (int i = 1; i < distanciasParaCento.length; i++) {
                    if (distanciasParaCento[i] < minValue) {
                        minValue = distanciasParaCento[i];
                        ciudadCentro=0;
                    }
                }
                
                System.out.println("La ciudad centro es "+grafo.nodos.get(ciudadCentro).nombre);
            }else if (opcion.equals("3")){
                System.out.println("No implementado todavia");
            }else if (opcion.equals("4")){
                salir=true;
            }else{

            }
            System.out.println("");
            System.out.println("");
        }
    }
    
}
