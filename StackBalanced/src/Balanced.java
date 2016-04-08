import java.util.Scanner;
import java.util.*;

class balanced
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack();
		System.out.println("Enter Expression");
		String m=sc.next();
		char a[] = m.toCharArray();
		boolean x=true;
		try
		{
		for(int i=0;i<a.length;i++)
		{
			if(a[i]=='(')
				s.push(a[i]);
			if(a[i]==')')
				s.pop();
		}
		}
		catch(Exception e)
		{
			x=false;	
		}

		if(s.empty() && x)
			System.out.println("Balanced");
		else
			System.out.println("Unbalanced");
	}
}


