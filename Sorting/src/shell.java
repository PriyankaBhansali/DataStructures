import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
class SSort
{
	int a[];

	SSort(int n)
	{
		a=new int[n];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
	}

	void shellSort()
	{
		int gap,i,k,y;
		for(gap=a.length/2; gap>=1; gap/=2)
		{
			for(k=gap; k<a.length; k++)
			{
				y=a[k];
				for(i=k-gap; i>=0 && y<a[i]; i-=gap)
					a[i+gap]=a[i];

				a[i+gap]=y;
			}
		}

		for(i=0;i<a.length;i++)
			System.out.print(a[i]+ "\t");
	}


	
}
class shell_sort
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements for shell sort");
		int n=sc.nextInt();

		SSort sh = new SSort(n);
		System.out.println();

		System.out.println("Shell Sort");
		sh.shellSort();
		System.out.println();
	}
}