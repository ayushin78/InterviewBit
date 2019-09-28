/*
 *	Sub-matrix Sum Queries
 *	Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the submatrix sum. Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out. Note: Rows are numbered from top to bottom and columns are numbered from left to right. Sum may be large so return the answer mod 10^9 + 7. 
 *	
 *	Input Format
 *	The first argument given is the integer matrix A.
 *	The second argument given is the integer array B.
 *	The third argument given is the integer array C.
 *	The fourth argument given is the integer array D.
 *	The fifth argument given is the integer array E.
 *	(B[i], C[i]) represents the top left corner of the i'th query.
 *	(D[i], E[i]) represents the bottom right corner of the i'th query.
 *	
 *	Output Format
 *	Return the submatrix sum (% 10^9 + 7) for each query in the form of an integer array.
 *	
 *	Constraints
 *	1 <= N, M <= 1000
 *	-100000 <= A[i] <= 100000
 *	1 <= Q <= 100000
 *	1 <= B[i] <= D[i] <= N
 *	1 <= C[i] <= E[i] <= M
 *	
 *	For Example
 *	Input 1:
 *	    A = [   [1, 2, 3]
 *	            [4, 5, 6]
 *	            [7, 8, 9]   ]
 *	    B = [1, 2]
 *	    C = [1, 2]
 *	    D = [2, 3]
 *	    E = [2, 3]
 *	Output 1:
 *	    [12, 28]
 *	
 *	Input 2:
 *	    A = [   [5, 17, 100, 11]
 *	            [0, 0,  2,   8]    ]
 *	    B = [1, 1]
 *	    C = [1, 4]
 *	    D = [2, 2]
 *	    E = [2, 4]
 *	Output 2:
 *	    [22, 19]
 *	
 *	
 */

public class Solution {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int M = 1000000007; 
        int Q = B.length;
        int output[] = new int[Q];
        /*
         BRUTE FORCE APPROACH : TIME COMPLEXITY = O(Q*m*n)
            for(int i = 0; i < Q; i++){
                int top = B[i] - 1;
                int left = C[i] - 1;
                int bottom = D[i] - 1;
                int right = E[i] - 1;
                
                int sum = 0;
                for(int j = top; j <= bottom; j++){
                    for(int k = left; k <= right; k++){
                        sum = (sum + A[j][k]) % M;            
                    }
                }
                
                output[i] = sum;
            }
            
            return output;
        */
        
        /* 
            PREFIX SUM APPROACH
        */
        
        // Perform column sum
        for(int i = 0; i < A.length; i++){
            for(int j = 1; j < A[0].length; j++){
                A[i][j] = (A[i][j] + A[i][j - 1]) % M;
            }
        }
        
        // Perform Row sum. The matrix will become prefix sum now.
        for(int j = 0; j < A[0].length; j++){
            for(int i = 1; i < A.length; i++){
                A[i][j] = (A[i][j] + A[i - 1][j]) % M;
            }
        }
        
        for(int i = 0; i < Q; i++){
            int top = B[i] - 1;
            int left = C[i] - 1;
            int bottom = D[i] - 1;
            int right = E[i] - 1;
            
            /*
             * For every submatrix, 
             * sum = A[bottom][right] - A[top - 1][right] - A[bottom][left - 1] + A[top - 1][right - 1]
             *
            */
            
            int sum = A[bottom][right];
            
            if(top > 0){
                sum = (sum - A[top - 1][right]) % M;
            }
            
            if(left > 0){
                sum = (sum - A[bottom][left - 1]) % M ;
            }
            
            if(top > 0 && left > 0){
                sum = (sum + A[top - 1][left - 1]) % M;
            }
        
            // If sum is negative, make it postive            
            sum = (sum + M) % M;
            output[i] = sum;
        }
        
        return output;
    }
}

