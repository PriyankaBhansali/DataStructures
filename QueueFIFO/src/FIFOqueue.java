import java.util.Arrays;

class Queue {

    private int front=-1;
    private int rear=-1;
    private int a[];

	public Queue()
	{
		a=new int[5];
	}
    
    public Queue(int n) {
        a=new int[n];
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }
    
    void add(int v) throws Exception
	{
		if((rear+1) % a.length == front)
		throw new Exception("Queue is Full");
		else if(isEmpty()){
			front++;
            rear++;
            a[rear] = v;
		}
		else
		{
			rear=(rear+1) % a.length;
			a[rear]=v;
		}
	}

    int remove() throws Exception
	{
    	int v = 0;
    	if (isEmpty()) {
          throw new IllegalStateException("Queue is Empty");
      } 
    	else if(rear == front)
    	{
    	  v = a[front];
          front = -1;
          rear = -1;
    	}
		else
		{
			v = a[front];
			front=(front+1) % a.length;		
		}
    	return v;
	}

    @Override
    public String toString() {
        return "Queue (front=" + front + ", rear=" + rear + ", size=" + a.length
                + ", queue=" + Arrays.toString(a) + ")";
    }

}

class Demo {

    public static void main(String[] args) throws Exception {
    	Queue q = new Queue(6);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        System.out.println( q.toString());
        System.out.println( q.remove());
        System.out.println( q.remove());
        System.out.println( q.toString());
        q.add(60);
        q.add(70);
        System.out.println( q.toString());
        System.out.println( q.remove());
        System.out.println( q.remove());
        System.out.println( q.remove());
        System.out.println( q.remove());
        q.add(80);
        System.out.println( q.remove());
        System.out.println();
        System.out.println( q.toString());


    }

}