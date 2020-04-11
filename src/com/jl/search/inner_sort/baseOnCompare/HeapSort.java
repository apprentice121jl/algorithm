package com.jl.search.inner_sort.baseOnCompare;

import java.util.Arrays;

/**
 * JL
 * 2020/4/7  22:05
 * 不稳定排序
 * 堆排序：每个结点的值都大于其左孩子和右孩子结点的值，称之为大根堆；
 *	      每个结点的值都小于其左孩子和右孩子结点的值，称之为小根堆；
 *
 *  堆排序分为两个过程：
 *          1.创建堆     O(n)
 *          2.对堆的调整  O(nlgn)
 **/
public class HeapSort {

    public static void main(String[] args) {

        Integer[] arr = {5,0,-1,11,20,2,-2,4,-6,3,-7,-7,8,1};
        int length = arr.length;
        int i;
        for( i = (length/2)-1;i >= 0;i-- ){// 从二叉树第一个非叶子结点建立堆
            // 树的底部开始建树，根节点是最大值
            shift(arr,i,length);
        }

        System.out.println(Arrays.toString(arr));


        int  j = length-1;
        while(j >= 1){

            int tmp=arr[0];
            arr[0] = arr[j];
            arr[j] = tmp;

            // 从根节点开始调整，由于建堆的时候已经有序，所以可以从根节点开始
            shift(arr,0,--j);

        }
        System.out.println(Arrays.toString(arr));
    }

    //
    static void shift(Integer[] arr,int i,int length){// 每次获得的根都是最大值

        int temp = arr[i];

        int parent = i;
        int child = 2*i+1;

        while(child < length){// 结点在有效范围内
            // 判断右孩子是否存在且大于左孩子
            if(child+1 < length && arr[child] < arr[child + 1]){
                 child++;
            }
            if(temp < arr[child]){// 父节点小于孩子结点
                arr[parent]=arr[child];
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
        arr[parent] = temp;
    }
}
