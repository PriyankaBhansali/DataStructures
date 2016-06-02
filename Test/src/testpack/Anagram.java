package testpack;
class Anagrams
{
	char arr[] = new char[100];
    int count = 0;
    
	public Anagrams(String a) {
		arr = a.toCharArray();
		doAnagram(arr.length);
	}

	void rotate(int n)
	{
		int i;
		int pos = arr.length-n;
		char t = arr[pos];
		for(i=pos+1; i<arr.length;i++)
			arr[i-1] = arr[i];
		arr[i-1]=t;
	}

	void doAnagram(int n)
	{
		if(n==1)
			return;
		for(int i=0; i<n;i++)
		{
			doAnagram(n-1);
			if(n==2)
				displayWord();
			rotate(n);
		}
	}

	void displayWord()
	{
		for(int i=0; i<arr.length;i++)
			System.out.print(arr[i]);
		count++;
		System.out.println(" " + count);
	}

}


public class Anagram {
	
	
	public static void main(String[] args) throws Exception 
	{
		Anagrams a = new Anagrams("abc");
		System.out.println("Count is " +a.count);
	}

	
}
