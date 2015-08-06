/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package hoja3;
import java.util.ArrayList;
/**
 *
 * Autores:
 * Diego Rosales
 */
public class Sort {
    
    public static ArrayList<Comparable> SelectionSort(ArrayList<Comparable> unsorted){
        ArrayList<Comparable> sorted = new ArrayList<>();
        int size=unsorted.size();
        for(int i=0; i<size; i++){
            Comparable menor=unsorted.get(0);
            int index=0;
            //este ciclo encuentra el menor que contiene unsorted
            for(int j=1;j<unsorted.size(); j++){
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
            if(unsorted.get(i).compareTo(unsorted.get(i-1))<0){
                int k=0;
                boolean flag;
                do{
                    k++;
                    flag=unsorted.get(i).compareTo(unsorted.get(i-k))<0;
                }while(k<i && unsorted.get(i).compareTo(unsorted.get(i-k))<0);
                
                Comparable val=unsorted.remove(i);
                if(flag){
                    unsorted.add(i-k, val);
                }
                else{
                    unsorted.add(i-k+1, val);
                }
            }
        }
        return unsorted;
    }
    
    
    public static ArrayList<Comparable> QuikSort(ArrayList<Comparable> unsorted){
        quickSortRecursive(unsorted,0,unsorted.size()-1);
        return unsorted;
    }
    private static void swap(ArrayList<Comparable> unsorted,int i,int j)
    {
       ArrayList<Comparable> temp = new ArrayList<>(0);
        ArrayList<Comparable> temp2 = new ArrayList<>(0);
        temp.add(0,unsorted.get(i));
        temp2.add(0,unsorted.get(j));
        //unsorted.remove(i);
        //unsorted.remove(j);
        unsorted.add(i,temp2.get(0));
        unsorted.add(j,temp.get(0));
    
    }
    private static int partition(ArrayList<Comparable> unsorted, int left, int right)
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
    private static void quickSortRecursive(ArrayList<Comparable> unsorted,int left,int right)
    {
        int pivot; 
        if (left >= right) return;
        pivot = partition(unsorted,left,right);
        quickSortRecursive(unsorted,left,pivot-1); 
        quickSortRecursive(unsorted,pivot+1,right);
        
    }   
        public ArrayList<Comparable> MergeSort(ArrayList<Comparable> unsorted)
    {
        ArrayList<Comparable> left = new ArrayList<Comparable>();
        ArrayList<Comparable> right = new ArrayList<Comparable>();
        int center;
 
        if(unsorted.size()==1)
        {    
            return unsorted;
        }
        else
        {
            center = unsorted.size()/2;
            // copy the left half of whole into the left.
            for(int i=0; i<center; i++)
            {
                left.add(unsorted.get(i));
            }
 
            //copy the right half of whole into the new arraylist.
            for(int i=center; i<unsorted.size(); i++)
            {
                right.add(unsorted.get(i));
            }
 
            // Sort the left and right halves of the arraylist.
            left  = MergeSort(left);
            right = MergeSort(right);
 
 
            // Merge the results back together.
            merge(left,right,unsorted);
 
        }
        return unsorted;
    }
 
    private void merge(ArrayList<Comparable> left, ArrayList<Comparable> right, 
            ArrayList<Comparable> unsorted) {
 
        int leftIndex = 0;
        int rightIndex = 0;
        int unsortedIndex = 0;
 
 
        // As long as neither the left nor the right arraylist has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size())
        {
            if ((left.get(leftIndex).compareTo(right.get(rightIndex)))<0) 
            {
                unsorted.set(unsortedIndex,left.get(leftIndex));
                leftIndex++;
            }
            else
            {
                unsorted.set(unsortedIndex, right.get(rightIndex));
                rightIndex++;
            }
            unsortedIndex++;
        }
 
        ArrayList<Comparable>vari;
        int variIndex;
        if (leftIndex >= left.size()) {
            // The left arraylist has been use up...
            vari = right;
            variIndex = rightIndex;
        }
        else {
            // The right arraylist has been used up...
            vari = left;
            variIndex = leftIndex;
        }
 
        // Copy the rest of whichever arraylist (left or right) was
        // not used up.
        for (int i=variIndex; i<vari.size(); i++) {
            unsorted.set(unsortedIndex, vari.get(i));
            unsortedIndex++;
        }
    }
 
    public void show()
    {
        ArrayList<Comparable> sorted = new ArrayList<Comparable>();
        sorted = MergeSort(sorted);
        System.out.println("Sorted:");
        for(int i=0; i<sorted.size();i++)
        {
            System.out.println(sorted.get(i));
        }
 
    }
     public Sort(ArrayList<Comparable> sorted)
    {
        for(int i=0; i<sorted.size(); i++)
        {
            sorted.add(sorted.get(i));
        }
    }
}
