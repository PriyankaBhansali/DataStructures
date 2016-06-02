import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
// implement Binary Search Tree

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

class BinaryT { 
	Node root;

	void add(int v) 
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
				if(p.getData()>v)
					p=p.getLeft();
				else
					p=p.getRight();
			}

			if(prev.getData()>v)
				prev.setLeft(q);
			else
				prev.setRight(q);
		}
	}


	void pre()
	{
		pre(root);
	}

	void pre(Node p)
	{
		if(p==null)
			return	;
		else
		{
			System.out.println(p.getData());
			pre(p.getLeft());
			pre(p.getRight());
		}	
	}


	void post()
	{
		post(root);
	}

	void post(Node p)
	{
		if(p==null)
			return	;
		else
		{
			post(p.getLeft());
			post(p.getRight());
			System.out.println(p.getData());
		}	
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

	int count() //count number of nodes in BT
	{
		int n = count(root);
		return n;
	}

	int count (Node p)
	{
		if(p==null)
			return 0;
		else
		{
			int x=count(p.getLeft());
			int y=count(p.getRight());
			return x+y+1;
		}	
	}

	int height() //height of BT
	{
		int n = height(root);
		return n;
	}

	int height(Node p)
	{
		if(p==null || p.getLeft()==null && p.getRight()==null)
			return 0;
		else
		{
			int x=height(p.getLeft());
			int y=height(p.getRight());
			return ( x>y? x+1 : y+1);
		}	
	}

	int depth() //depth of BT??
	{
		int n = depth(root);
		return n;
	}
	
	int depth (Node r) {
	    int depth = 0;
	    Stack<Node> s = new Stack<>();
	    Stack<Node> path = new Stack<>();

	    s.push (r);
	    while (!s.empty()) {
	        r = s.peek();
	        if (!path.empty() && r == path.peek()) {
	            if (path.size() > depth)
	                depth = path.size();
	            path.pop();
	            s.pop();
	        } else {
	            path.push(r);
	            if (r.getRight() != null)
	                s.push(r.getRight());
	            if (r.getLeft() != null)
	                s.push(r.getLeft());
	        }
	    }

	    return depth;
	}
	

	boolean del(int v) //delete a node from BT
	{
		Node p=root;
		Node prev=null;

		while(p!=null)
		{
			if(p.getData()==v)
				break;
			prev=p;
			if(p.getData()>v)
				p=p.getLeft();
			else
				p=p.getRight();
		}

		if(p==null)
			return false;


		if( p.getLeft()!=null && p.getRight()!=null)
		{
			prev=p;
			Node succ=p.getRight();
			while(succ.getLeft()!=null)
			{
				prev=succ;
				succ=p.getLeft();
			}
			p.setData(succ.getData());
			p=succ;
		}

		if( p.getLeft()==null && p.getRight()==null)
		{
			if(prev.getLeft()==p)
				prev.setLeft(null);
			else
				prev.setRight(null);
		}

		else if(p==root)
		{
			if(p.getLeft()!=null)
				root=p.getLeft();
			else
				root=p.getRight();
		}

		else if( p.getLeft()==null && p.getRight()!=null)
		{
			if(prev.getLeft()==p)
				prev.setLeft(p.getRight());
			else
				prev.setRight(p.getLeft());
		}

		else if( p.getLeft()!=null && p.getRight()==null)
		{
			if(prev.getLeft()==p)
				prev.setLeft(p.getLeft());
			else
				prev.setRight(p.getRight());
		}
		return true;	
	}

	int largest() //largest in BT
	{
		Node p =root;
		if(p==null)        //not necessary to specify
			return 0;
		else
		{
			while(p.getRight()!=null)
				p=p.getRight();

			return p.getData();
		}
	}

	int smallest() //smallest in BT
	{
		Node p =root;
		while(p.getLeft()!=null)
			p=p.getLeft();

		return p.getData();
	}

	int countLeaf() //count number of leaf nodes in BT
	{
		int n = countLeaf(root);
		return n;
	}

	int countLeaf (Node p)
	{
		if(p==null)
			return 0;
		if(p.getLeft()==null && p.getRight()==null)
			return 1;
		else
		{
			int x=countLeaf(p.getLeft());
			int y=countLeaf(p.getRight());
			return x+y;
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
	
	
	void InOrder() {
        if (root == null) {
            return;
        }
        
        //keep the nodes in the path that are waiting to be visited
        Stack<Node> s = new Stack<Node>();
        Node p = root;
         
        //first node to be visited will be the left one
        while (p != null) 
        {
            s.push(p);
            p = p.getLeft();
        }
         
        // traverse the tree
        while (!s.empty()) 
        {
           
            // visit the top node
            p = s.pop();
            System.out.print(p.getData() + " ");
            if (p.getRight() != null) 
            {
                p = p.getRight();
                 
                // the next node to be visited is the leftmost
                while (p != null) 
                {
                    s.push(p);
                    p = p.getLeft();
                }
            }
        }
	}
	
	void PreOrder() {
		if (root == null) {
            return;
        }
        
        //keep the nodes in the path that are waiting to be visited
        Stack<Node> s = new Stack<Node>();
        Node p = root;
        
        while(p != null){
        	System.out.print(p.getData() + " ");
        	s.push(p);
        	p=p.getLeft();
        }
        
        while(!s.empty())
        {
        	p=s.pop();
        	if (p.getRight() != null) 
            {
                p = p.getRight();
                
                while(p!=null)
                {
                	System.out.print(p.getData() + " ");
                	s.push(p);
                    p=p.getLeft();
                    
                }
                
            }
        }
	}
	
	void PostOrder() {
		if (root == null) {
            return;
        }
        
        //keep the nodes in the path that are waiting to be visited
        Stack<Node> s = new Stack<Node>();
        Node p = root;
        
        while(p != null){
        	s.push(p);
        	p=p.getLeft();
        }
        
        while(!s.empty())
        {
        	p=s.peek();
        	//System.out.print(p.getData() + " ");
        	if (p.getRight() != null) 
            {
                p = p.getRight();
            	//System.out.print(p.getData() + " ");
                while(p!=null)
                {
                	s.push(p);
                    p=p.getLeft();
                    
                }
                p=s.pop();
              System.out.print(p.getData() + " ");               
            }
        }
	}
	
	
	void MorrisTraversal() {
		MorrisTraversal(root);
	}
	void MorrisTraversal(Node root) {
        Node p, prev;
        
        if (root == null) {
            return;
        }
        
        p = root;
        while (p != null) {
            if (p.getLeft() == null) 
            {
                System.out.print(p.getData() + " ");
                p = p.getRight();
                System.out.println("  a");
            } 
            else 
            {
                /* Find the inorder predecessor of p */
                prev = p.getLeft();
                while (prev.getRight() != null && prev.getRight() != p) 
                {
                    prev = prev.getRight();
                    System.out.println("  b");
                }

                /* Make p as getRight() child of its inorder predecessor */
                if (prev.getRight() == null) 
                {
                    prev.setRight(p);
                    p = p.getLeft();
                    System.out.println("  ccc 	" + p.getData());
                } 

                /* Revert the changes made in if part to restore the original 
                 tree i.e., fix the getRight() child of predecessor */ 
                else 
                {
                    prev.setRight(null);
                    System.out.print(p.getData() + " ");
                    p = p.getRight();
                    System.out.println("  d");
                }   /* End of if condition prev->right == NULL */
                
            } /* End of if condition current->left == NULL*/
            
        } /* End of while */
	}
	
	void printAncestors(int target)
	{
		printAncestors(root, target);
	}

	boolean printAncestors(Node root, int target){
		Node p =root;
		if (p == null) {
			return false;
		}

		if (p.getData() == target) {
			System.out.print(p.getData() + " --> ");
			return true;
		}

		if(p.getData()<target)
		{
			printAncestors(p.getRight(), target);
			System.out.print(p.getData() + " ");
			return true;
		}
		else
		{
			printAncestors(p.getLeft(), target);
			System.out.print(p.getData() + " ");
			return true;
		}
	}
	
	void Ancestors(int target)
	{
		if (root == null) {
			return;
		}

		Stack<Node> s = new Stack<Node>();
		Node p = root;
		
		while(p.getData()!=target && p!=null){
		
			if(target>p.getData()){
				s.push(p);
				p=p.getRight();
			}
			else{
				s.push(p);
				p=p.getLeft();
			}
		}
		System.out.print(p.getData() + " --> ");
		while(!s.empty())
		{	Node v = s.pop();
			System.out.print(v.getData() + " ");
		}        
	}
	
    // To check if a given array can represent 
	//Preorder Traversal of Binary Search Tree	
	
	void canRepresentBST(int pre[]) {
        Stack<Integer> s = new Stack<Integer>();
 
        int root = Integer.MIN_VALUE;
        boolean x = true;
        for (int i = 0; i < pre.length; i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (pre[i] < root) {
            	System.out.println("Is NOT a BST");
            	x = false;
            	break;
            }
 
            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }
 
            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            s.push(pre[i]);
        }
        if(x)
        System.out.println("Is a BST");
    }
	
	void spiralOrZigzagLevelOrder() {
		spiralOrZigzagLevelOrder(root);
	}
	
	void spiralOrZigzagLevelOrder(Node root) {
        if(root==null) return; 
        Stack<Node> s=new Stack<Node>();
        s.push(root);
        
        boolean directionflag = false;
        
        while(!s.isEmpty())
        {
            Stack<Node> tmpStack=new Stack<Node>();
        
            while(!s.isEmpty())
            {
                Node tempNode=s.pop();
             System.out.printf("%d ",tempNode.getData());
                if(!directionflag) 
                {
                    if(tempNode.left!=null) 
                     tmpStack.push(tempNode.getLeft());
                    if(tempNode.right!=null) 
                     tmpStack.push(tempNode.getRight());
                }else
                {
                    if(tempNode.right!=null) 
                     tmpStack.push(tempNode.getRight());
                    if(tempNode.left!=null) 
                     tmpStack.push(tempNode.getLeft());
                }
            }
            // for changing direction
            directionflag=!directionflag; 
      
            s=tmpStack; 
        }
      }
	
	void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h+1; i++)
            printGivenLevel(root, i);
    }
	
	void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
	
	void printLevelOrder_Queue() 
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
            // poll() removes the present head.
            
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            // Enqueue left child 
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }


}
class Demo
{
	public static void main(String[] args) 
	{
		BinaryT x = new BinaryT();
		x.add(50);
		x.add(70);
		x.add(60);
		x.add(80);
		x.add(55);
		x.add(10);
		x.add(5);
		x.add(7);
		System.out.println();
		x.printBinaryTree();
		System.out.println();
		int p[] = {50,10,5,7,70,60,55,80,75,71};
		x.canRepresentBST(p);
		System.out.println();
		p = new int[] {50,10,5,7,70,60,55,75,80,71};
		x.canRepresentBST(p);
		System.out.println();
		x.Ancestors(60);
		System.out.println();
		x.printAncestors(5);
		System.out.println();
		System.out.println("\nLevel-Order");
		x.printLevelOrder();
		System.out.println("\n\nLevel-Order-Queue");
		x.printLevelOrder_Queue();
		System.out.println("\n\nZigZag");
		x.spiralOrZigzagLevelOrder();
		System.out.println("\n...");
		x.InOrder();
		System.out.println();
		x.PreOrder();
		System.out.println();
		//x.PostOrder();
		System.out.println();
		System.out.println("In-Order");
		x.inorder();
		System.out.println("Pre-Order");
		x.pre();
		System.out.println("Post-Order");
		x.post();
		System.out.println();
		System.out.println("Without Recursion");
		x.MorrisTraversal();
		System.out.println();
		System.out.println();
		System.out.println("Using Stack");
		x.InOrder();
		System.out.println();
		System.out.println();
		int c=x.count();
		System.out.println("Count "+c);
		System.out.println();
		int h=x.height();
		System.out.println("Height "+ h);
		
		int d=x.depth();
		System.out.println("Depth "+ d);
		
		x.del(70);
		x.inorder();

		System.out.println();
		int l=x.largest();
		System.out.println("Largest "+l);
		System.out.println();
		int s=x.smallest();
		System.out.println("Smallest "+s);
		System.out.println();
		int lc=x.countLeaf();
		System.out.println("Leaf Count "+lc);
		System.out.println();
		x.printBinaryTree();
	}

	
}
