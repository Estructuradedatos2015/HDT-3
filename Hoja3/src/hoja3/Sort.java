/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja3;
import java.util.ArrayList;
/**
 *
 * Autores:
 * Diego Rosales
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
    
    public static ArrayList<Comparable> InsertionSort(ArrayList<Comparable> unsorted){
        for(int i=1;i<unsorted.size(); i++){
            if(unsorted.get(i).compareTo(unsorted.get(-1))<0){
                int k=1;
                while(k<=i){
                    if (unsorted.get(i).compareTo(unsorted.get(i-k))<0)
                        k++;
                }
                Comparable val=unsorted.remove(i);
                unsorted.add(i-k, val);
            }
        }
        return unsorted;
    }
    public static ArrayList<Comparable> QuikSort(ArrayList<Comparable> unsorted){
        quickSortRecursive(unsorted,0,unsorted.size()-1);
        return unsorted;
    }
    public static void swap(ArrayList<Comparable> unsorted,int i,int j)
    {
        ArrayList<Comparable> temp = null;
        temp.add(0,unsorted.get(i));
        unsorted.add(i,unsorted.get(j));
        unsorted.add(j,temp.get(0));
    
    }
     public static int partition(ArrayList<Comparable> unsorted, int left, int right)
    {
       
       while(true)
       {
           
           while (left < right && (unsorted.get(right).compareTo(unsorted.get(left))<0)) right--;
           if (left < right) swap(unsorted,left++,right);
           else return left;
           
           while (left < right && (unsorted.get(right).compareTo(unsorted.get(left))<0)) left++;
           if (left < right) swap(unsorted,left,right--);
           else return right;
           
       }
       
    }
   public static void quickSortRecursive(ArrayList<Comparable> unsorted,int left,int right)
    {
        int pivot; 
        if (left >= right) return;
        pivot = partition(unsorted,left,right);
        quickSortRecursive(unsorted,left,pivot-1); 
        quickSortRecursive(unsorted,pivot+1,right);
        
    }   
}
