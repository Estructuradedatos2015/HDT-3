/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hoja3;
import java.io.PrintWriter;

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
        
        try{
            PrintWriter writer = new PrintWriter("datos.txt","UTF-8");
            writer.println("Test");
            writer.close();
        }
        catch(Exception e){
            System.out.println("Error al creear el archivo datos.txt");
        }
    }
    
}
