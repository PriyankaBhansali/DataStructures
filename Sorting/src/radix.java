import java.util.Scanner;
class RSort
{
	void radixSort(int a[])
	{
		int m=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i]>m)
				m=a[i];
		}

		int exp=1;

		while(exp<=m)
		{
			int buck[]=new int[10];
			for(int i=0;i<a.length;i++)
				++buck[a[i]/exp%10];

			for(int i=0;i<10;i++)
				buck[i]=buck[i-1];

			int b[]=new int[a.length];
			for(int i=a.length-1; i>=0; i--)
				b[--buck[a[i]/exp%10]]=a[i];

			System.arraycopy(b, 0, a, 0, b.length);
			exp*=10;
		}
	}
}



class radix_sort
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements for radix sort");
		int n=sc.nextInt();
		RSort r = new RSort();
		int a[]=new int[n];

		System.out.println("Enter elements for sorting:");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();

		System.out.println("Radix Sort");
		r.radixSort(a);

		


	}
}