package testpack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringTest2 {

	static void duplicateWords(String inputString)
    {
        //Splitting inputString into words
 
        String[] words = inputString.split(" ");
 
        //Creating one HashMap with words as key and their count as value
 
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
 
        //Checking each word
 
        for (String word : words)
        {
            //whether it is present in wordCount
 
            if(wordCount.containsKey(word.toLowerCase()))
            {
                //If it is present, incrementing it's count by 1
 
                wordCount.put(word.toLowerCase(), wordCount.get(word.toLowerCase())+1);
            }
            else
            {
                //If it is not present, put that word into wordCount with 1 as it's value
 
                wordCount.put(word.toLowerCase(), 1);
            }
        }
 
        //Extracting all keys of wordCount
 
        Set<String> wordsInString = wordCount.keySet();
 
        //Iterating through all words in wordCount
 
        for (String word : wordsInString)
        {
            //if word count is greater than 1
 
            if(wordCount.get(word) > 1)
            {
                //Printing that word and it's count
 
                System.out.println(word+" : "+wordCount.get(word));
            }
        }
    }
	
	static void characterCount(String word)
    {
		char[] characters = word.toCharArray();

        // build HashMap with character and number of times they appear in String
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character ch : characters) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        // Iterate through HashMap to print all duplicate characters of String
        Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n", word);
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }
	
//	static void characterCount(String inputString)
//    {
//        //Creating a HashMap containing char as a key and occurrences as  a value
// 
//        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
// 
//        //Converting given string to char array
// 
//        char[] strArray = inputString.toCharArray();
// 
//        //checking each char of strArray
// 
//        for (char c : strArray)
//        {
//            if(charCountMap.containsKey(c))
//            {
//                //If char is present in charCountMap, incrementing it's count by 1
// 
//                charCountMap.put(c, charCountMap.get(c)+1);
//            }
//            else
//            {
//                //If char is not present in charCountMap,
//                //putting this char to charCountMap with 1 as it's value
// 
//                charCountMap.put(c, 1);
//            }
//        }
// 
//        //Printing the charCountMap
// 
//        System.out.println(charCountMap);
//    }

	
    public static void main(String[] args)
    {
        duplicateWords("Bread butter and bread");
 
        duplicateWords("Java is java again java");
 
        duplicateWords("Super Man Bat Man Spider Man");
        
        characterCount("Java J2EE Java JSP J2EE");
        
        characterCount("All Is Well");
  
        characterCount("Done And Gone");
       
    }
}