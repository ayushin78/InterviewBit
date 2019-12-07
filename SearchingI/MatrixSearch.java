 /*
 *	Matrix Search
 *	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *	Integers in each row are sorted from left to right.
 *	The first integer of each row is greater than or equal to the last integer of the previous row.
 *	Example: Consider the following matrix:
 *	[
 *	  [1,   3,  5,  7],
 *	  [10, 11, 16, 20],
 *	  [23, 30, 34, 50]
 *	]
 *	Given target = 3, return 1 ( 1 corresponds to true ) Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
 */

public class Solution {
	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
	    int m = a.size();
	    int n = a.get(0).size();
	    
	    int low = 0; 
	    int high = m - 1;
	    
	    int mid;
	    
	    while(low <= high){
	        mid = low + (high - low)/2;
	        if(b < a.get(mid).get(0)){
	            high = mid - 1;
	        }else if(b > a.get(mid).get(n - 1)){
	            low = mid + 1;
	        }else{
	            return binarySearch(a.get(mid), b);
	        }
	    }
	    
	    return 0;
	}
	
	public int binarySearch(ArrayList<Integer> arr, int b){
	    int high = arr.size() - 1;
	    int low = 0;
	    
	    int mid;
	    
	    while(low <= high){
	        mid = low + (high - low)/2;
	        
	        if(arr.get(mid) > b){
	            high = mid - 1;
	        }else if(arr.get(mid) < b){
	            low = mid + 1;
	        }else{
	            return 1;
	        }
	    }
	    
	    return 0;
	}
}

