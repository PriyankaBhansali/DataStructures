class Node {
	private Object data;
	private Node next;
	int prio;
	
	void setData(Object o) {
		this.data = o;
	}
	void setNext(Node n) {
		this.next = n;
	}
	void setPriority(int prio) {
		this.prio = prio;
	}
	Object getData() {
		return data;
	}
	Node getNext() {
		return next;
	}
	int getPriority() {
		return prio;
	}
}

class PQ
{
	Node front;
	void add(Object v, int prio)
	{
		Node p=new Node();
		p.setPriority(prio);
		p.setData(v);
		
		if(front==null || front.getPriority()>prio)
		{
			p.setNext(front);
			front=p;
		}
		else
		{
			Node q=front, prev=null;
			
			while(q!=null)
			{
				if(q.getPriority()>prio)
					break;
				prev=q;
				q=q.getNext();
			}
			p.setNext(q);
			prev.setNext(p);
		}
	}
	
	Object del() throws Exception
	{
		if(front==null)
			throw new Exception("Empty");
		else
		{
			Object v = front.getData();
			front=front.getNext();
			return v;
		}
	}
	
	boolean empty()
	{
		return front == null;
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
		PQ x = new PQ();
		x.add(15,3);
		x.add(10,3);
		x.add(20,2);
		x.add(50,4);
		x.display();
		
		while(!x.empty())
			System.out.println(x.del());
	}
}
