import java.util.*;

class Demo
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		Stack<Character> s = new Stack<Character>();
		String post="";
		System.out.println("Enter Expression");
		String st=sc.next();
		char a[] = st.toCharArray();
		try
		{
			for(int i=0; i<a.length;i++)
			{
				if(Character.isLetterOrDigit(a[i]))
					post+=a[i];
				else
				{
					post+=" ";
					if(s.empty() || a[i]=='(' || a[i]=='^' ||	preceed(a[i]) > preceed(s.peek()))
					{
						s.push(a[i]);
					}
					else
					{
						if(a[i]==')')
						{
							try
							{
								while(s.peek()!='(')
									post+=s.pop();
								s.pop();
							}
							catch(Exception e)
							{
								System.out.println(e);
							}
						}
						else
						{
							try
							{
								while(!s.empty() && preceed(a[i])<=preceed(s.peek()))
									post+=s.pop();
								s.push(a[i]);
							}
							catch(Exception e)
							{
								System.out.println(e);
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		try
		{
			while(!s.empty())
			{	post+=' ';
				post+=s.pop();
			}
			System.out.println("ans =  "+ post);

		}

		catch(Exception e)
		{
			System.out.println(e);
		}
		
		int e = evaluatePostfix(post);
		System.out.println("Final evaluated output:  " + e);
	}

	static int preceed(char op)
	{
		switch(op)
		{
		case '^':
		case '$':
			return 4;
		case '*':
		case '/':
		case '%':
			return 3;
		case '+':
		case '-':
			return 2;
		case '(':
		case ')':
			return 1;
		}
		return 0;
	}


	public static int evaluatePostfix(String postfixExpr) {
		char[] a = postfixExpr.toCharArray();
		for (int i = 0; i < a.length; i++)
		System.out.println(i + "  " +a[i]);
		System.out.println();
		Stack<Integer> stack= new Stack<Integer>();
		int result = 0;
		for(int i=0; i<a.length;i++)
		{
			if(Character.isLetter(a[i]))
			{
				System.out.println("Letters cannot be evaluated");
				break;
			}
			else
			{
				System.out.println("Digits");
				break;
			}
		}
		
		for (int i = 0; i < a.length; i++)
		{	
			if (a[i] >= '0' && a[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();
				// There may be more than one digits in number
				while (i < a.length && a[i] >= '0' && a[i] <= '9')
				{
					System.out.println(".." +a[i]);
					System.out.println("...." + sbuf.append(a[i++]));
				}
				stack.push(Integer.parseInt(sbuf.toString()));
				System.out.println("i=" + i);
			}

			else if(a[i]!=' ')
			{
				int op1 = stack.pop();
				System.out.println("op1 " + op1);
				int op2 = stack.pop();
				System.out.println("op2 " + op2);
				System.out.println("operator " + a[i]);
				switch (a[i])
				{
				case '*':
					result = (op2 * op1);
					stack.push(result);
					break;
				case '/':
					result = op2 / op1;
					stack.push(result);
					break;
				case '+':
					result = op2 + op1;
					stack.push(result);
					break;
				case '-':
					result = op2 - op1;
					stack.push(result);
					break;
				}
			}
		}
		
		return stack.pop();
	}


}
