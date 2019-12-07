 /*
 *	Single Number II
 *	Given an array of integers, every element appears thrice except for one which occurs once. Find that element which does not appear thrice. Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? Example :
 *	Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
 *	Output : 4
 *
 */

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int ans = 0;
        
        for(int i = 0; i < 32; i++){
            int k = 1 << i;
            int ones = 0;
            
            for(int j = 0; j < A.length; j++){
                if((k & A[j]) != 0){
                    ones++;        
                }
            }
            
            if(ones%3 != 0){
                ans = ans | k;
            }
        }
        
        return ans;
       
    }
}

