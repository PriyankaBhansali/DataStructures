import java.util.Scanner;

// implement Binary Search Tree using Recursion

class Node {
	int data;
	Node left,right;

	int getData() {
		return data;
	}
	Node getLeft() {
		return left;
	}
	Node getRight() {
		return right;
	}
	void setData(int data) {
		this.data = data;
	}
	void setLeft(Node left) {
		this.left = left;
	}
	void setRight(Node right) {
		this.right = right;
	}

}

class RecursionBT { 
	Node root=null;

	void add(int v) 
	{
		root=add(root,v);
	}
	
	Node add(Node p, int v)
	{
		if(p == null)
		{	
		Node q = new Node();
		q.setData(v);
		return q;
		}
		
		else if(p.getData()>v)
			p.setLeft(add(p.getLeft(),v));
				else
			p.setRight(add(p.getRight(),v));
	return p;		
	}
	
	void inorder()
	{
		inorder(root);
	}

	void inorder(Node p)
	{
		if(p==null)
			return	;
		else
		{
			inorder(p.getLeft());
			System.out.println(p.getData());
			inorder(p.getRight());
		}	
	}
	
	boolean searchBT(int v)
	{
		return searchBT(root,v);
	}
	
	boolean searchBT(Node p, int v)
	{
		if(p==null)
			return false;
		if(p.getData()==v)
			return true;
		else
		{
			boolean x = searchBT(p.getLeft(),v);
			boolean y = searchBT(p.getRight(),v);
			return x||y;
		}
	}
	
	Node largest()
	{
		return largest(root);
	}
	
	Node largest(Node p)
	{
		if(p==null)
			return null;
		else
		{
			Node x = largest(p.getLeft());
			Node y = largest(p.getRight());
			int a=0, b=0, c;
			
			if(x!=null)
				a=x.getData();
			if(y!=null)
				b=y.getData();
			
			c=p.getData();
			return( a>b && a>c ? x:(b>c?y:p));
		}
	}
	
	//to find whether given tree is a strictly BT
	boolean strictlyBT()
	{
		return strictlyBT(root);
	}
	
	boolean strictlyBT (Node p)
	{
		if(p==null)
			return false;
		else if(p.getLeft()==null && p.getRight()==null)
			return true;
		else
		{
			boolean x = strictlyBT(p.getLeft());
			boolean y = strictlyBT(p.getRight());
			return x || y;
		}
	}
	
	// check..error????????????????????????
		Node insertBT(Node p,int v)
		{
			Node root = null;
			if(p==null)
			{
				Node q = new Node();
				q.setData(v);
				return q;
			}
			else
			{
				int ch;
				System.out.println("Enter");
				p.getData();
				Scanner sc = new Scanner(System.in);
				ch=sc.nextInt();
				if(ch==1)
					p.setLeft(insertBT(p.getLeft(),v));
				else
					p.setRight(insertBT(p.getRight(),v));
				
			}
			return p;
		}
		
		void insert(int v)
		{
			root=insertBT(root,v);
		}
		
}

class Demo
{
	public static void main(String[] args) 
	{
		// Scanner sc = new Scanner(System.in);
		RecursionBT x = new RecursionBT();
		x.add(50);
		x.add(70);
		x.add(60);
		x.add(80);
		x.add(65);
		x.add(10);
		x.add(5);
		x.add(7);


		System.out.println("In-Order");
		x.inorder();
		System.out.println();
		
		System.out.println("Largest " + x.largest().getData());
		
		boolean bs = x.searchBT(90);
		if(bs)
			System.out.println("Found");
		else
			System.out.println("Not Found");
		
		System.out.println();
		System.out.println("Is tree strictlyBT? "); 
		System.out.println(x.strictlyBT());
		
		System.out.println();
		x.insert(45);
		x.inorder();
		
		
	}
}
