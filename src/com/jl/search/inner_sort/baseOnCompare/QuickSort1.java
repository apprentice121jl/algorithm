package com.jl.search.inner_sort.baseOnCompare;

import java.util.Arrays;

public class QuickSort1 {

    public static void main(String[] args) {
        int[] arr = {5,0,-1,11,20,2,-2,4,-6,3,-7,-7,8,1};
        quickSort123(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort123(int[] arr, int left,int right){

        if(left > right)
            return;
        int l = left;
        int r = right;
        int tmp = arr[left];
        while(l != r){

            while(l < r){
                if(arr[r] >= tmp){
                    r--;
                }else{
                    break;
                }
            }

            while(l < r){
                if(arr[l] <= tmp){
                    l++;
                }else{
                    break;
                }
            }

            if(l < r){
                int replace = arr[l];
                arr[l] = arr[r];
                arr[r]=replace;
            }

        }

        arr[left] = arr[r];
        arr[r] = tmp;
        quickSort123(arr,left,r-1);
        quickSort123(arr,r+1,right);
    }
}
