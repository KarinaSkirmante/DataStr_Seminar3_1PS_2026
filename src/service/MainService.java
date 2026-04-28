package service;

import datastr.MyHeap;
import model.Patient;

public class MainService {

	public static void main(String[] args) {
		
		System.out.println("-----------DARBS AR SKAITĻIEM-----------");
		MyHeap<Integer> heapForInt = new MyHeap<Integer>();

		try {
			System.out.println("--------ELEMENTU PIEVIENOŠANA---------------");
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
			
			System.out.println("MAX element: " + heapForInt.getMaxElement());//55
			/*
	          50
	        /    \
	      30      20
	     / \     / \
	   10   5   7   3
	  / \   
	 4   6 
	*/
			System.out.println("--------ELEMENTU IZŅEMŠANA---------------");
			System.out.println("MAX element: " + heapForInt.getMaxElement());//50
			/*
	          30
	        /    \
	      10      20
	     / \     / \
	    6   5   7   3
	  /    
  	 4    
	*/	
			System.out.println("MAX element: " + heapForInt.getMaxElement());//30
			/*
	          20
	        /    \
	      10      7
	     / \     / \
	    6   5   4   3
	      
	    
	*/			
			System.out.println("MAX element: " + heapForInt.getMaxElement());//20
			/*
	          10
	        /    \
	      6      7
	     / \     / 
	    3   5   4   
	      
	    
	*/	
			heapForInt.print();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		
		System.out.println("---------------DARBS AR PACIENTIEM--------------");
		MyHeap<Patient> heapForPatient = new MyHeap<Patient>();
		
		try {
			System.out.println("--------ELEMENTU PIEVIENOŠANA---------------");
			heapForPatient.add(new Patient("Anna", "Berzina", 10));
			/*
			      Anna(10)
			*/

			heapForPatient.add(new Patient("Janis", "Kalnins", 20));
			/*
			      Janis(20)
			     /
			   Anna(10)
			*/

			heapForPatient.add(new Patient("Laura", "Ozola", 30));
			/*
			      Laura(30)
			     /       \
			   Anna(10)  Janis(20)
			*/

			heapForPatient.add(new Patient("Peteris", "Liepa", 50));
			/*
			        Peteris(50)
			       /          \
			   Laura(30)    Janis(20)
			   /
			Anna(10)
			*/

			heapForPatient.add(new Patient("Marta", "Eglite", 5));
			/*
			        Peteris(50)
			       /          \
			   Laura(30)    Janis(20)
			   /      \
			Anna(10) Marta(5)
			*/

			heapForPatient.add(new Patient("Rihards", "Krumins", 7));
			/*
			        Peteris(50)
			       /          \
			   Laura(30)      Janis(20)
			   /      \        /
			Anna(10) Marta(5) Rihards(7)
			*/

			System.out.println("------------------------------");
			heapForPatient.print();
			System.out.println("--------ELEMENTU IZŅEMŠANA---------------");
			System.out.println("MAX element: " + heapForPatient.getMaxElement());//Peteris (50)
			/*
	        Laura(30)
	       /          \
	   Anna(10)      Janis(20)
	   /      \        
	Rihards(7) Marta(5) 
	*/
			System.out.println("MAX element: " + heapForPatient.getMaxElement());//Laura (30)
			/*
	        Janis(20)
	       /          \
	   Anna(10)      Marta(5)
	   /              
	Rihards(7) 
	*/
			heapForPatient.print();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
