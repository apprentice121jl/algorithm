package com.jl.merge;

import java.util.Arrays;

/**
 * JL
 * 2020/4/1  19:59
 * 合并两个有序数组：注意下标
 **/
public class TestMerge {

    public static void main(String[] args) {
        int[] arrX = {1, 4, 12, 56, 67};
        int[] arrY = {2, 5, 11, 27, 32, 40};


        int arrL = arrX.length + arrY.length;
        int[] arr = new int[arrL];

        int  j = 0,i= 0,num =0;

        while(j< arrX.length && i < arrY.length){
            if(arrX[j] >= arrY[i]){
                System.out.println("i = " +i);
                arr[num++] =  arrY[i++];
            }else{
                System.out.println("j = " +j);
                arr[num++] =  arrX[j++];
            }
        }
        System.out.println(i +"   "+j +"   "+ num);

        num--;

        if(j < arrX.length){
            while(j<arrX.length ){
                arr[num++] = arrX[j++];
            }
        }
        if(i < arrY.length){
            while(i<arrY.length ){
                arr[num++] = arrY[i++];
            }
    }
    System.out.println(Arrays.toString(arr));
    }
}


