import java.util.*;

class Demo
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		Stack<String> s = new Stack<String>();
		String posin="";
		System.out.println("Enter Expression");
		String st=sc.next();
		char a[] = st.toCharArray();
		for (int i = 0; i < a.length; i++)
		System.out.println(i + "  " +a[i]);
		System.out.println();
		for(int i=0; i<a.length;i++)
		{
			if(a[i]>='a' && a[i]<='z')
				System.out.println(s.push(posin+a[i]));
			else
			{
				try
				{
					String x=s.pop();
					String y=s.pop();

					switch(a[i])
					{
					case '+':
						s.push(y.concat("+".concat(x)));
						break;
					case '-':
						s.push(y.concat("-".concat(x)));
						break;
					case '*':
						s.push(y.concat("*".concat(x)));
						break;
					case '/':
						s.push(y.concat("/".concat(x)));
						break;
					case '%':
						s.push(y.concat("%".concat(x)));
						break;
					}

				}

				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		try
		{
			System.out.println("Ans = ( " +s.pop()+" )");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
