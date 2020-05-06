package com.jl.search.inner_sort.baseOnCompare;

import java.util.List;

/**
 * JL
 * 2020/4/28  16:33
 **/
public class SortLinkedList {
    public static void main(String[] args) {
        List<Integer> listI=null;
        int[] arr = changeArr(listI);
        if(arr == null) return;
        for(int i = arr.length/2-1;i >= 0;i--){
            shift(arr,i,arr.length -1);
        }
        int j = arr.length -1;

        while(j > 0){
            int tmp=arr[0];
            arr[0] = arr[j];
            arr[j] = tmp;
             shift(arr,0,--j);
        }

        int m = 10;
        int i = 0;
        int arri=0;
        int before = 0;
        while( i < m && arri < arr.length) {

            if(arri != 0 && arr[arri] != before ){
                System.out.print(arr[arri]+" ");
                before = arr[arri];
                i++;
            }else if(arri == 0){
                System.out.print(arr[arri]+" ");
                i = 1;
                before = arr[arri];
            }
            arri++;

        }


    }

    public static void  shift(int[] arr,int parent,int length){

        int child = 2*parent+1;
        int temp = arr[parent];
        while(child < length){
                if (child + 1 <= length && arr[child + 1] > arr[child]) {
                    child++;
                }
                if(temp >  arr[child]){
                    arr[parent] = arr[child];
                    parent = child;
                    child = 2*parent+1;
                }else{
                    break;
                }
            }
            arr[parent] = temp;
        }


    public static  int[] changeArr(List<Integer> listI){
        if(listI == null || listI.size() <= 0) return null;
        int[] arr = new int[listI.size()];
        int i = 0;
        for (Integer e:listI) {
            arr[i++]  = e;
        }
        return arr;
    }
}
