package testpack;

class Search
{
	public int search(int a[], int target) {
	    int left = 0;
	    int right= a.length-1;
	 
	    while(left<=right){
	        int mid = left + (right-left)/2;
	        if(target==a[mid])
	            return mid;
	 
	        if(a[left]<=a[mid]){
	            if(a[left]<=target&& target<a[mid]){
	                right=mid-1;
	            }else{
	                left=mid+1;
	            }
	        }else{
	            if(a[mid]<target&& target<=a[right]){
	                left=mid+1;
	            }else{
	                right=mid-1;
	            }
	        }    
	    }
	 
	    return -1;
	}
	
	
	public int search_recursive(int[] a, int target) {
	    return binarySearch(a, 0, a.length-1, target);
	}
	 
	public int binarySearch(int[] a, int left, int right, int target){
	    if(left>right) 
	        return -1;
	 
	    int mid = left + (right-left)/2;
	 
	    if(target == a[mid])
	        return mid;
	 
	    if(a[left] <= a[mid]){
	        if(a[left]<=target && target<a[mid]){
	          return binarySearch(a,left, mid-1, target);
	        }else{
	          return  binarySearch(a, mid+1, right, target);
	        }
	    }else {
	        if(a[mid]<target&& target<=a[right]){
	          return  binarySearch(a,mid+1, right, target);
	        }else{
	          return  binarySearch(a, left, mid-1, target);
	        }
	    }
	}

//	FindSortedArrayRotation, which takes as its input an array of unique integers 
//	that has been sorted in ascending order, then rotated by an unknown amount X 
//	where 0 <= X <= (arrayLength - 1). An array rotation by amount X 
//	moves every element array[i] to array[(i + X) % arrayLength]. 
//	FindSortedArrayRotation discovers and returns X by examining the array.
	
	int FindSortedArrayRotation(int A[], int N) {
		  int left = 0;
		  int right = N - 1;
		  
		  while (A[left] > A[right]) {
		    int mid = left + (right - left) / 2;
		    if (A[mid] > A[right])
		      left = mid + 1;
		    else
		      right = mid;
		  }
		  return left;
		}
	

}

public class SearchInRotatedSortedArray {

	public static void main(String args[]){
		Search s = new Search();
		int a[] = {3,5,6,7,9};
		int n = s.search(a, 3);
		System.out.println(n);
		
	    n = s.search_recursive(a, 6);
		System.out.println(n);
	}
}
