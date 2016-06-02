class Digit
{
    int solution(int X)
    {
    	String digit = Integer.toString(X);
    	//String str = String.valueOf(X);
    	System.out.println(digit.length());
    	int largest = 0;
    	for(int i = 0; i < digit.length()-1; i++)
    	{
           if(digit.charAt(i)==digit.charAt(i+1))
           {
        	   System.out.println(digit + " ....i = " +i);
        	   System.out.println(digit.substring(0,i)+" ...0 to i");
        	   System.out.println(digit.substring(i+1)+" ...i+1");
        	   System.out.println();
        	   
        	   String new_digit = digit.substring(0,i) + digit.substring(i+1);
        	   System.out.println(new_digit + " ....new digit");
        	   
        	   Integer new_int_digit = Integer.parseInt(new_digit);
        	   if(new_int_digit > largest){
        		   largest = new_int_digit;
        	   }
        	   
        	   System.out.println();
           }
    	}
        return largest;
    }
 
    public static void main (String[] args) throws Exception
    {	
    	Digit d = new Digit();
        int largest = d.solution(223336226);
        System.out.println(largest);
    }
}