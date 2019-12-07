 /*
 *	Rotated Sorted Array Search
 *	Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ). You are given a target value to search. If found in the array, return its index, otherwise return -1. You may assume no duplicate exists in the array.
 *	Input : [4 5 6 7 0 1 2] and target = 4
 *	Output : 0
 *	
 */

public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> a, int b) {
	    int low = 0;
	    int high = a.size() - 1;
	    
	    while(low <= high){
	        int mid = low + (high - low)/2;
            int midElement = a.get(mid);
            
	        if(midElement == b){
	            return mid;
	        }
	        if(midElement <= a.get(high)){
	            if(b >= midElement && b <= a.get(high)){
	                low = mid + 1;
	            }else{
	                high = mid - 1;
	            }
	        }else if(b <= midElement && b >= a.get(low)){
	           high = mid - 1;
	        }else{
	            low = mid + 1;
	        }
	    }
	    
	    return -1;
	}
}

