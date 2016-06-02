package testpack;

public class StringTest3 {

	public static void main(String[] args) {
		  String str1 = "Strings are immutable";
		  String str = str1;
	      String str2 = "Strings are immutable";
	      String str3 = "Integers are not immutable";

	      int result = str1.compareTo( str2 );
	      System.out.println(result);
	      
	      result = str1.compareTo( str );
	      System.out.println(result);
		  
	      result = str1.compareTo( str3 );
	      System.out.println(result);
	      
	      result = str2.compareTo( str3 );
	      System.out.println(result);
		 
	      result = str3.compareTo( str1 );
	      System.out.println(result);
	      
	      String Str1 = new String("This is really not immutable!!");
	      String Str2 = Str1;
	      String Str3 = new String("This is really not immutable!!");
	      String Str4 = new String("This IS REALLY NOT IMMUTABLE!!");
	      boolean retVal;

	      retVal = Str1.equals( Str2 );
	      System.out.println("Returned Value = " + retVal );

	      retVal = Str1.equals( Str3 );
	      System.out.println("Returned Value = " + retVal );

	      retVal = Str1.equals( Str4 );
	      System.out.println("Returned Value = " + retVal );
	}

}
