package testpack;

class NotSaved {

	static void NGE(int a[]) {

		for (int i = 0; i <= a.length - 1; i++) 
		{
			boolean x = false;
			for (int j = i + 1; j <= a.length - 1; j++) 
			{
				if (a[j] > a[i]) 
				{
					x = true;
					System.out.println(a[i] + " --> " + a[j]);
					break;
				}
			}
			if (x == false)
				System.out.println(a[i] + " --> -1");
		}
	}

	public static void main(String[] args) {

		int a[] = { 11, 13, 21, 3 };
		NGE(a);
		System.out.println();

	}


}