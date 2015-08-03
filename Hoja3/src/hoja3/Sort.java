/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja3;
import java.util.ArrayList;
/**
 *
 * @author diego_000
 */
public class Sort {
    
    public static ArrayList<Comparable> SelectionSort(ArrayList<Comparable> unsorted){
        ArrayList<Comparable> sorted = new ArrayList<>();
        for(int i=0; i<unsorted.size(); i++){
            Comparable menor=unsorted.get(0);
            int index=0;
            //este ciclo encuentra el menor que contiene unsorted
            for(int j=1;i<unsorted.size(); j++){
                if(menor.compareTo(unsorted.get(j))<0){
                    menor=unsorted.get(j);
                    index=j;
                }
            }
            sorted.add(0, menor);
            unsorted.remove(index);
        }
        return sorted;
    }
}
