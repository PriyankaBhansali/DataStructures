package testpack;

import java.util.Arrays;

public class CCode_arrays {

	
//	static boolean unique (String str)
//    {
//		if(str.length()>256) return false;
//		
//		boolean a[] = new boolean[256];
//		for(int i=0; i <str.length();i++)
//		{
//			int val = str.charAt(i);
//			char v = str.charAt(i);
//			System.out.println(v);
//			System.out.println(val);
//			if(a[val]) 
//				return false;
//			
//			a[val] = true;
//		}
//		
//		return true;
//    }
	
	
	
	
	static String sort (String s)
    {
		
		char a[] = s.toCharArray();
		
		Arrays.sort(a);
		System.out.println(String.valueOf(a));
		String str = (String) new String(a);
//		char p[] = new char[]{'a','d'};
//		System.out.println(String.valueOf(p));
		//return new String(a);
		return str;
		
		//or
		//return String.valueOf(a);
		
    }
	
	
	
	static boolean permutations(String s, String t)
	{
		if(s.length() != t.length())
		{
			return false;
		}
		
		int letters[] = new int[256];
		
		char s_array[] = s.toCharArray();
		
		
		for(char i : s_array)
		{
			letters[i]++;
			System.out.println(i + "  "+ letters[i]);
		}
	
		for(int i = 0; i< t.length();i++)
		{
			int c = (int)t.charAt(i);
			System.out.println(c + "  " +letters[c]);
			
			if(--letters[c]<0)
			return false;
		}
			
		
		return true;
	}
	
	
	
	static void replaceSpaces(char str[], int length)
	{
		int spaceCount = 0, newLength, i;
		
		for(i=0; i<length;i++)
		{
			System.out.println(str[i]);
			if(str[i]==' ')
				spaceCount++;
		}
		
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for(i=length-1; i>= 0; i--)
		{
			if(str[i]==' ')
			{
				str[newLength-1] = '0';
				str[newLength-2] = '2';
				str[newLength-3] = '%';
				newLength = newLength-3;
			}
			else
			{
			str[newLength-1]=str[i];
			newLength = newLength-1;
			}
		}
		System.out.println(str);
	}
	
	static void matrix()
	{
		int[][] matrix = 
			{
			  { 1, 2, 3 },
			  { 4, 5, 6 },
			  { 7, 0, 9 }
			};
			  
		for (int i = 0; i < matrix.length; i++) 
		{
		    for (int j = 0; j < matrix[0].length; j++)
		    {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.print("\n");
		}
		System.out.println();
		
		boolean row[] = new boolean[matrix.length];
		boolean column[] = new boolean[matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) 
		{
		    for (int j = 0; j < matrix[0].length; j++)
		    {
		        if(matrix[i][j] == 0)
		        {
		        	row[i] = true;
		        	column[j] = true;
		        }
		    }
		}
		
		for (int i = 0; i < matrix.length; i++) 
		{
		    for (int j = 0; j < matrix[0].length; j++)
		    {
		        if(row[i] || column[j])
		        	matrix[i][j] = 0;
		    }
		}
		
		for (int i = 0; i < matrix.length; i++) 
		{
		    for (int j = 0; j < matrix[0].length; j++)
		    {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.print("\n");
		}
	}
	
	static boolean isRotation(String s1, String s2)
	{
		int len = s1.length();
		
		if(len == s2.length() && len > 0)
		{
			String s1s1 = s1 +s1;
			System.out.println(s1s1);
			System.out.println(s2);
			return s1s1.contains(s2);
		}
		return false;
	}
	
	public static void main(String args[])
	{
		//boolean ans = unique("Aa");
        //System.out.println(ans);
        
        System.out.println(sort("priyanka"));
        
        System.out.println(permutations("dogg","ggod"));
//        char[] str = {'a', 'b', ' ', 'c'};
//        replaceSpaces(str,6);
//        
        System.out.println();
        matrix();
        
        System.out.println(isRotation("waterbottle", "erbottlewat"));
	}
}
