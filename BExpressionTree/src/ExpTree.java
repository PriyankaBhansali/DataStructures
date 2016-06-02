//?? pg 118

class Node {
	String data;
	Node left,right;

	String getData() {
		return data;
	}
	Node getLeft() {
		return left;
	}
	Node getRight() {
		return right;
	}
	void setData(String data) {
		this.data = data;
	}
	void setLeft(Node left) {
		this.left = left;
	}
	void setRight(Node right) {
		this.right = right;
	}

}

class ET { 
	Node root;

	void add(String v) 
	{
		Node q = new Node();
		q.setData(v);

		if(root == null)
			root=q;
		else
		{
			Node p = root;
			Node prev=null;
			while(p!=null)
			{
				prev = p;
				int az = p.getData().compareTo(v);
				if(az>0)
					p=p.getLeft();
				else
					p=p.getRight();
			}

			int bz = prev.getData().compareTo(v);
			if(bz>0)
				prev.setLeft(q);
			else
				prev.setRight(q);
		}
	}
	
	void printBinaryTree()
	{
		printBinaryTree(root,0);
	}
	
	void printBinaryTree(Node root, int level){
	    if(root==null)
	         return;
	    printBinaryTree(root.getRight(), level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------"+root.getData());
	    }
	    else
	        System.out.println(root.getData());
	    printBinaryTree(root.getLeft(), level+1);
	}    
	
//	int evaluate()
//	{
//		return evaluate(root);
//	}
//	
//	int  evaluate(Node p)
//	{
//		if(p==null)
//			return 0;
//		if(p.getLeft()==null && p.getRight()==null)
//		return (Integer)p.getData();
//		else
//		{
//			int x = evaluate(p.getLeft());
//			int y = evaluate(p.getRight());
//			
//			int r=0;
//			
//			switch(p.getData())
//			{
//			case '+':
//				r = x + y; break;
//			case '-':
//				r = x - y; break;
//			case '*':
//				r = x * y; break;
//			case '/':
//				r = x / y; break;	
//			case '^':
//				r = (int) Math.pow(x, y); break;
//				}
//			return r;
//		}
//	}
}

class Demo
{
	public static void main(String[] args) 
	{
		ET x = new ET();
		x.add("cat");
		x.add("dog");
		x.add("bird");
		x.add("tiger");
		x.add("elephant");
		x.add("panda");
		x.add("ant");
		x.add("antoo");
		x.add("dagg");
		x.add("dagger");

		System.out.println();
		x.printBinaryTree();
	}
}

