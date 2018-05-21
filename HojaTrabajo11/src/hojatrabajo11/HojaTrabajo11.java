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
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ledod
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

        System.out.println("ESCOGER DICCIONARIO");
        ingreso.nextLine();
      
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
                    String temp = dictionary.get(i).substring(1, dictionary.get(i).length() - 1);
                    String[] partes = temp.split(", ");
                    //ingresar aqui codigo de insercion en grafo
                }
            } catch (Exception e) {
                System.out.println("Archivo no valido!!!");
            }
        }
    }
    
}
