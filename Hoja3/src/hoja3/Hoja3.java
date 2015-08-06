/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hoja3;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author diego_000
 */
public class Hoja3{

    ///**
     //* @param args the command line arguments
     //*/
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("OK to start");
        Random rand = new Random();
        ArrayList<Comparable> sorter = new ArrayList<>();
        try{
            PrintWriter writer = new PrintWriter("datos.txt","UTF-8");
            writer.println("Test");
            for(int i=0; i<10; i++){
                writer.print(rand.nextInt(20));
                writer.print(" ");
            }
            writer.close();
        }
        catch(Exception e){
            System.out.println("Error al creear el archivo datos.txt");
        }
        
        try{
            BufferedReader datos=new BufferedReader(new FileReader(new File("datos.txt")));
            System.out.println("Archivo se abrio correctamente \n");
            datos.readLine();
            String cadena = datos.readLine();
            String[] array = cadena.split(" ");
            for(int i=0; i<array.length; i++){
                sorter.add(Integer.parseInt(array[i]));
            }
            System.out.println(sorter);
            System.out.println("");
            sorter=Sort.QuikSort(sorter);
            System.out.println(sorter);
            Sort test = new Sort(sorter);
            test.show();
            datos.close();
        }
        catch(IOException e){
            System.out.println("Error al abrir el archivo");
        }
        
        
    }
    
}
