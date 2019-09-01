package com.jl.sort.com.jl.sort.inner_sort;

public abstract class Sort {

	void swap(Integer[] arr,Integer bef,Integer aft)
	{
		Integer temp;
		temp = arr[bef];
		arr[bef] = arr[aft];
		arr[aft] = temp;
	}
}
