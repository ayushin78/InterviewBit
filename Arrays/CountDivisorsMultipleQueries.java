/*
 *	Count of divisors for multiple queries
 *	Given an array of integers A, find and return the count of divisors of each element of the array. Note: Order of the resultant array should be same as the input array. 
 *	Input Format
 *	The only argument given is the integer array A.
 *	Output Format
 *	Return the count of divisors of each element of the array in the form of an array.
 *	Constraints
 *	1 <= length of the array <= 100000
 *	1 <= A[i] <= 10^6
 *	For Example
 *	Input 1:
 *	    A = [2, 3, 4, 5]
 *	Output 1:
 *	    [2, 2, 3, 2]
 *	
 *	Input 2:
 *	    A = [10, 20]
 *	Output 2:
 *	    [4, 6]
 *	
 */	

/******************************************************************************
 1ST METHOD : SIEVE OF ERATOSTHENES
 
 Time Complexity : 
 *****************************************************************************/

 public class Solution {
    public int[] solve(int[] A) {
        int max = 1;
        for(int i = 0; i < A.length; i++){
            max = Math.max(A[i], max);
        }

        int count[] = new int[max + 1];
        for(int i = 1; i <= max; i++){
            int j = 1;
            while(i * j <= max){
                count[i * j]++;
                j++;
            }
        }

        int output[] = new int[A.length];
        for(int i = 0; i < A.length; i++){
            output[i] = count[A[i]];
        }

        return output;
    }
}

