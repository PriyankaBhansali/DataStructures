package testpack;

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
	
		
}




public class CCode_LL {

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
	}
}
