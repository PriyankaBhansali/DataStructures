import java.util.Arrays;
/**
 * 
 */

/**
 * @author PriyankaBhansali
 *
 */
class Rec {

	int triangular (int n)
	{
		if (n==0)
			return 0;
		else
		{
			int z = n + triangular(n-1);
			return z;
		}
	}
	
	int fact(int n) // factorial of a number
	{
		if(n==0) //Base component
			return 1;
		else
		{
			int z = n * fact(n-1); //Recursive component
			// or.. n * fact(--n), fact(--n) * n
			return z;
		}
	}

	int fibo(int n) //nth fibonacci number
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

	int fibo1(int n) //nth fibonacci number
	{
		int a=0,b=1,c=0;
		for(int i=0;i<n;i++)
		{
			c=a+b;
			a=b;
			b=c;
		}
		
		
	return c;
	
	}
	String reverse (String s) //reverse of a string
	{
		if(s.length()==0)
			return "";
		else 
		{
			//System.out.println(s.substring(1));
			//System.out.println(s.charAt(0));
			String z = reverse(s.substring(1)) + s.charAt(0);
			return z;
		}
	}

	int gcd(int m, int n)
	{
		if( m%n == 0 )
			return n;
		else 
		{
			int r = m % n;
			m=n;
			n=r;
			int z = gcd(m,n);
			return z;
		}
	}

	int gcdDjakstra(int m, int n)
	{
		if(m==n)
			return m;
		else
		{
			if(m<n)
				return gcdDjakstra(m,n-m);
			else
				return gcdDjakstra(m-n,n);
		}
	}

	// Tower Of Hanoi
	int tower(int n, char s, char a, char t) // to count number of shifts
	{
		if(n==1)
		{
			System.out.println(" Shift "+ n +" from "+ s +" to "+ t);
			return 1;
		}
		else
		{
			int x = tower(n-1,s,t,a);
			System.out.println(" Shift "+ n +" from "+ s +" to "+ t);
			int y = tower(n-1,a,s,t);
			return x+y+1;
		}
	}
	
	boolean isSorted(int data[], int n) 
	{
		  // Null or less then 2 elements is sorted.
		if (data == null || n < 2) 
			return true;
		
		else if (data[n - 2] > data[n - 1]) 
		   return false;
		
		  // recurse.
	  return isSorted(data, n - 1);
	}
	
}	

class NbitsStrings {
	int[] arrA;

	public NbitsStrings(int n) {
		arrA = new int[n];
	}

	public void nBits(int n) {
		if (n <= 0) {
			System.out.println(Arrays.toString(arrA));
		} else {
			arrA[n - 1] = 0;
			nBits(n - 1);
			arrA[n - 1] = 1;
			nBits(n - 1);
		}
	}
}



class NQueen // display N-Queens - Backtracking
{
	int a[];

	public NQueen(int n) 
	{
		if(n<3)
		{
			try
			{
				throw new Exception("NQueens can't be less than 3");
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		else
			a = new int[n];
	}

	boolean verifyQueen(int r)
	{	System.out.println(r);
		for(int i=0;i<r; i++)
		{
			System.out.println(a[i] + " " + a[r] + " " + Math.abs(i-r) + " " + Math.abs(a[i]-a[r]));
			if(a[i]==a[r] || Math.abs(i-r) == Math.abs(a[i]-a[r]))
			{
				System.out.println(a[i] + "   " +a[r]);
				return false;
			}
		}
		return true;
	}

	void print()
	{
		for(int i=0; i<a.length; i++)
			System.out.println(i+" " + a[i]+ ", ");
	}
	
	void Nqueen(int r)
	{
		for (int i=0; i<a.length; i++)
		{
			a[r]=i;
			System.out.println("a[r]= " + a[r] + " i " + i + " r " + r);
			System.out.println();
			if(verifyQueen(r))
			{	System.out.println("r = " +r);
				if(r+1<a.length)
					Nqueen(r+1);
				else
					print();
			}
		}
	}

}

class NQueens {

	int result[];
	
	public NQueens(int n) {
		if(n<3) {
			System.out.println("NQueens can't be less than 3!");
		} else {
			result = new int[n];
		}
	}
	
	boolean verifyQueen(int row, int col) {
		for(int prevRow=0; prevRow<row; prevRow++) {
			if(result[prevRow]==col || Math.abs(prevRow-row)==Math.abs(result[prevRow]-col)) {
				return false;
			}
		}
		return true;
	}

	void NQueen(int row) {
		for(int col=0; col<result.length;col++) {
			if(verifyQueen(row,col)) {
				result[row]=col;
				//System.out.println(row);
				if(row+1 < result.length) {
					NQueen(row+1);				
				} else {
					System.out.println(Arrays.toString(result));
				}
			}
		}
	}
}



class Demo
{
	public static void main(String[] args) throws Exception 
	{
		Rec x = new Rec();
		System.out.println("Triangular numbers:  " + x.triangular(5));
		System.out.println();
		System.out.println("Factorial is  " + x.fact(5));
		System.out.println();
		for (int i = 0; i <= 12; i++) 
			{
	           System.out.print(x.fibo(i) + " ");
	        }
		System.out.println();
		System.out.println("Fibonacci is  " + x.fibo(12));
		System.out.println();
		System.out.println("Reverse is  " + x.reverse("hello"));
		System.out.println();
		System.out.println("GCD of 2 numbers is  " + x.gcd(54,24));
		System.out.println();
		System.out.println("GCD by Djakstra method is  " + x.gcdDjakstra(54,24));
		System.out.println();
		System.out.println("Tower of Hanoi  " + x.tower(3,'A','B','C'));
		System.out.println();
		
		int data[] = {1,2,3};
		System.out.println(Arrays.toString(data) //
		      + (x.isSorted(data, data.length) ? " Sorted" : " Unsorted"));
		
		data = new int[] {3,2,1};
		System.out.println(Arrays.toString(data) //
		      + (x.isSorted(data, data.length) ? " Sorted" : " Unsorted"));
		
		System.out.println();
		
		
		System.out.println();
		
		NbitsStrings nb = new NbitsStrings(4);
		nb.nBits(4);
		System.out.println();
		
		NQueen q = new NQueen(4);
		q.Nqueen(0);
		System.out.println();
		
		System.out.println("---Start---");
		NQueens nQueen = new NQueens(4);
		nQueen.NQueen(0);
		System.out.println("---End---");
	}
}
