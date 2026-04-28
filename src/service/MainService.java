package service;

import datastr.MyHeap;
import model.Patient;

public class MainService {

	public static void main(String[] args) {
		
		System.out.println("-----------DARBS AR SKAITĻIEM-----------");
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

		
		
		System.out.println("---------------DARBS AR PACIENTIEM--------------");
		MyHeap<Patient> heapForPatient = new MyHeap<Patient>();
		
		try {
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
			   Laura(30)    Janis(20)
			   /      \      /
			Anna(10) Marta(5) Rihards(7)
			*/

			System.out.println("------------------------------");
			heapForPatient.print();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
