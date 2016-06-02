
class Node {
	int data;
	boolean lf,rf;
	Node left,right;

	public int getData() {
		return data;
	}
	public boolean getLeftflag() {
		return lf;
	}
	public boolean getRightflag() {
		return rf;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void setLeftflag(boolean lf) {
		this.lf = lf;
	}
	public void setRightflag(boolean rf) {
		this.rf = rf;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}

class TBT
{
	Node root;

	void add(int v)
	{
		Node q = new Node();
		q.setData(v);
		if(root==null)
			root=q;
		else
		{
			Node p = root;

			while(true)
			{
				if(p.getData()>v && p.getLeftflag())
					p=p.getLeft();
				else if(p.getData()<v && p.getRightflag())
					p=p.getRight();
				else
					break;
			}

			if(p.getData()<v)
			{
				q.setRight(p.getRight());
				p.setRight(q);
				p.setRightflag(true);
				q.setLeft(p);
			}
			else
			{
				q.setLeft(p.getLeft());
				p.setLeft(q);
				p.setLeftflag(true);
				q.setRight(p);
			}
		}
	}

	void inorder()
	{
		Node p=root;

		while(true)
		{
			while(p.getLeftflag())
				p=p.getLeft();

			System.out.println(p.getData());

			while(!p.getRightflag())
			{
				p=p.getRight();
				if(p==null)
					return;

				System.out.println(p.getData());
			}
			p=p.getRight();
		}
	}
}


class Demo
{
	public static void main(String[] args) throws Exception 
	{
		// Scanner sc = new Scanner(System.in);
		TBT x = new TBT();
		x.add(50);
		x.add(75);
		x.add(60);
		x.add(25);
		x.inorder();
	}
}