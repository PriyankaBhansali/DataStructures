import java.util.*;

class Graph
{
	boolean visited[];
	boolean a[][];
	boolean dir;

	Graph(int n,boolean directed)
	{
		visited = new boolean[n];
		a=new boolean[n][n];
		dir=directed;
		create();
	}

	void create()
	{
		String s;
		do
		{
			System.out.println("Enter the edge name");
			Scanner sc = new Scanner(System.in);
			s = sc.next().toUpperCase();
			int x = s.charAt(0)-65;
			int y = s.charAt(1)-65;
			a[x][y]=true;

			if(!dir)
				a[y][x] = true;
			System.out.println("Enter y to continue");
			s=sc.next().toUpperCase();
		}

		while(s.equals("Y"));
	}

	void display()
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(a[i][j])
					System.out.print(1+ "\t");
				else
					System.out.print(0+ "\t");
			}

			System.out.println();
		}
	}

	void dfs(int r)
	{
		System.out.println((char)(r+65));
		visited[r]=true;
		for(int i=0;i<a.length;i++)
		{
			if(!visited[i] &&a[r][i])
				dfs(i);
		}
	}

	void sdfs(int r)
	{
		Stack<Integer> s = new Stack<Integer>();
		System.out.println((char)(r+65));
		//visited[r]=true;     ... not required!!
		s.push(r);
		while(!s.empty())
		{
			r=s.peek();
			int i;
			for(i=0;i<a.length;i++)
			{
				if(!visited[i] &&a[r][i])
				{
					s.push(i);
					visited[i]=true;
					System.out.println((char)(i+65));
					break;
				}
			}
			if(i==a.length)
				s.pop();
		}
	}

	void bfs(int r)
	{
		visited = new boolean[a.length];
		int q[] = new int[a.length];
		int rear = -1, front = -1;
		visited[r] = true;

		System.out.println((char)(r+65));
		q[++rear]=r;

		while(rear!=front)
		{
			r=q[++front];
			for(int i=0;i<a.length;i++)
			{
				if(!visited[i] && a[r][i])
				{
					q[++rear]=i;
					visited[i]=true;
					System.out.println((char)(i+65));
				}
			}
		}
	}
}

class Demo
{
	public static void main(String[] args) 
	{
		boolean x=true;
		Graph g = new Graph(4,x);
		g.display();

// use dfs, sdfs or bfs --> one at a time 
		
		//g.dfs(0);
		System.out.println();
		
		//System.out.println("DFS With Stack");
		//g.sdfs(0);

		
		System.out.println();
		System.out.println("BFS (Without stack and recurssion)");
		g.bfs(2);
	}
}