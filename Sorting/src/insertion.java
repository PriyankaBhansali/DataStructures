import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
class ISort
{
	int a[];

	ISort(int n)
	{
		a=new int[n];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
	}

	void insertionSort()
	{
		int i,k,y;
		for(k=1;k<a.length;k++)
		{
			y=a[k];
			for(i=k-1;i>=0 && a[i]>y; i--)
				a[i+1]=a[i];

			a[i+1]=y;
			System.out.println(Arrays.toString(a));
		}

		for(i=0;i<a.length;i++)
			System.out.print(a[i]+ "\t");
	}



	
}
class insertion
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements for insertion sort");
		int n=sc.nextInt();

		ISort s = new ISort(n);
		System.out.println();

		System.out.println("Insertion Sort");
		s.insertionSort();
		System.out.println();

	}
}