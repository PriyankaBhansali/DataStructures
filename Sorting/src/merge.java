import java.util.Scanner;
class MSort
{
	int a[];

	void mergeSort(int a[], int low, int high)
	{
		if(low<high)
		{
			int mid=(low+high)/2;
			System.out.println("mid" +mid);
			mergeSort(a,low,mid);
			mergeSort(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}	
	
	void merge(int a[], int low, int mid, int high)
	{
		int k=0;
		int i=low;
		int j=mid+1;
		int t[]=new int[high-low+1];

		while(i<=mid && j<=high)
			// compare a[i] with a[j] and then assign value to t[k]. 
			//Last increment value of k(k++)
			t[k++]=a[i] < a[j]? a[i++] : a[j++]; 

			while(i<=mid)
				t[k++]=a[i++];

			while(j<=high)
				t[k++]=a[j++];

			System.arraycopy(t, 0, a, low, t.length);
	}	
}

class merge
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of elements for merge sort");
		int n=sc.nextInt();
		int a[]=new int[n];
		
		MSort ms = new MSort();
		System.out.println();

		System.out.println("Enter elements for sorting:");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();

		System.out.println("Merge Sort");
		ms.mergeSort(a,0,a.length-1);

		for(int i=0;i<n;i++)
			System.out.println(a[i]);


	}
}