 /*
 *	Reverse Bits
 *	Reverse bits of an 32 bit unsigned integer Example 1: x = 0,
 *	          00000000000000000000000000000000  
 *	=>        00000000000000000000000000000000
 *	return 0 Example 2: x = 3,
 *	          00000000000000000000000000000011 
 *	=>        11000000000000000000000000000000
 *	return 3221225472 Since java does not have unsigned int, use long
 */

public class Solution {
	public long reverse(long a) {
	    long ans = 0;
	    for(int i = 0; i < 32; i++){
	        long k = 1L << i;
	        if((k&a) != 0){
	            long reverse = 1L << (31 - i);
	            ans = ans | reverse;
	        }
	    }
	    return ans;
	}
}

