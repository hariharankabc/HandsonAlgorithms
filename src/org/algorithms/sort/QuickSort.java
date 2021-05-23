package org.algorithms.sort;

public class QuickSort {
	
	/**
	 * 
	 * Sample input
	 * int[] Arr = {5,4,3,1,8,10,2,7,6,9}
	 * quickSort(Arr, 0, Arr.length-1)
	 */
	
	public static void quickSort(int[] Arr, int p, int r) {
		if (p < r) {
			int q = partition(Arr, p, r);
			quickSort(Arr, p, q-1);
			quickSort(Arr, q+1, r);
		}
		
	}
	
	public static int partition(int[] Arr, int p, int r) {
		int i = p - 1;
		int x = Arr[r];
		for(int j= p; j< r;j++) {
			if(Arr[j]<=x) {
				i += 1;
				swap(Arr,i ,j);
			}
		}
		swap(Arr, i+1, r);
		printArray(Integer.toString(i+1), Arr);
		return i+1;
	}
	
	public static void swap(int[] Arr, int p, int r) {
		int tempVal = Arr[p];
		Arr[p] = Arr[r];
		Arr[r] = tempVal;
	}
	
	public static void printArray(String title, int Arr[]) {
		System.out.println(title);
		for(int i: Arr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println("");
	}


}
