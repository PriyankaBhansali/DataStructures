package testpack;

public class Factorial {

	public static void main(String[] args) {
		System.out.println("Factorial Using Iteration " + factorial(4));
		System.out.println();
		System.out.println("Factorial Using Recurssion " + fact(4));
		
	}

	public static int factorial(int n) {

		int fact = 1;

		while(n!=0)
		{
			fact = fact * n; 
			n--;
		}
		return fact;
	}

	public static int fact(int n) 
	{
		if(n==0) 
			return 1;
		else
		{
			int z = n * fact(n-1); 
			return z;
		}
	}
}
