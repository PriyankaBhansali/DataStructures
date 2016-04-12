import java.util.Scanner;
import java.util.*;

class Reverse_Palindrome
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter palindrome String");
		String m=sc.nextLine();
		char a[] = m.toCharArray();
		Stack s = new Stack();
		int i=0;
	
		
//To Reverse a String using Stack
//		
//		for(int j=0;j<a.length;j++)
//		{
//				System.out.print(s.push(a[j]));
//		}
//	
//			System.out.println("\n\nNew Reversed string");
//			while(!s.empty())
//		System.out.print(s.pop());
		
		
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