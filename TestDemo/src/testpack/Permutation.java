package testpack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//
//import java.util.ArrayList;
//
public class Permutation {

//	public static ArrayList<String> permutation(String s) {
//	    // The result
//	    ArrayList<String> res = new ArrayList<String>();
//	    // If input string's length is 1, return {s}
//	    if (s.length() == 1) {
//	        res.add(s);
//	    } else if (s.length() > 1) {
//	        int lastIndex = s.length() - 1;
//	        // Find out the last character
//	        String last = s.substring(lastIndex);
//	        // Rest of the string
//	        String rest = s.substring(0, lastIndex);
//	        // Perform permutation on the rest string and
//	        // merge with the last character
//	        res = merge(permutation(rest), last);
//	    }
//	    return res;
//	}
//
//	public static ArrayList<String> merge(ArrayList<String> list, String c) {
//	    ArrayList<String> res = new ArrayList<String>();
//	    // Loop through all the string in the list
//	    for (String s : list) {
//	        // For each string, insert the last character to all possible positions
//	        // and add them to the new list
//	        for (int i = 0; i <= s.length(); ++i) {
//	            String ps = new StringBuffer(s).insert(i, c).toString();
//	            res.add(ps);
//	        }
//	    }
//	    return res;
//	}


//	public static void permutation(String str) { 
//		permutation("", str); 
//	}
//
//	private static void permutation(String prefix, String str) {
//		int n = str.length();
//		if (n == 0) System.out.println(prefix);
//		else {
//			for (int i = 0; i < n; i++)
//				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
//		}
//	}
	
	public static void permute(String s) {
	    if(null==s || s.isEmpty()) {
	        return;
	    }

	    // List containing words formed in each iteration 
	    List<String> strings = new LinkedList<String>();
	    strings.add(String.valueOf(s.charAt(0))); // add the first element to the list

	     // Temp list that holds the set of strings for 
	     //  appending the current character to all position in each word in the original list
	    List<String> tempList = new LinkedList<String>(); 

	    for(int i=1; i< s.length(); i++) {

	        for(int j=0; j<strings.size(); j++) {
	            tempList.addAll(merge(s.charAt(i), strings.get(j)));
	                        }
	        strings.removeAll(strings);
	        strings.addAll(tempList);

	        tempList.removeAll(tempList);

	    }

	    for(int i=0; i<strings.size(); i++) {
	        System.out.println(strings.get(i));
	    }
	}

	/**
	 * helper method that appends the given character at each position in the given string 
	 * and returns a set of such modified strings 
	 * - set removes duplicates if any(in case a character is repeated)
	 */
	private static Set<String> merge(Character c,  String s) {
	    if(s==null || s.isEmpty()) {
	        return null;
	    }

	    int len = s.length();
	    StringBuilder sb = new StringBuilder();
	    Set<String> list = new HashSet<String>();

	    for(int i=0; i<= len; i++) {
	        sb = new StringBuilder();
	        sb.append(s.substring(0, i) + c + s.substring(i, len));
	        list.add(sb.toString());
	    }

	    return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permute("abcd");
		
	}

}


//public class Permutation {
//
//public static void main(String[] args) throws Exception {
//    String str = "abcd";
//    StringBuffer strBuf = new StringBuffer(str);
//    doPerm(strBuf,str.length());
//
//}
//
//private static void doPerm(StringBuffer str, int index){
//
//    if(index <= 0)
//        System.out.println(str);            
//    else { //recursively solve this by placing all other chars at current first pos
//        doPerm(str, index-1);
//        int currPos = str.length()-index;
//        for (int i = currPos+1; i < str.length(); i++) {//start swapping all other chars with current first char
//            swap(str,currPos, i);
//            doPerm(str, index-1);
//            swap(str,i, currPos);//restore back my string buffer
//        }
//    }
//}
//
//private  static void swap(StringBuffer str, int pos1, int pos2){
//    char t1 = str.charAt(pos1);
//    str.setCharAt(pos1, str.charAt(pos2));
//    str.setCharAt(pos2, t1);
//} 
//}   


