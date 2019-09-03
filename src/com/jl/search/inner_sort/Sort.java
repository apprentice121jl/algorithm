package com.jl.search.inner_sort;

public abstract class Sort {

	void swap(Integer[] arr,Integer bef,Integer aft)
	{
		Integer temp;
		temp = arr[bef];
		arr[bef] = arr[aft];
		arr[aft] = temp;
	}
}
