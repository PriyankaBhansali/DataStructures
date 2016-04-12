import java.util.Scanner;
import java.util.*;

class Palindrome
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter palindrome String");
		String m=sc.nextLine();
		char a[] = m.toCharArray();
		Stack s = new Stack();
		int i=0;
		for(;i<a.length/2;i++)
		{
			s.push(a[i]);
				//System.out.println(s.push(a[i]));
		}

		if(a.length%2!=0)
			i++;

		boolean x = true;
		
		for(;i<a.length;i++)
		{	
			//char po = (char) s.pop();
			//System.out.println(i+ "  " +a[i]+"  " +po);
			if(a[i] != (char)s.pop())
			{
				x=false;
				break;
			}
		}
		System.out.println(x);
	}
}