package com.jl.search.inner_sort.baseOnCompare;

import java.util.Arrays;

/**
 * JL
 * 2020/4/7  22:05
 **/
public class HeapSort2 {

    public static void main(String[] args) {

        Integer[] arr = {5,0,-1,11,20,2,-2,4,-6,3,-7,-7,8,1};
        int length = arr.length;
        int i;
        // TODO i为何要从length/2开始？
        for(i = length/2;i >= 0;i--){// 从二叉树第一个非叶子结点建立堆
            shift(arr,i,length);
        }
        System.out.println(Arrays.toString(arr));
        for(int j = length-1;j >= 1;j--){// 只需要判断n-1个结点有序
            int tmp=arr[0];
            arr[0] = arr[j];
            arr[j] = tmp;
            shift(arr,0,j-1);
        }
        System.out.println(Arrays.toString(arr));
    }

    static void shift(Integer[] arr,int i,int n){
        int temp = arr[i];
        int parent = i;
        int child = 2*i;

        while(child < n){// 结点在有效范围内
            // 判断右孩子是否存在且大于左孩子
            if(child+1 < n && arr[child] < arr[child + 1]){
                 child++;
            }
            if(temp < arr[child]){// 父节点小于孩子结点
                arr[parent]=arr[child];
                parent = child;
                child = 2*parent;
            }else{
                break;
            }
        }
        arr[parent] = temp;
    }
}
