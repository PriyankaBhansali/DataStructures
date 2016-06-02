import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Stack;

public class Solution {
		
		public int solution(String S) throws IOException{
	        
			Stack st = new Stack();
			
			File f = new File(S);
	        //get all the files from a directory
	        FileFilter file_filter = new FileFilter() {
				public boolean accept(File file) {
					return file.isDirectory();
				}
			};
			
			
			File[] filesList = f.listFiles(file_filter);
			for (File fileName : filesList) {
				if (fileName.isDirectory()){
					//System.out.println(fileName.getCanonicalPath());
					st.push(fileName.getCanonicalPath());
				} 
				
				//System.out.println();
				//System.out.println(fileName.getCanonicalPath().length());
			}
			
			for (File fileName : filesList) {
				if (fileName.isDirectory()){
					//System.out.println(st.pop());
					File directory = new File((String) st.pop());
					
					File[] fList = directory.listFiles();
			        
					for (File file : fList){
//			            if (file.isFile()){
//			                System.out.println(file.getName());
//			            }
			            if (file.toString().endsWith(".jpeg") || file.toString().endsWith(".png") || 
			            		file.toString().endsWith(".gif")) {
			            	System.out.println(file.getCanonicalPath());
			            	System.out.println(file.getCanonicalPath().length());
			            	return file.getCanonicalPath().length();
		                }
			        }		
				}
			}
			
			return 0;
		}
		
	
	public static void main (String[] args) throws IOException{
        Solution sol = new Solution();
        String Test ="/Users/PriyankaBhansali/";
        sol.solution(Test);
	}
}