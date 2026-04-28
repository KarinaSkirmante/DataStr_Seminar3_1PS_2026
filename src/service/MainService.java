package service;

import datastr.MyHeap;

public class MainService {

	public static void main(String[] args) {
		MyHeap<Integer> heapForInt = new MyHeap<Integer>();

		try {
			heapForInt.add(10);
			/*
			      10
			*/

			heapForInt.add(20);
			/*
			      20
			     /
			   10
			*/

			heapForInt.add(30);
			/*
			      30
			     /  \
			   10    20
			*/

			heapForInt.add(50);
			/*
			        50
			       /  \
			     30    20
			    /
			  10
			*/

			heapForInt.add(5);
			/*
			        50
			       /  \
			     30    20
			    /  \
			  10    5
			*/

			heapForInt.add(7);
			/*
			        50
			       /  \
			     30    20
			    / \   /
			  10   5 7
			*/

			heapForInt.add(3);
			/*
			        50
			       /  \
			     30    20
			    / \   / \
			  10   5 7   3
			*/

			heapForInt.add(4);
			/*
			          50
			        /    \
			      30      20
			     / \     / \
			   10   5   7   3
			  /
			 4
			*/

			heapForInt.add(6);
			/*
			          50
			        /    \
			      30      20
			     / \     / \
			   10   5   7   3
			  / \
			 4   6
			*/

			heapForInt.add(55);
			/*
			          55
			        /    \
			      50      20
			     / \     / \
			   10   30  7   3
			  / \   /
			 4   6 5
			*/

			heapForInt.print();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
