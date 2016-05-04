//import java.util.Scanner;
import java.io.*;
import java.util.*;

class Stack {
	private int top= -1;
	private int a[];

	public Stack()
	{
		a=new int[5];
	}

	public Stack(int n)
	{
		a=new int[n];
	}

	void display()
	{
		for(int i=0;i<=top;i++)
		{
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}

	void push(int v)
	{
		if(top==a.length-1)
			System.out.println("Stack is full");
		else
			a[++top]=v;
	}

	int pop() throws Exception
	{
		if(top == -1)
			throw new Exception("Stack is empty");
		else
			return a[top--];
	}

	boolean empty()
	{
		return top == -1;
	}

	int peak() throws Exception
	{
		if(top==-1)
			throw new Exception("Stack is empty");
		else
			return a[top];
	}

	void binary(int n) //binary form of a no using stack
	{
		Stack s = new Stack();
		while(n!=0)
		{
			s.push(n%2);
			n=n/2;
		}
		while(!s.empty())
		{
			try
			{
				System.out.print(s.pop());
			}
			catch(Exception e)
			{
				System.out.println(e);	
			}
		}
	}
}

//Using Vectors

class StackVector {
	private Vector a;

	public StackVector()
	{
		a=new Vector();
	}

	public StackVector(int n)
	{
		a=new Vector(n);
	}

	void push(Object v)
	{
		a.add(v);
	}

	Object pop() throws Exception
	{
		if(a.isEmpty())
			throw new Exception("Stack is empty");
		else
			return a.remove(a.size()-1);
	}

	boolean empty()
	{
		return a.isEmpty();
	}

	Object peak() throws Exception
	{
		if(a.isEmpty())
			throw new Exception("Stack is empty");
		else
			return a.elementAt(a.size()-1);
	}
}


class stackLIFO
{
	public static void main(String[] args) throws Exception 
	{
		//Scanner sc = new Scanner(System.in);
		Stack s = new Stack();
		s.push(40);
		s.push(80);
		s.push(20);
		s.push(50);
		try
		{
			int v = s.pop();
			System.out.println("Pop element " +v);
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}

		if(s.empty())
			System.out.println("Empty");
		try
		{
			int v = s.peak();
			System.out.println("Peak element " +v);
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}	

		System.out.println("Binary form:");
		s.binary(16);
		System.out.println();

		
		StackVector sv = new StackVector();
		sv.push(10);
		sv.push(25.5);
		sv.push("hello");
		sv.push("hi");
		try
		{
			while(!sv.empty())
			{
				Object v = sv.pop();
				System.out.println("Pop element " +v);
			}
		}

		catch(Exception e)
		{
			System.out.println(e);	
		}

	}
}