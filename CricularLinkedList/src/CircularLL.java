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

class CLL {
	Node first;
	
	void add(int v) //add elements to the list
	{
		Node p = new Node();
		p.setData(v);
		
		if(first == null)
		{
			p.setNext(p);
			first=p;
		}
		else
		{
			p.setNext(first.getNext());
			first.setNext(p);		
			first=p;
		}
	}
	
	void display() // display the elements in list
	{
		System.out.println("Elements in list are:");
		Node p = first;
		do
		{
			System.out.println(p.getNext().getData());
			p = p.getNext();
		}
		while (p!= first);
		System.out.println();
	}
	
}

class Demo
{
	public static void main(String[] args) throws Exception 
	{
		CLL x = new CLL();
		x.add(40);
		x.add(80);
		x.add(20);
		x.add(50);
		x.add(20);
		x.display();
	}
}
