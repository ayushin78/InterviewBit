 /*
 *	Single Number
 *	Given an array of integers, every element appears twice except for one. Find that single one. Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? Example :
 *	Input : [1 2 2 3 1]
 *	Output : 3
 *	
 *
 */

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int ans = 0;
        for(int i = 0; i < A.length; i++){
            ans = ans ^ A[i];
        }
        return ans;
    }
}

