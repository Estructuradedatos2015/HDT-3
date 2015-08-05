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
   
   private void mergesort(int baja, int alta) 
  {
	  //verificamos que el arreglo sea mayor que 1 porque un arreglo de una sola posicion "ya esta ordenado" 
    if (baja < alta) 
	{
		//Encontramos nuestro valor central
      int centro = (alta - baja) / 2;
	  //Aqui hay que manejar de manera recursiva los elementos del arreglo, no es hasta que 
	  //los valores sean mayor de 1 que se empiezan a ordenar. Es decir hasta entonces llamamos a la función merge
      mergesort(baja, centro);
      mergesort(centro, alta);
      merge(baja, centro, alta);
    }
  }
	//la funcion merge lo que hace es ir colocando de manera ordenada los valores de regreso al arreglo "temporal" que se tiene
	//este arreglo es una sub particion creada para ordenar elementos a una menor escala
  private void merge(int baja, int centro, int alta,ArrayList<Comparable> unsorted) 
  {
   
    for (int posIzquierda = baja; posIzquierda <= alta; posIzquierda++) 
    {
        ArrayList<Comparable> sorted = new ArrayList<>();
    }
	//Creamos un arreglos temporal para poder ordenarlo primero en este arreglo y luego mandarlo ya ordenado al arreglo original.
    int posIzquierda = baja; //el ladro izquierda del sub arreglo 
    int posDerecha = centro; // el lado derecho del sub arreglo 
    int posOriginal = baja; //la posicion real del arreglo  original para poder ir almacenando ahí los valores 

    while (posIzquierda <= centro && posDerecha <= alta) 
    {
        if(unsorted.get(posDerecha).compareTo(unsorted.get(posIzquierda))<0)
        {
        sorted.get(baja) = unsorted.get(posIzquierda);
        posIzquierda++;
	} 
	 else
	{
        sorted.get(baja) = unsorted.get(posDerecha);
        posDerecha++;
	}
        baja++;
    }
	
    while (posIzquierda <= centro)
    {
      sorted.get(baja) = unsorted.get(posIzquierda);
      baja++;
      posIzquierda++;
    }
    while (posDerecha <= centro)
    {
      sorted.get(baja) = unsorted.get(posDerecha);
      baja++;
      posDerecha++;
    }

  }
  
  public int[] getMergeSort()
  {
	  return sorted;
  }
   
   public static ArrayList<Comparable> MergeSorting(ArrayList<Comparable> unsorted)
   {
       
   }
}
