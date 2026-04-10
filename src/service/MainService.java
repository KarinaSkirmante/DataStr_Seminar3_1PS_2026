package service;

import datastr.MyHeap;

public class MainService {

	public static void main(String[] args) {
		MyHeap<Integer> heapForInt = new MyHeap<Integer>();
		
		try
		{
			heapForInt.add(10);// P -> 10
			heapForInt.add(20);// P -> 20, LC -> 10
			heapForInt.add(30);// P -> 30, LC -> 10, RC -> 20
			heapForInt.print();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
