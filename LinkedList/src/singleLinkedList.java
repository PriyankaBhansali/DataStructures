// import java.util.Scanner;

class Node {
	private Object data;
	private Node next;
	
	void setData(Object o) {
		this.data = o;
	}
	void setNext(Node n) {
		this.next = n;
	}
	Object getData() {
		return data;
	}
	Node getNext() {
		return next;
	}
	
}

class LL {
	Node first;
	
	void add(Object o) //add elements to the list
	{
		Node p = new Node();
		p.setData(o);
		
		if(first == null)
			first=p;
		else
		{
			Node q = first;
			while(q.getNext()!=null)
				q=q.getNext();
			q.setNext(p);			
		}
	}

	void display() // display the elements in list
	{
		System.out.println("Elements in list are:");
		Node q = first;
		while (q!= null)
		{
			System.out.print(q.getData() + "  ");
			q = q.getNext();
		}
		System.out.println();
	}
	
	int count() // count the nodes in the list
	{
		int n = 0;
		Node q = first;
		while (q!=null)
		{
			n++;
			q=q.getNext();
		}
		return n;
	}
	
	int max() // largest element in the list
	{
		Node q = first;
		int m = (Integer)q.getData();
		
		while(q!=null)
		{
			int t = (Integer)q.getData();
			if(m < t)
				m=t;
			q=q.getNext();
		}
	return m;
	}
	
	void addB(int v) // add element at the beginning of the list
	{
		Node p = new Node();
		p.setData(v);
		p.setNext(first);	
		first = p;
	}
	
	void addE(int v,int pos) // insert an element at a given position, 
	                // if position does not exist, insert at the end
	// position starts with count 1 in list
	{
		Node p = new Node();
		int c = 1;
		Node q = first;
		 //or
		// int c = 0;
		// Node q = null;
		p.setData(v);
		if(pos == 1)
		{
			p.setNext(first);	
			first = p;
		}
		//else
		//{
			//c = 1;
			//q = first;
		//}
		
		while( c!=pos-1 && q.getNext()!=null)
		{
			q = q.getNext();
			c++;
		}
		p.setNext(q.getNext());
		q.setNext(p);
	}
	
	void del(int v) // delete an element, 
	
	{
		Node q = first;
		Node p = null;
		while (q!=null)
		{
			if( v == (Integer)q.getData())
				break;
			
			p=q;
			q=q.getNext();
		}
		if( q == null)
			System.out.println("Element does not exist");
		else if ( q == first) // to delete 1st element
			first=q.getNext();
			else
			p.setNext(q.getNext());
	}
	
	boolean search(int n) // search an element in the list
	{
		Node q = first;
		
		while( q!=null )
		{
			int v = (Integer)q.getData();
			if(n==v)
				return true;		
			else
				q=q.getNext();
		}
			return false;
	}
	
	void reverse() // reverse the elements of the list
	{
		Node q = first;
		Node prev = null;
		while(q!=null)
		{
			Node t = q.getNext();
			q.setNext(prev);
			prev=q;
			q=t;
		}
		first=prev;
	}
	
	LL copy() //copy a list
	{
		LL y = new LL();
		Node q= first;
		while(q!=null)
		{
			y.add(q.getData());
			q=q.getNext();
		}
		return y;
	}
	
	LL intersection(LL t) // intersecting/common elements from 2 lists
	{
		LL z = new LL();
		Node p1, p2;
		p1=first;
		p2=t.first;
		
		while(p1!=null)
		{
			while(p2!=null)
			{
				if(p1.getData()==p2.getData())
					break;
				p2=p2.getNext();
			}
			if(p2!=null)
				z.add(p1.getData());
			
			p1=p1.getNext();
			p2=t.first;
		}
		return z;
	}
	
	LL union(LL t) //union of 2 lists
	{
		LL z = new LL();
		Node p1, p2;
		p1=first;
		p2=t.first;
		
		while(p1!=null)
		{
			z.add(p1.getData());	
			p1=p1.getNext();
		}
		
		while(p2!=null)
		{
			z.add(p2.getData());
			p2=p2.getNext();
		}
		return z;
	}
	
	void sort() //sort the list
	{
		for(Node p=first; p.getNext()!=null;p=p.getNext())
		{
			for(Node t=first; t.getNext()!=null;t=t.getNext())
			{
				if((Integer)t.getData() > (Integer)t.getNext().getData())
				{
					int x=(Integer)t.getData();
					int y=(Integer)t.getNext().getData();
					t.setData(y);
					t.getNext().setData(x);
				}
			}
		}
	}
	
	void insertOrder(int v) //	insert element in an ordered list
	{
		Node q = new Node();
		q.setData(v);
		Node p=first;
		Node prev=null;
		
		while(p!=null)
		{
			if((Integer)p.getData() > v)
				break;
			
			prev=p;
			p=p.getNext();
		}
		
		if(p==first)
		{
			q.setNext(first);
			first=q;
		}
		else
		{
			q.setNext(prev.getNext());
			prev.setNext(q);
		}
	}
}

class Stack{  //define stack class using LL
	
	Node last;
	
	void push(int v)
	{
		Node p = new Node();
		p.setData(v);
		p.setNext(last);
		last = p;
	}
	
	int pop() throws Exception
	{
		if(last==null)
			throw new Exception("Stack is empty");
		else
		{
		int v = (Integer)last.getData();
		last = last.getNext();
		return v;
		}
	}
	
	int peek() throws Exception
	{
		if(last==null)
			throw new Exception("Stack is empty");
		else{
			int v = (Integer)last.getData();
			return v;
		}
	}
	
	boolean remove()
	{
		return last==null;
	}
	
	void display() // display the elements in list
	{
		System.out.println("Elements in list are:");
		Node q = last;
		while (q!= null)
		{
			System.out.println(q.getData());
			q = q.getNext();
		}
		System.out.println();
	}
}

class Queue{  //define queue class using LL
	
	private Node rear;
	private Node front;
	
	boolean add(int v)
	{
		Node p = new Node();
		p.setData(v);
		if(front==null)
		{
			front=p;
			rear = p;
		}
		else
		{
			rear.setNext(p);
			rear=p;
		}
		return true;
	}

	int remove() throws Exception
	{
		int v = (Integer)front.getData();
		front = front.getNext();
		if(front==null)
		{
			rear = null;
			throw new Exception("Queue is empty");
		}
		return v;
	}

	int peek() throws Exception
	{
		if(front==null)
			throw new Exception("Queue is empty");

		return (Integer)front.getData();
	}
	
	void display() // display the elements in list
	{
		System.out.println("Elements in list are:");
		Node q = front;
		while (q!= null)
		{
			System.out.println(q.getData());
			q = q.getNext();
		}
		System.out.println();
	}
	
}

class Demo
{
	public static void main(String[] args) throws Exception 
	{
		// Scanner sc = new Scanner(System.in);
		LL x = new LL();
		x.add(40);
		x.add(80);
		x.add(20);
		x.add(50);
		x.add(20);
		x.display();
		int c= x.count();
		System.out.println("Count is " + c);
		System.out.println();
		
		int m= x.max();
		System.out.println("Maximum numer from the list is " + m);
		System.out.println();
		
		x.addB(70);
		x.display();
		
		x.addE(60,4);
		x.display();
		
		x.addE(30,8);
		x.display();
		
		x.del(70);
		x.display();
		
		x.del(20);
		x.display();
		
		x.del(20);
		x.display();
		
		x.del(20);
		x.display();
		
		//System.out.println("Enter number to be searched");
		//int n = sc.nextInt();
		boolean b = x.search(5);
		if(b)
			System.out.println("Found");
		else
			System.out.println("Not Found");
		System.out.println();
		
		System.out.println("After reversing");
		x.reverse();
		x.display();
		
		System.out.println("Copy of list");
		LL y = new LL();
		y=x.copy();
		y.display();
		
		x.del(80);
		x.display();
		
		y.del(50);
		y.display();
		
		System.out.println("List intersection");
		LL intersect = x.intersection(y);
		intersect.display();
		
		System.out.println("List union");
		x.display();
		y.display();
		LL uni = x.union(y);
		uni.display();
		
		System.out.println("List sorting");
		x.sort();
		x.display();
		
		System.out.println("List sorting after union");
		uni.sort();
		uni.display();
		
		System.out.println("Add element in ordered list(union) ");
		uni.insertOrder(60);
		uni.display();
		
		System.out.println();
		System.out.println("This is the beginning of Stack");
		
		Stack s = new Stack();
		s.push(23);
		s.push(7);
		s.push(12);
		s.push(100);
		System.out.println("Last in first out");
		s.display(); 
		int pop_element = s.pop();
		int peek_element = s.peek();
		
		System.out.println();
		System.out.println("Pop element = " + pop_element );
		System.out.println("Peek element = " + peek_element );
		
		System.out.println();
		System.out.println("This is the beginning of Queue");
		
		Queue q = new Queue();
		q.add(23);
		q.add(7);
		q.add(12);
		q.add(100);
		System.out.println("First in first out");
		q.display();
		int queue_remove = q.remove();
		int queue_peek = q.peek();
		
		System.out.println();
		System.out.println("Pop element = " + queue_remove );
		System.out.println("Peek element = " + queue_peek );
		
	}
}
