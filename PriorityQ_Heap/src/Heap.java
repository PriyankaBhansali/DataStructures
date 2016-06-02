import java.util.*;
import java.io.*;

class MinHeap { 
	int a[];
	int index=-1;

	MinHeap()
	{
		a=new int[5];
	}

	MinHeap(int n)
	{
		a=new int[n];
	}

	boolean empty()
	{
		return index == -1;
	}
	
	void addMin(int v) throws Exception
	{
		if(index==a.length-1)
			throw new Exception("Full");
		else
		{
			int i = ++index;
			for(;i>0 &&a[(i-1)/2]>v;i=(i-1)/2)
				a[i]=a[(i-1)/2];

			a[i]=v;
		}
	}
	//always deletes the element having minimum value at the parent root
	int delMin() throws Exception
	{
		if(index==-1)
			throw new Exception("Empty");
		else
		{
			int v=a[0];
			int t=a[index--];

			for(int i=1; i<index; i=2*i+1)
			{
				if((i+1)<=index && a[i]>a[i+1])
					i++;
				if(a[i]<t)
					a[(i-1)/2]=a[i];
				else
				{	
					a[(i-1)/2]=t;
					break;
				}
			}
			return v;
		}
	}

	void display()
	{
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]+" ");
	}
}

class Demo
{
	public static void main(String[] args) throws Exception
	{
		// Scanner sc = new Scanner(System.in);
		MinHeap x = new MinHeap();
		x.addMin(10);
		x.addMin(15);
		x.addMin(20);
		x.addMin(5);
		x.addMin(8);
		x.display();
		System.out.println();
		
		while(!x.empty())
			System.out.println(x.delMin());
	}
}
