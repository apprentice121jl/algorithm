package com.jl.sort.com.jl.sort.inner_sort.com.jl.find;

public class BinarySearch {
	
	
	public static void main(String[] args) {
		
		Integer[] array = new Integer[10];
		for(int i = 0;i < array.length;i++)
		{
			array[i] = i;
		}
		Integer index = binarySearchMethod(6,array);
		System.out.println(index); 
	}
	
	
	
	/**
	 * 二分查找
	 * @param i
	 * @param arr
	 * @return
	 */
	public static Integer  binarySearchMethod(Integer i,Integer[] arr){
		Integer right = arr.length-1;
		Integer left = 0;
		while(right >= left)
		{
			Integer midLocation = (right + left)/2; 
			if(arr[midLocation] > i)
			{
				right = midLocation - 1;
			}else if(arr[midLocation] < i){
				left = midLocation + 1;
			}else if(arr[midLocation] == i){
				return midLocation;
			}
		}
		return -1;
	}
	
}
	




