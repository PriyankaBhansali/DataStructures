package testpack;

public class StringTest1 {

	public static void main(String a[]){

		String str = "This is an example string";
		System.out.println("Replace char 's' with 'o':\n"
				+str.replace('s', 'o'));

		System.out.println("Replace first occurance of string\"is\" with \"ui\":\n"
				+str.replaceFirst("is", "ui"));

		System.out.println("Replacing \"is\" every where with \"no\":\n"
				+str.replaceAll("is", "no"));
		
		System.out.println();
		
		System.out.println("Replace a character at a specific index in string");
		String myName = "priyanka";
		System.out.println("Original String: "+ myName);
		String newName = myName.substring(0,4)+'X'+myName.substring(5);
		System.out.println("\n"+newName);
		
		System.out.println("\nUsing string builder");
		StringBuilder my_name = new StringBuilder("Priyanka");
		my_name.setCharAt(4, 'X');
		System.out.println(my_name);
		
		System.out.println("\nUsing toCharArray");
		String my_Name = "priyankA";
		char[] myNameChars = my_Name.toCharArray();
		myNameChars[4] = 'X';
		my_Name = String.valueOf(myNameChars);
		System.out.println(my_Name + "\n");
		

		String s1 ="priyanka bhansali";
		String[] words = s1.trim().split(" ");
		 
        System.out.println("Number of words in string using split & trim = "
                              +words.length);
        
        int count1 = 1;
        for (int i = 0; i < s1.length()-1; i++)
        {
            if((s1.charAt(i) == ' ') && (s1.charAt(i+1) != ' '))
                count1++;
        }
        System.out.println("Number of words in a string using count method = "
                             +count1);
        System.out.println();System.out.println();
        
        
        String s2 = "Java is java again java again";
        int count2 = s2.length() - s2.replace("a", "").length();
 
        System.out.println("Number of occurances of 'a' in "+s2+" = "+count2);
    

        System.out.println();System.out.println();
        String str1 = "  Core Java jsp servlets   jdbc struts hibernate spring";
        
        //1. Using replaceAll() Method
        System.out.println("Using replaceAll");
        String strWithoutSpace = str1.replaceAll("\\s", "");
 
        System.out.println(strWithoutSpace);       
 
        //2. Without Using replaceAll() Method
        System.out.println("\n Witohout using replaceAll");
        char[] strArray = str1.toCharArray();
 
        StringBuffer sb = new StringBuffer();
 
        for (int i = 0; i < strArray.length; i++)
        {
            if( (strArray[i] != ' ') && (strArray[i] != '\t') )
            {
                sb.append(strArray[i]);
            }
        }
 
        System.out.println(sb); 
        
        // new String() is also immutable
        String s3 = new String("JAVA");
        
        System.out.println(s3);         //Output : JAVA
 
        s3.concat("J2EE");
 
        System.out.println(s3);         //Output : JAVA
	}

}   
