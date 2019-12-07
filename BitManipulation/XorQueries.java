/*
 *	Xor queries
 *	You are given an array (containing only 0 and 1) as element of N length. Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array. Input
 *	First argument contains the array of size N containing 0 and 1 only (1<=N<=100000). 
 *	
 *	Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R. 
 *	
 *	(1<=Q<=100000), (1<=L<=R<=N).
 *	Output
 *	Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.
 *	Examples Input
 *	1 0 0 0 1
 *	2 4
 *	1 5 
 *	3 5
 *	Output
 *	0 3
 *	0 3
 *	1 2
 *	Explanation Testcase 1-
 *	In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1. For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3. Similarly for other queries.
 *
 */


public class Solution {
    public int[][] solve(int[] A, int[][] B) {
        int Q = B.length;
        int ans[][] = new int[Q][2];
        int count[] = new int[A.length];
        int xor[] = new int[A.length];
        int max = 0;
        
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                max++;
            }    
            count[i] = max;
            xor[i] = (i > 0) ? (xor[i - 1] ^ A[i]):A[i];
        }
        
        for(int i = 0; i < Q; i++){
            int left = Math.max(B[i][0] - 1, 0);
            int right = Math.max(B[i][1] - 1, 0);
            
            if(left == 0){
                ans[i][0] = xor[right];
                ans[i][1] = count[right];
            }else{
                ans[i][0] = xor[left - 1] ^ xor[right];
                ans[i][1] = count[right] - count[left - 1];
            }
        }        
        
        
        return ans;
    }
}

