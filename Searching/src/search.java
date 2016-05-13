import java.util.Scanner;

class Search
{
	int a[];

	Search(int n)
	{
		a=new int[n];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
	}

	int linear(int v) // also called as sequential search
	{
		int i=0;
		while(i<a.length && a[i]!=v)
			i++;

		if(i<a.length && a[i]==v)
			return 1;
		else 
			return -1;
	}


	void sort()
	{
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=0;j<a.length-1;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}

		for(int i=0;i<a.length;i++)
		System.out.print(a[i]+ "\t");
		System.out.println();
	}
	
	
	int linearOrder(int v)
	{
		sort();
	
		int i=0;
		while(i<a.length && a[i]<v)
			i++;

		if(i<a.length && a[i]==v)
			return 1;
		else 
			return -1;
		
	}
	
	
	int binary(int v)   // .... works only for sorted arrays
	{
		int low=0, high=a.length-1;
		while(low<=high)
		{
			int mid = low+(high-low)/2;
			if(a[mid]==v)
				return mid;
			else
				if(a[mid]>v)
					high=mid-1;
				else
					low=mid+1;
		}
		return -1;
	}
}


class Demo
{
	public static void main(String[] args) 
	{
		int f;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n=sc.nextInt();

		Search s = new Search(n);
		
		System.out.println("Enter the vale to be searched");
		int v=sc.nextInt();

		System.out.println();
		System.out.println("Linear/Sequential Search");
		f = s.linear(v);
		if(f==-1)
			System.out.println("Not Found");
		else
			System.out.println("Found");	

		System.out.println("LinearOrder Search");
		f = s.linearOrder(v);
		if(f==-1)
			System.out.println("Not Found");
		else
			System.out.println("Found");	
		
		System.out.println("Enter the vale to be searched");
		v=sc.nextInt();
		
		System.out.println("Binary Search");
		f = s.binary(v);
		if(f==-1)
			System.out.println("Not Found");
		else
			System.out.println("Found");
		
	}
}