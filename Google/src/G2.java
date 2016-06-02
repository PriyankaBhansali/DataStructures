import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class G2 {
	String directoryLinuxMac ="/Users/PriyankaBhansali/";
    /**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public void listFilesAndFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName());
        }
    }
    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getName());
            }
        }
    }
    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory

        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
                System.out.println();
            }
        }
        
    }
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public void listFilesAndFilesSubDirectories(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }
    
    
    public void a(String directoryName) throws IOException{
        File f = new File(directoryName);
        //get all the files from a directory
        FileFilter directoryFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
		
		File[] files = f.listFiles(directoryFilter);
		
		for (File file : files) {
			if (file.isDirectory()) 
			{
				System.out.print("directory:");
			} 
			else 
			{
				System.out.print("     file:");
			}
			System.out.println(file.getCanonicalPath());
			

		}
        
        
        
        
    }
    
    
    public static void main (String[] args) throws IOException{
        G2 listFilesUtil = new G2();
        String directoryLinuxMac ="/Users/PriyankaBhansali/";
        
        //listFilesUtil.listFolders(directoryLinuxMac);
        
        File f = new File("/Users/PriyankaBhansali/"); // current directory

    	FileFilter directoryFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};

		File[] files = f.listFiles(directoryFilter);
		
		for (File file : files) {
			if (file.isDirectory()) 
			{
				System.out.print("directory:");
			} 
			else 
			{
				System.out.print("     file:");
			}
			System.out.println(file.getCanonicalPath());
			
			listFilesUtil.a(file.getCanonicalPath());
		}
    }
}