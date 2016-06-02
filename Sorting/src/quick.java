import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Qsort
{
	void QuickSort(int a[], int low, int high)
	{
		if(low<high)
		{
			int p = partition(a,low,high);
			QuickSort(a, low, p-1);
			QuickSort(a, p+1, high);
		}
	}

	int partition(int a[], int low, int high)
	{
		int p=a[low]; // pivot element
		int l=low+1;
		int r=high;

		while(true)
		{
			while(l<=high && p>a[l])
				l++;

			while(p<a[r])
				r--;

			if(l<r)
			{
				int t=a[l];
				a[l]=a[r];
				a[r]=t;
			}
			else
			{
				a[low]=a[r];
				a[r]=p;
				break;
			}
		}
		return r;
	}
	
	void QS_Stack(int a[], int low, int high)
	{
		if(low<high)
		{
			Stack<Integer> l=new Stack<Integer>();
			Stack<Integer> h=new Stack<Integer>();
			l.push(low);
			h.push(high);

			while(!l.empty())
			{
				low=l.pop();
				high=h.pop();

				int p= partition(a, low, high);
				if(p+1 < high)
				{
					l.push(p+1);
					h.push(high);
				}

				if(low < p-1)
				{
					l.push(low);
					h.push(p-1);
				}
			}
		}
	}
}

class quick
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements for quick sort");
		int n=sc.nextInt();

		int a[]=new int[n];
		Qsort q = new Qsort();
		
		System.out.println("Enter elements for sorting:");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();


		System.out.println("\nQuick Sort");
		q.QuickSort(a,0,a.length-1);
		
		for(int i:a){
            System.out.print(i);
            System.out.print(" ");
        }
		
		System.out.println("\n\nEnter elements for sorting:");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
        
		System.out.println("\nQuick Sort using Stack");
		q.QS_Stack(a,0,a.length-1);
		
		for(int i:a){
            System.out.print(i);
            System.out.print(" ");
        }


	}
}