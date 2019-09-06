package com.jl.search.inner_sort.baseNotCompare;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 非比较排序
 */
public class NotCompareSort {

    public static void main(String[] args) {
      /*  // 归并、计数专属
        int[] arr = {5,0,-1,20,11,-7,2,-2,4,-6,3,-7,8,1,100,-7,-1};
        CountingSort mergeSort = new CountingSort();
        int[] mergeSortMethod = mergeSort.countingSortMethod(arr);
        System.out.println(Arrays.toString(mergeSortMethod));*/


        // 桶排序
        int[] arr = {5, 0, -1, 20, 11, -7, 2, -2, 4, -6, 3, -7, 8, 1, 100, -7, -1};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(Integer.valueOf(arr[i]));
        }
        BucketSort mergeSort = new BucketSort();
        ArrayList<Integer> result = mergeSort.bucketSortMethod(arrayList,1);
        for (int i:result) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}




/**
 *  计数排序：一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数
 *  稳定排序
 *  思想：1.查找出要排序数组A的最大值和最小值，并创建一个[最大值 - 最小值 + 1]长度的数组B
 *        2.B数组元素的值代表：A中值与B的坐标相同的元素的个数
 *        3.遍历A数组，并将B中记录的值，排序到A数组中
 *
 */
class CountingSort{

    public int[] countingSortMethod(int[] array){
            if (array.length == 0) return array;
            int bias, min = array[0], max = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] > max)
                    max = array[i];
                if (array[i] < min)
                    min = array[i];
            }
            bias = 0 - min;
            int[] bucket = new int[max - min + 1];
            // 用0填充数组bucket
            Arrays.fill(bucket, 0);
            for (int i = 0; i < array.length; i++) {
                // 下标为array[i] + bias的bucket数组元素记录array数组中值的个数
                bucket[array[i] + bias]++;
            }
            int index = 0, i = 0;
            while (index < array.length) {
                if (bucket[i] != 0) {
                    // 通过坐标记录array数组中的值
                    array[index] = i - bias;
                    // array数组中的重复值减1
                    bucket[i]--;
                    index++;
                } else{
                    // bucket数组中无记录
                    i++;
                }
            }
            return array;
        }
}

/**
 *   桶排序：计数排序的进化
 *
 */
class BucketSort{
    /**
     * @param array
     * @param bucketSize  桶内容器的大小
     * @return
     */
    public  ArrayList<Integer> bucketSortMethod(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        // 桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        // 创建桶数组
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            // 创建桶内的容器
            bucketArr.add(new ArrayList<Integer>());
        }
        // 将元素放入桶内容器
        for (int i = 0; i < array.size(); i++) {
            //  元素放入桶内的容器:
            //  放入数据的时候，桶与桶之间的数据是有序的，桶内容器中的数据是无序的
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }

        ArrayList<Integer> resultArr = new ArrayList<>();
        // 遍历所有的桶
        for (int i = 0; i < bucketCount; i++) {
            // 当桶内容器大小为1时，相当于对数组中的数据进行排序
            if (bucketSize == 1 && bucketArr.get(i).size() != 0) {
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    // 访问桶中容器的数据
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                // 对桶内容器进行排序
                ArrayList<Integer> temp = bucketSortMethod(bucketArr.get(i), 1);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }
}

/**
 * 归并排序：采用分治法
 * 稳定排序
 * {5,0,-1,20,11,-7,2,-2,4,-6,3,-7,8,1,100,-7,-1}
 *
 */
class  MergeSort  {

    public  int[] mergeSortMethod(int[] array) {
        // 数组长度小于2，不再分割数组
        if (array.length < 2) return array;
        int mid = array.length / 2;
        // copy时，区间为[0,mid)
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSortMethod(left), mergeSortMethod(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)// i指向left，超出数组长度直接使用right数组的元素
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
}
