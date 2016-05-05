 package testpack;

public class Palindrome {

	public static void main(String args[])
	{
		String reverseString="";
		String s = "abcbd";
		//String inputString = "123";

		int length = s.length();

		for ( int i = length - 1 ; i >= 0 ; i-- )
			reverseString = reverseString + s.charAt(i);

		if (s.equals(reverseString))
			System.out.println("Input string is a palindrome.");
		else
			System.out.println("Input string is not a palindrome.");

		
		String a = longestPalindrome1("abapcjbryjk");
		System.out.println(a);
	}
	
	public static String longestPalindrome1(String s) {
		 
		int maxPalinLength = 0;
		String longestPalindrome = null;
		int length = s.length();
	 
		// check all possible sub strings
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int len = j - i;
				String curr = s.substring(i, j + 1);
				if (isPalindrome(curr)) {
					if (len > maxPalinLength) {
						longestPalindrome = curr;
						maxPalinLength = len;
					}
				}
			}
		}
	 
		return longestPalindrome;
	}
	 
	public static boolean isPalindrome(String s) {
	 
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
	 
		return true;
	}
}
