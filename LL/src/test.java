import java.util.HashMap;

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

	// add elements to the list
	void add(Object o) {
		Node p = new Node();
		p.setData(o);

		if (first == null)
			first = p;
		else {
			Node q = first;
			while (q.getNext() != null)
				q = q.getNext();
			q.setNext(p);
		}
	}

	// display elements in the list
	void display() {
		System.out.print("List:  ");
		Node q = first;
		while (q != null) {
			System.out.print(q.getData() + "  ");
			q = q.getNext();
		}
		System.out.println();
	}

	// Remove duplicates from an sorted linked list
	void removeDuplicates_sorted()
    {
        Node p=first;
        if (first == null)    
            return;
 
        while (p.getNext() != null) {
 
            if (p.getData() == p.getNext().getData()) 
            {
                p.setNext(p.getNext().getNext());
                continue;
            }
            
            p = p.getNext();
               
        }
    }
	
	// Remove duplicates from an unsorted linked list
	//
	// Method 1: Outer loop is used to pick the elements one by one and inner
	// loop compares the picked element with rest of the elements.
	//
	// Method 2: Sort the list. Remove duplicates in linear time
	// using "Remove duplicates from an sorted linked list"
	//
	// Method 3: Use Hashing
	
	void removeDuplicates_unsorted() {
		Node p = null, temp = null;
        p = first;
 
        while (p != null && p.getNext() != null) 
        {
            temp = p;
            while (temp.getNext() != null) 
            {
                if (p.getData() == temp.getNext().getData()) 
                {
                    temp.setNext(temp.getNext().getNext());
                  
                } 
                else 
                    temp = temp.getNext();
            }
            p = p.getNext();
        }

	}
	
	// Remove duplicates from an unsorted linked list by Hashing
	
	
	
	
	
	
	// Reverse linked list using Recursion
	void reverse_Recursion()
	{
		reverse_Recursion(first);
	}

	void reverse_Recursion(Node first)
	{
		if (first == null) 
			return;

		reverse_Recursion(first.getNext());

		System.out.print(first.getData() +" ");
	}
	
	// Move last element to front of a given Linked List
	void moveLastToFront()
	{
		if(first == null || first.getNext() == null) 
			return;

		Node secLast = null;
		Node last = first;

		while (last.getNext() != null)  
		{
			secLast = last;
			last = last.getNext(); 
		}

		secLast.setNext(null);
		last.setNext(first);
		first = last;
	}  
	
	// Segregate even and odd nodes in a Linked List
	void segregateEvenOdd()
    {
        Node end = first;
        Node prev = null;
        Node p = first;
 
        while (end.getNext() != null)
            end = end.getNext();
 
        Node new_end = end;
 
        while ((int) p.getData() %2 !=0 && p != end)
        {
            new_end.setNext(p);
            p = p.getNext();
            new_end.getNext().setNext(null);
            new_end = new_end.getNext();
        }
 
        if ((int)p.getData() %2 ==0)
        {
            first = p;
 
            while (p != end)
            {
                if ((int)p.getData() % 2 == 0)
                {
                    prev = p;
                    p = p.getNext();
                }
                else
                {
                    prev.setNext(p.getNext());
                    p.setNext(null);
                    new_end.setNext(p);
                    new_end = p;
                    p = prev.getNext();
                }
            }
        }
 
       else 
    	   prev = p;
 
        if (new_end != end && (int)end.getData() %2 != 0)
        {
            prev.setNext(end.getNext());
            end.setNext(null);
            new_end.setNext(end);
        }
    }
	
	// Delete alternate nodes of a Linked List
	void deleteAlt()
    {
       if (first == null) 
          return;
 
       Node prev = first;
       Node p = first.getNext();
 
       while (prev != null && p != null) 
       {           
           prev.setNext(p.getNext());
           p = null;
           prev = prev.getNext();
 
           if (prev != null) 
              p = prev.getNext();
       }
    }     
	
	// Pairwise swap elements of a given linked list
	void pairWiseSwap()
    {
        Node temp = first;
 
        while (temp != null && temp.getNext() != null) 
        {
            int k = (int) temp.getData();
            temp.setData(temp.getNext().getData());
            temp.getNext().setData(k);
            temp = temp.getNext().getNext();
         }
    }
	
	public void Altersplit() {
		Node p = first;

		if (p == null || p.getNext() == null)
			return;

		while (p != null && p.getNext() != null) 
		{
			Node t = p.getNext();
			// set the next node for first linked list
			// Now check if next node is available for second Linked List
			p.setNext(t.getNext());

			if (p.getNext() != null && p.getNext().getNext() != null)
				t.setNext(p.getNext().getNext()); // set the next node for
													// second linked list

			else 
			{
				t.setNext(null);
				return;
			}
			p = p.getNext();
		}

	}
	
	void reverse() 
	{
		Node q = first;
		Node prev = null;
		while (q != null) 
		{
			Node t = q.getNext();
			q.setNext(prev);
			prev = q;
			q = t;
		}
		first = prev;
	}
	
	// Deletes nodes which have a node with greater
    //value node on left side
	void delLesserNodes()
	{
		/* 1.Reverse the linked list */
		reverse();

		/* 2) In the reversed list, delete nodes which
        have a node with greater value node on left
        side. Note that head node is never deleted
        because it is the leftmost node.*/
		_delLesserNodes();

		/* 3) Reverse the linked list again to retain
        the original order */
		reverse();
	}

	void _delLesserNodes()
	{
		Node current = first;
		Node maxnode = first;
		Node temp;

		while (current != null && current.getNext() != null)
		{
			/* If current is smaller than max, then delete
            current */
			if ((int)current.getNext().getData() < (int)maxnode.getData())
			{
				temp = current.getNext();
				current.setNext(temp.getNext());
				temp = null;
			}

			/* If current is greater than max, then update
            max and move current */
			else
			{
				current = current.getNext();
				maxnode = current;
			}
		}
	}
}

class test {
	public static void main(String[] args) throws Exception {
		LL x = new LL();
		x.add(80);
		x.add(50);
		x.add(50);
		x.add(50);
		x.add(20);
		x.add(20);
		x.add(20);
		x.add(20);
		x.add(20);
		x.add(10);
		System.out.println("Current List");
		x.display();
		System.out.println();
		System.out.println("Remove Duplicates from Sorted List");
		x.removeDuplicates_sorted();
		x.display();
		x.add(5);
		x.add(16);
		x.add(25);
		x.add(17);
		x.add(20);
		System.out.println();
		System.out.println("New Current List");
		x.display();
		System.out.println();
		x.removeDuplicates_unsorted();
		x.display();
		System.out.println();
		System.out.println("Reverse Using Recursion");
		x.reverse_Recursion();
		System.out.println("\n");
		
		System.out.println("Current List");
		x.display();
		System.out.println();
		x.moveLastToFront();
		System.out.println("Move last to front");
		x.display();
		System.out.println();
		
		System.out.println("Segregate even-odd");
		x.segregateEvenOdd();
		x.display();
		System.out.println();
		
		System.out.println("Delete alternate nodes");
		x.deleteAlt();
		x.display();
		System.out.println();
		
		x.add(4);
		x.add(10);
		x.add(8);
		x.add(6);
		System.out.println("New Updated List");
		x.display();
		System.out.println();
		System.out.println("PairWise Swap");
		x.pairWiseSwap();
		x.display();
		
		System.out.println();
		System.out.println("Alterative split");
		x.Altersplit();
		x.display();

		System.out.println();
		System.out.println("Delete nodes having greater value on right side");
		x.delLesserNodes();
		x.display();
		System.out.println();
	
		
	}
}
