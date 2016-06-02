import java.util.*;
class bucket
{
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the no of elements for bucket sort");
	    int n=sc.nextInt();
	    int a[]=new int[n];
	    System.out.println("Enter elements for sorting:");
	    for(int i=0;i<n;i++)
		    a[i]=sc.nextInt();
	    
		bucketSort(a);
		System.out.println();

	}

	public static void bucketSort(int a[])
	{
		

	System.out.println();
	for(int i=0;i<a.length;i++)
		System.out.println("a["+i+"] = " + a[i]);
	int max = a[0];
	for(int i=0;i<a.length;i++)
	{
		if(a[i]>max)
			max=a[i];
	}
	
	System.out.println(max);
  
	int b[]=new int[max+1];
	int c=0;

	for(int i=0;i<a.length;i++)
	{
		for(int j=0;j<b.length;j++)
		{
			if(a[i]==j)
				b[j]=c++;
		}
	}
	//			for(int i=0;i<b.length;i++)	
	//			{
	//				while(b[i]!=0)
	//				{
	//					System.out.println(i);
	//					i--;
	//				}
	//			}
	for(int i=0;i<a.length;i++)
		System.out.print(a[i]+ "\t");
	}


}	
