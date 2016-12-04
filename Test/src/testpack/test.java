package testpack;
import java.util.*;

class StackMiddle {

	// Design a stack with operations on middle element
	
	int top = -1;
	int a[];
	int size = 0;
	
	public StackMiddle(){
		a = new int[5];
	}
	
	public int pop() {
		if(top == -1){
			throw new EmptyStackException();
		}
		size--;
		return a[top--];
	}

	public void push(int value) {
		if(top == a.length-1)
			System.out.println("Stack is full");
		else{
			a[++top] = value;
			size++;
		}
	}

	public int getMiddle() {
		if(size == 0){
			System.out.println("No element");
			return 0;
		}
		else{
			int middle = size/2;
			return a[middle];
		}
	}

	public void deleteMiddle() {
		if(size == 0){
			System.out.println("No element");
			return ;
		}
		int middle = size/2;
		System.out.println("Value being deleted from array is: " + a[middle]);
		for(int i = middle; i<size-1; i++)
		{
			a[i] = a[i+1];
		}
		size--;
		top--;
	}

	public void display(){

		for(int i=0;i<=top;i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
}

public class test{
	public static void main(String[] args)
	{
		StackMiddle s = new StackMiddle();
		s.push(4);
		s.push(10);
		s.push(2);
		s.push(6);
		s.display();
		
		System.out.println();
		System.out.println("Middle element: " + s.getMiddle());
		s.deleteMiddle();
		s.display();
		
		System.out.println();
		s.push(5);
		s.push(1);
		s.push(3);
		System.out.println("New Array");
		s.display();
		
		System.out.println();
		System.out.println("Middle element: " + s.getMiddle());
		s.deleteMiddle();
		System.out.println("New Array");
		s.display();
		
		System.out.println();
		System.out.println("Popped element: " + s.pop());
		System.out.println("Popped element: " + s.pop());
		
		System.out.println();
		System.out.println("New Array");
		s.display();
		
		System.out.println();
		System.out.println("Middle element: " + s.getMiddle());
		s.deleteMiddle();
		System.out.println("New Array");
		s.display();
		
		System.out.println();
		System.out.println("Middle element: " + s.getMiddle());
		s.deleteMiddle();
		System.out.println("New Array");
		s.display();
		s.display();
		
		System.out.println(s.pop());
	}
}
