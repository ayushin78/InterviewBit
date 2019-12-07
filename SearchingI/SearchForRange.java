 /*	
 *	Search for a Range
 *	Given a sorted array of integers, find the starting and ending position of a given target value. Your algorithm's runtime complexity must be in the order of O(log n). If the target is not found in the array, return [-1, -1]. Example: Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 *	
 */

public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
	    ArrayList<Integer> ans = new ArrayList<>();
	
	    
	    int low = 0;
	    int high = a.size() - 1;
	    
	    while(low <= high){
	        int mid = low + (high - low)/2;
	        if(a.get(mid) > b){
	            high = mid - 1;
	        }else if(a.get(mid) < b){
	            low = mid + 1;
	        }else{
	            if(mid > 0 && a.get(mid - 1) == b){
	                 high = mid - 1;
	            }
	            else{
	                ans.add(mid);
	                break;
	            }
	        }
	    }
	    
	    if(ans.size() == 0){
	        ans.add(-1);
	        ans.add(-1);
	        return ans;
	    }
	    
	    low = ans.get(0);
	    high = a.size() - 1;
	    
	     while(low <= high){
	        int mid = low + (high - low)/2;
	        if(a.get(mid) > b){
	            high = mid - 1;
	        }else if(a.get(mid) < b){
	            low = mid + 1;
	        }else{
	            if(mid < (a.size() - 1) && a.get(mid + 1) == b){
	               low = mid + 1;
	            }else{
	               ans.add(mid);
	               break;
	            }
	        }
	    }
	    
	    return ans;
	    
	}
}

