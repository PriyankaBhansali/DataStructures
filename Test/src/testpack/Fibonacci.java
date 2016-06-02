package testpack;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("final fibonacci value" + fibonacci(12));

		System.out.println();
		System.out.println("Using Recurssion");
		for (int i = 0; i < 12; i++) {
			System.out.print(fibo(i) + " ");
		}
	}

	public static int fibonacci(int n) {

		int fibo1=0, fibo2=1, fibo = 0;

		for(int i= 0; i< n; i++){

			if(i<=1)
				fibo = i;
			else
			{
				fibo = fibo1 + fibo2; 
				System.out.println(fibo);
				fibo1 = fibo2;
				fibo2 = fibo;
			}
		}
		return fibo; 
	}


	public static int fibo(int n) //nth fibonacci number
	{
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		else
		{	
			return fibo(n-1) + fibo(n-2);
			//return z;
		}
	}

}
