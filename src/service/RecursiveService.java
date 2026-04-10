package service;

public class RecursiveService {

	public static void main(String[] args) {
		System.out.println("--------REKURSIJA KĀ VOID---------");
		function1(1);
		
		System.out.println("--------REKURSIJA AR ATGRIEZTO VĒRTĪBU---------");
		int result = function2(1);
		System.out.println(result);
	}
	
	
	public static void function1(int N) {
		if(N < 10)
		{
			System.out.println("N vērtība: " + N);
			function1(N+1);
		}
	}
	
	public static int function2(int N) {
		if(N < 10) {
			System.out.println("N vērtība: " + N);
			return (N + function2(N+1));
		}
		else {
			return N;
		}
	}

}
