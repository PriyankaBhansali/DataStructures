package testpack;

public class Armstrong {

	public static void main(String args[]) {

//An Armstrong number of three digits is an integer such that 
//the sum of the cubes of its digits is equal to the number itself. 		
		for (int i=0;i<=500;i++)
		{
			boolean x = isArmStrong(i);
			if(x)
			{
				System.out.println("Number : " + i + " is an Armstrong number");
			}
		}
	}

	private static boolean isArmStrong(int number) {
		int result = 0;
		int orig = number;
		while(number != 0)
		{
			int remainder = number%10;
			result = result + remainder*remainder*remainder;
			number = number/10;
		}
				if(orig == result){
					return true;
				}

				return false;
	} 

}

