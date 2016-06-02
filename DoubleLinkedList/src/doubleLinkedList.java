// import java.util.Scanner;

/**
 * 
 */

/**
 * @author PriyankaBhansali
 *
 */
class Node {
	private Object data;
	private Node prev;
	private Node next;
	
	void setData(Object o) {
		this.data = o;
	}
	void setPrev(Node p) {
		this.prev = p;
	}
	void setNext(Node n) {
		this.next = n;
	}
	Object getData() {
		return data;
	}
	Node getPrev() {
		return prev;
	}
	Node getNext() {
		return next;
	}
	
}

class DLL {
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
			p.setPrev(q);
		}
	}

	void forwardDisplay() // forward display of the elements in list
	{
		System.out.println("Elements in list are (forward display) : ");
		Node q = first;
		while (q!= null)
		{
			System.out.println(q.getData());
			q = q.getNext();
		}
		System.out.println();
	}
	
	void reverseDisplay() // reverse display of the elements in list
	{
		System.out.println("Elements in list are (reverse display) : ");
		Node q = first;
		while (q.getNext()!= null)
			q = q.getNext();
		while( q!=null )
		{
			System.out.println(q.getData());
			q = q.getPrev();
		}
		System.out.println();
	}

	
	// count and max function are SAME as Single linked List
	
		
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
	    int count = 0;
		p.setData(v);
		
		for(Node q=first; q.getNext()!=null; q=q.getNext())
			count++;
		
		if(pos == 1)
		{
			first.setPrev(p);
			p.setNext(first);	
			first = p;
		}
		else if(pos>count)
		{
			Node q = first;
			
		while( q.getNext()!=null)
			{
				q = q.getNext();
			}
			q.setNext(p);
			p.setPrev(q);
		}
		
		else // to add element in between first and last
		{
			Node q = first;
			for(int i=1;i<pos-1;i++)
				q=q.getNext();
			
			p.setNext(q.getNext());
			q.setNext(p);
			p.setPrev(p.getNext().getPrev());
			p.getNext().setPrev(p);
		}
	}
	
	void del(int v) // delete an element, 

	{
		Node q = first;
		while (q!=null)
		{
			if( v == (Integer)q.getData())
				break;

			q=q.getNext();
		}
		if( q == null)
			System.out.println("Element does not exist");
		else if ( q == first) // to delete 1st element
		{
			first=q.getNext();
			q.getNext().setPrev(null);
		}
		else {
			if (q.getNext()!=null )
				q.getNext().setPrev(q.getPrev());
			q.getPrev().setNext(q.getNext());
		}	
	}
	
	boolean search(int n) // search an element in the list
	{
		Node q = first;
		int c = 0;
		
		while( q!=null )
		{
			int v = (Integer)q.getData();
			if(n==v)
			{
				c=1;
				q=q.getNext();
			}
			else
				q=q.getNext();
		}
		if(c==1)
			return true;
		else
			return false;
	}	
	
	DLL union(DLL t) //union of 2 lists
	{
		DLL z = new DLL();
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
		
		while(p2!=null)
		{
			z.add(p2.getData());
			p2=p2.getNext();
		}
		return z;
	}
}
class Demo
{
	public static void main(String[] args) throws Exception 
	{
		// Scanner sc = new Scanner(System.in);
		DLL x = new DLL();
		x.add(40);
		x.add(80);
		x.add(20);
		x.add(50);
		x.add(20);
		x.forwardDisplay();
		x.reverseDisplay();
		
//		x.addB(70);
//		x.display();
//		
		x.addE(60,4);
		x.forwardDisplay();
		
		x.addE(30,8);
		x.forwardDisplay();
		
		x.del(20);
		x.forwardDisplay();
		
		x.del(20);
		x.forwardDisplay();
		
		x.del(20);
		x.forwardDisplay();
		
		boolean b = x.search(5);
		if(b)
			System.out.println("Found");
		else
			System.out.println("Not Found");

		System.out.println();
		System.out.println("This is the beginning of Queue");
		
		
	}
}
