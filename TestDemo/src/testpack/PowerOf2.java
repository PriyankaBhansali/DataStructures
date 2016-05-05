package testpack;

public class PowerOf2 {

	public static void main(String a[]){

		for (int i = 1; i <= 100; i++) {
			if ((i & (i - 1)) == 0 && i>0)
				System.out.println(i);
			
//					2    =  00000010 
//					4    =  00000100 
//					8    =  00001000 
//					16   =  00010000 
//					256  = 100000000
			
//					If we subtract 1 from any of these numbers we get the following:
//
//					2 - 1 = 1 = 00000001 
//					4 - 1 = 3 = 00000011 
//					8 - 1 = 7 = 00000111
//
//					bitwise and (& operator) on the original number and 
//					the number which results when 1 is subtracted is always zero
//			
//					2 & 1 = 00000010 & 00000001 = 0 
//					8 & 7 = 00001000 & 00000111 = 0
		}  
		
		System.out.println();
		System.out.println("....");
		System.out.println();
		
		for (int n = 1; n <= 100; n++) {
			if( (n & -n) == n)
				//passed parameter is a power of 2
				System.out.println(n);
		}
		
//		1: Binary representation of 1
//
//		0000 0000 0000 0000 0000 0000 0000 0001
//
//		-1: Computation of binary representation of -1 by finding 2's complement of 1
//
//		1111 1111 1111 1111 1111 1111 1111 1110 (1's complement of '1')
//		0000 0000 0000 0000 0000 0000 0000 0001 (adding 1)
//		--------------------------------------- 
//		1111 1111 1111 1111 1111 1111 1111 1111 (-1 = 2's complement of 1)
//
//		1 & -1: applying bit-wise AND (&) operator on 1 and -1
//
//		0000 0000 0000 0000 0000 0000 0000 0001
//		1111 1111 1111 1111 1111 1111 1111 1111
//		---------------------------------------
//		0000 0000 0000 0000 0000 0000 0000 0001 (1 & -1)
//
//		Thus we see that the test ((1 & -1) == 1) will return 'true'. This is correct as 1 is a power of 2 (1 = 2^0).
//
//		2 & -2: applying bit-wise AND on 2 and -2
//
//		0000 0000 0000 0000 0000 0000 0000 0010 (binary rep of 2)
//		1111 1111 1111 1111 1111 1111 1111 1110 (-2 = 2's comp of 2)
//		---------------------------------------
//		0000 0000 0000 0000 0000 0000 0000 0010 (2 & -2)
//
//		i.e., ((2 & -2) == 2) will return 'true' and that's correct as 2 is again a power of 2 (2 = 2^1)
//
//		3 & -3: applying bit-wise AND on 3 and -3
//
//		0000 0000 0000 0000 0000 0000 0000 0011 (binary rep of 3)
//		1111 1111 1111 1111 1111 1111 1111 1101 (-3 = 2's comp of 3)
//		---------------------------------------
//		0000 0000 0000 0000 0000 0000 0000 0001 (3 & -3)
//
//		i.e., ((3 & -3) == 3) will return 'false' which is correct as 3 is not a power of 2.
		
	}
}