package com.jl.sort.com.jl.sort.inner_sort;

import com.jl.sort.com.jl.sort.inner_sort.com.jl.find.BinarySearch;

import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) 
	{
		/*Integer[] arr = {5,0,-1,11,20,2,-2,4,-6,3,-7,-7,8,1};
		QuickSort test = new QuickSort();
		test.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		System.out.println(BinarySearch.binarySearchMethod(-7,arr));*/

	/*	Integer[] arr = {5,0,-1,20,11,-7,2,-2,4,-6,3,-7,8,1,100,-7,-1};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSortMethod(arr);
		System.out.println(Arrays.toString(arr));*/
		
		
		// 归并专属
		int[] arr = {5,0,-1,20,11,-7,2,-2,4,-6,3,-7,8,1,100,-7,-1};
		MergeSort bubbleSort = new MergeSort();
		int[] mergeSortMethod = bubbleSort.mergeSortMethod(arr);
		System.out.println(Arrays.toString(mergeSortMethod));
		
	}
	
}

/**
 *
 * 冒泡排序
 *
 */
class  BubbleSort extends Sort{

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
	 * 归并排序：采用分治法
	 * 稳定排序
	 * {5,0,-1,20,11,-7,2,-2,4,-6,3,-7,8,1,100,-7,-1}
	 * 
	 */
	class  MergeSort extends  Sort{
		
		
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
			if( left > right )
			    return;
			
			Integer l = left;
			Integer r = right;
			Integer temp = arr[l]; 
			while( r != l )// 退出循环的条件为：r == l
			{
				while( r > l )
				{
					// 判断比temp小的数值
					if(arr[r] >= temp)
					{
						r--;
					}else{
						break;
					}
				}
				
				while(l < r)
				{
					// 判断比temp大的数据
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
			
		    arr[left] = arr[r];
		    arr[r]=temp;
		    quickSort(arr,left,r-1);
		    quickSort(arr,r+1,right);
		}
	}
	
	/**
	 * 堆排序：每个结点的值都大于其左孩子和右孩子结点的值，称之为大根堆；
	 *       每个结点的值都小于其左孩子和右孩子结点的值，称之为小根堆；
	 */
	class  HeapSort extends Sort{
		
		public void heapSortMethod(Integer[] arr) {
			buildHeap(arr);
			int i = 0;
			while(i < arr.length - 1) {
				// 将根节点和最后一个值进行交换
				swap(arr,0,arr.length-1-i);
				i++;
				// 调整大根堆
				heapAdjustment (arr,arr.length - 1- i);
			}
		}
		
		/**
		 * 调整大根堆
		 * @param arr
		 * @param arrLength
		 */
		private void  heapAdjustment(Integer[] arr,int arrLength) {
			int index = 0;      // 指向错误的大根堆
			int leftChild = 1;  // 2*index + 1
			int rightChild = 2; // 2*index + 2
			int largestNum = 0;
			while(leftChild <= arrLength) {
				if(rightChild <= arrLength && arr[leftChild] < arr[rightChild]) {// 左孩子和右孩子相比较，右孩子大
					largestNum = rightChild;
				}else if(arr[index] < arr[leftChild]){ // 上面不满足时，右节点不存在或者左节点比右节点大 
					largestNum = leftChild;
				}else {
					break;// 已经是最大根节点
				}
				swap(arr, largestNum, index);
				index = largestNum;
				leftChild = 2*index +1;
				rightChild = 2*index +2;
			}
		}
		/**
		 * 构建大根堆
		 * @param arr
		 */
		private void  buildHeap(Integer[] arr) {
			// i=1:只有一个节点时，一定是大根堆
			for(int i = 1;i < arr.length; i++) {
				int j = i;
				// 只与父节点进行比较，所以左孩子和右孩子是无序的
				// 父节点坐标：(j-1)/2
				while(0 < j && arr[(j-1)/2] < arr[j]) {
					swap(arr, (j-1)/2, j);
					// 继续查找比当前节点大的父节点
					j = (j-1)/2;
				}
			}
		}
	/*	
	  // TODO 堆排序查询如何做
	  public int queryElement(Integer[] arr,int element) {
		  Integer result = null;
		  for(int i = 0;i < arr.length && 2*i+2 < arr.length;i++) {
			  if(arr[i] == element) {
				  result = i;
				  break;
			  }
			 
			  
		  }
		  return result;
	  }*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



