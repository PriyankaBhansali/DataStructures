import java.util.Scanner;

class patternMatching
{

	int BruteForce(String s, String p)
	{
		char a[]= s.toCharArray();
		char b[]=p.toCharArray();

		for(int i=0;i<a.length;i++)
		{   
			int j;
			for(j=0;j<b.length;j++)
			{
				if(a[i+j]!=b[j])
					break;
			}
			if(j==b.length)
				return i;
		}
		return -1;
	}

	int BoyerMore(String s, String p)
	{
		char a[]= s.toCharArray();
		char b[]=p.toCharArray();
		int i=a.length-1;
		int j=b.length-1;

		while(i<a.length)
		{
			if(a[i]==b[j])
			{
				if(j==0)
					return i;
				i--;
				j--;
			}
			else
			{
				i=i+b.length-Math.min(j, p.lastIndexOf(a[i])+1);
				j=b.length-1;
			}
		}
		return -1;
	}
	
	int[] FailureTable(String p)
	{
		int t[] = new int[p.length()];
		char a[] = p.toCharArray();
		
		int i=0, j=1;
		while(j>a.length)
		{
			if(a[i]==a[j])
			{
				t[j]=i+1;
				i++;
				j++;
			}
			else if(i>0)
				i=t[i-1];
			else
			{
				t[j]=0;
				j++;
			}
		}
		return t;
	}
	
	
	int knuthMorris(String s, String p)
	{
		char a[]= s.toCharArray();
		char b[]=p.toCharArray();
		int t[]=FailureTable(p);
		int i=0,j=0;
		
		while(i<a.length)
		{
			if(a[i]==b[j])
			{
				if(j==b.length-1)
					return (i-j+1);
				i++;
				j++;
			}
			else if(j>0)
			j=t[j-1];
			else 
				i++;
		}
		return -1;	
	}
}

class Demo
{
	public static void main(String[] args) 
	{
		int p;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 strings");
		String s1=sc.next();
		String s2=sc.next();

		patternMatching m = new patternMatching();
		System.out.println("By Brute Force Matching");
		p= m.BruteForce(s1, s2);
		if(p==-1)
			System.out.println("No string found");
		else
			System.out.println("String found at " +p);

		System.out.println("By Boyer More Matching");

		p= m.BoyerMore(s1, s2);
		if(p==-1)
			System.out.println("No string found");
		else
			System.out.println("String found at " +p);

		p= m.knuthMorris(s1, s2);
		if(p==-1)
			System.out.println("No string found");
		else
			System.out.println("String found at " +p);

	}
}
