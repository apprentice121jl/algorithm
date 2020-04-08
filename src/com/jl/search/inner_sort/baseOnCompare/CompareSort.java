package com.jl.search.inner_sort.baseOnCompare;

import com.jl.search.BinarySearch;

import java.util.Arrays;

/*
    基于比较排序
 */
public class CompareSort {
	
	public static void main(String[] args) 
	{
		Integer[] arr = {5,0,-1,11,20,2,-2,4,-6,3,-7,-7,8,1};
		QuickSort test = new QuickSort();
		test.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		System.out.println(BinarySearch.binarySearchMethod(-7,arr));

	/*	Integer[] arr = {5,0,-1,20,11,-7,2,-2,4,-6,3,-7,8,1,100,-7,-1};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSortMethod(arr);
		System.out.println(Arrays.toString(arr));*/





		
	}
	
}

/**
 *
 * 冒泡排序
 *
 */
class  BubbleSort extends Sort {

void  bubbleSortMethod(Integer[] arr) {
        //arr.length - 1的目的：一个元素肯定是有序的
        for(int i = 0; i < arr.length - 1; i++) {
            // 每次选出最大的值
            for(int j = 0; j < arr.length - 1 - i ;j++ ) {
                if( arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
}

	/**
	 * 选择排序
	 * 思想： 1.数组分为有序区和无序区两部分；
	 * 	    2.每次选取无序区最小值的坐标，与无序区中的第一个节点做交换；
	 */
	class SelectSort extends Sort{
		
		void selectSortMethod(Integer[] arr) {
			//arr.length - 1的目的：一个元素肯定是有序的
			for(int i = 0; i < arr.length - 1; i++) {
				int temp = i;
				// arr.length-1:因为if语句中j进行了加1
				// 每次选出最小值
				for(int j = i; j < arr.length-1;j++ ) {
					if( arr[temp] > arr[j+1] ){
						temp = j+1;
					}
				}
				
				if(i != temp)// 只有i和temp不等时，才进行交换
				swap(arr,i,temp);
			}
		}
	}
	

	
	/**
	 * 
	 * 插入排序
	 */
	class  InsertSort extends Sort{
		
		void insertSortMethod(Integer[] arr) {
			
			// arr.length-1:因为j加了1
			for(int i = 0; i < arr.length-1; i++) {
				for(int j = i+1;0 < j ; j--) {
					if(arr[j] < arr[j-1]) {
						swap(arr,j-1,j);
					}else {
						break;
					}
				}
			}
			
		}
	}
	
	/**
	 * 
	 * 希尔排序也是一种插入排序
	 * {5,0,-1,20,11,-7,2,-2,4,-6,3,-7,8,1,100,-7,-1}
	 * 当gap==1时，相当于插入排序，即数组前半部分是有序的，后半部分是无序的；
	 *
	 */
	class ShellSort extends Sort{
		void shellSortMethod(Integer[] arr) {
			 int len = arr.length;
		        int temp, gap = len / 2;
		        while (gap > 0) {
		            for (int i = gap; i < len; i++) {
		                temp = arr[i];
		                int preIndex = i - gap;
		                // temp 最后进行赋值到  arr[preIndex + gap]
		                while (preIndex >= 0 && arr[preIndex] > temp) 
		                {
		                	arr[preIndex + gap] = arr[preIndex];
		                    preIndex -= gap;
		                }
		                // 当preIndex+gap等于i时，代表上面while语句没有执行，无需交换 
		                if(!(preIndex + gap == i)) 
		                 arr[preIndex + gap] = temp;
		            }
		            gap /= 2;
		        }
		}
	}


	/**
	 * 快速排序:采用分治法
	 */
	class QuickSort extends Sort{
		
		void  quickSort(Integer[] arr,Integer left,Integer right)
		{
			if( left > right ) // 数组左边下标 > 数组右边下标
			    return;

			/*Random random = new Random();
			int i = random.nextInt(right+1);*/
			
			Integer l = left;
			Integer r = right;
			Integer temp = arr[l];

			while( r != l )// 退出循环的条件为：r == l
			{
				while( l < r )
				{
					// 判断右边比temp小的数值
					if(arr[r] >= temp)
					{
						r--;
					}else{
						break;
					}
				}
				
				while(l < r)
				{
					// 判断左边比temp大的数据
					if(arr[l] <= temp)
					{
						l++;
					}else{
						break;
					}
				}
				
				if( l < r ) // l==r,不进行交换数据
				swap(arr,l,r);
				
			}

			// 按最左位置来取值
		    arr[left] = arr[r];
		    arr[r]=temp;

		    quickSort(arr,left,r-1);
		    quickSort(arr,r+1,right);
		}
	}
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



