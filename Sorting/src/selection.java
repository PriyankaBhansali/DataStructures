import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
class Selsort
{
	int a[];

	Selsort(int n)
	{
		a=new int[n];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
	}

	void selectionSort()
	{
		int s;
		for(int i=0;i<a.length-1;i++)
		{
			s=i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[s]>a[j])
					s=j;
			}
			int t = a[s];
			a[s]=a[i];
			a[i]=t;
			System.out.println(Arrays.toString(a));
		}

		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+ "\t");
	}


}
class selection
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements for selection sort");
		int n=sc.nextInt();

		Selsort sel = new Selsort(n);
		System.out.println();

		System.out.println("Selection Sort");
		sel.selectionSort();
		System.out.println();

		
	}
}