package testpack;

public class StringReverse {

	public static void main(String args[])
	{
		String inputString = "abcbd xyz";

		System.out.println();
		String reverseStr = new StringBuffer(inputString).reverse().toString();
		System.out.println("Reverse String using StringBuffer: " + reverseStr);
		System.out.println();
		
		String reverseStrng = new StringBuilder(inputString).reverse().toString();
		System.out.println("Reverse String using StringBuilder: " + reverseStrng);
		System.out.println();

		String r = reverseRecursively(inputString);
		System.out.println("Reverse string using recursion: "+r);

		System.out.println();
		System.out.println("Reverse Only Numbers...(method1) : " + reverse(2345));
		System.out.println("Reverse Only Numbers...(method2) : " + reverse1(12345));
		
		System.out.println();
		String upperlower = "THIS IS mixed string";
	      
        String lower = upperlower.toLowerCase(); //toLowerCase() return lowercase of String
        String upper = upperlower.toUpperCase();
        System.out.println("Original : " + upperlower);
        System.out.println("UpperCase : " + upper);
        System.out.println("LowerCase : " + lower);
        
        System.out.println();System.out.println();
        reverseString("I Am Not String");
        
        reverseString("JAVA JSP ANDROID");
         
        reverseString("1 22 333 4444 55555");
        
        System.out.println();System.out.println();
        reverseEachWordOfString("Java Concept Of The Day");
        
        reverseEachWordOfString("Java J2EE JSP Servlets Hibernate Struts");
         
        reverseEachWordOfString("I am string not reversed");
         
        reverseEachWordOfString("Reverse Me");
        
        String s1 = "I live in California";
        System.out.println(s1);
        System.out.println(s1.length());
        String s2 = reverseWords(s1);
        System.out.println(s2);
        System.out.println(s2.length());
        
        System.out.println();System.out.println();
        System.out.println(s1);
        System.out.println(s1.length());
        String s3 = new StringBuilder(s1).reverse().toString();
		System.out.println(s3+" --Reverse");
        reverseEachWordOfString(s3);
        System.out.println(s3.length());
	}

	public static String reverseRecursively(String str) {

		//base case to handle one char string and empty string
		if (str.length() < 2) {
			System.out.println(str);
			return str;
		}
		System.out.println(str.charAt(0));
		System.out.println("substring:::   " +str.substring(1));

		String abc = reverseRecursively(str.substring(1))+str.charAt(0);
		System.out.println(abc);
		return abc;
	}

	public static int reverse(int number){
		int reverse = 0;
		int remainder = 0;
		do{
			remainder = number%10;
			reverse = reverse*10 + remainder;
			number = number/10;

		}while(number > 0);

		return reverse;
	}

	public static int reverse1(int number){
		
		String a = String.valueOf(number);
		char b[] = a.toCharArray();
		String c = "";
		for (int i = b.length-1; i >= 0; i--) 
		{
			c=c+b[i];
		}
		return Integer.parseInt(c);
	}
	
	static void reverseString(String inputString)
    {
        //Converting inputString to char array 'inputStringArray'
         
        char[] inputStringArray = inputString.toCharArray();
         
        //Defining a new char array 'resultArray' with same size as inputStringArray
         
        char[] resultArray = new char[inputStringArray.length];
         
        //First for loop : 
        //For every space in the 'inputStringArray', 
        //we insert spaces in the 'resultArray' at the corresponding positions 
         
        for (int i = 0; i < inputStringArray.length; i++) 
        {
            if (inputStringArray[i] == ' ') 
            {
                resultArray[i] = ' ';
            }
        }
         
        //Initializing 'j' with length of resultArray
         
        int j = resultArray.length-1;
                 
        //Second for loop :
        //we copy every non-space character of inputStringArray 
        //from first to last at 'j' position of resultArray
         
        for (int i = 0; i < inputStringArray.length; i++)
        {
            if (inputStringArray[i] != ' ') 
            {
                //If resultArray already has space at index j then decrementing 'j'
                 
                if(resultArray[j] == ' ')
                {
                    j--;
                }
                 
                resultArray[j] = inputStringArray[i];
                 
                j--;
            }
        }
         
        System.out.println(inputString+" ---> "+String.valueOf(resultArray));
    }
	
	static void reverseEachWordOfString(String inputString)
    {
        String[] words = inputString.split(" ");
         
        String reverseString = "";
         
        for (int i = 0; i < words.length; i++) 
        {
            String word = words[i];
             
            String reverseWord = "";
             
            for (int j = word.length()-1; j >= 0; j--) 
            {
                reverseWord = reverseWord + word.charAt(j);
            }
             
            reverseString = reverseString + reverseWord + " ";
        }
         
        System.out.println(inputString);
         
        System.out.println(reverseString);
         
        System.out.println("-------------------------");
    }

	public static String reverseWords(String sentence) {
	    //does not remove extra spaces between 2 words
		String[] parts = sentence.split(" ");
	    
	    //removes extra spaces between 2 words
	    //String[] parts = sentence.trim().split("\\s+");
	    StringBuilder builder = new StringBuilder();
	    builder.append(parts[parts.length - 1]);

	    for (int i = parts.length - 2; i >= 0; --i) {
	        builder.append(" ").append(parts[i]);
	    }

	    return builder.toString();
	    
//	    StringBuilder sb = new StringBuilder(sentence.length() + 1);
//	    String[] words = sentence.split(" ");
//	    for (int i = words.length - 1; i >= 0; i--) {
//	        sb.append(words[i]).append(' ');
//	    }
//	    sb.setLength(sb.length() - 1);  // Strip trailing space
//	    return sb.toString();
	}
}
