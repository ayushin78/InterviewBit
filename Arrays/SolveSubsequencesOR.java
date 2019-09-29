 /*
 *	Solve sub-sequences and return OR
 *	A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements. For example, the sequence {2, 3, 5} is a subsequence of {1, 2, 3, 4, 5} obtained after removal of elements {1, 4}. Given is an array of integers A of size N. An array of size N can have (2^N - 1) number of non empty subsequences. For the given function:
 *	solve (int subsequence[]) {
 *	    int count[];    //array initialised to 0.
 *	    for(int i = 0; i < subsequence.length; i++) {
 *	        number = subsequence[i];
 *	        for(int j = 2; j <= number; j++) {
 *	            if(number % j == 0) {
 *	                count[j]++;
 *	                if(count[j] == subsequence.length)  return 0;
 *	            }
 *	        }
 *	    }
 *	    return 1;
 *	}
 *	If all the subsequences of the array A are passed in the above function. What will be the bitwise OR of all the returned values from the given function. 
 *	Input Format
 *	The only argument given is the integer array A.
 *	Output Format
 *	Return the bitwise OR of all the returned values.
 *	Constraints
 *	1 <= length of the array <= 100000
 *	1 <= A[i] <= 10^9 
 *	For Example
 *	Input 1:
 *	    A = [1, 2, 3]
 *	Output 1:
 *	    1
 *	
 *	Input 2:
 *	    A = [2, 4, 6, 8]
 *	Output 2:
 *	    0
 */	

public class Solution {
    public int solve(int[] A) {
        int combinedGCD = A[0];
        for(int i = 1; i < A.length; i++){
            combinedGCD = gcd(combinedGCD, A[i]);
        }
       return combinedGCD == 1? 1 : 0;
    }
    public int gcd(int a, int b){
        int divisor = (a < b) ? a : b;
        int dividend = (a < b) ? b : a;
        int remainder = dividend % divisor;
        
        while(remainder > 0){
            dividend = divisor;
            divisor = remainder;
            remainder = dividend % divisor;
        }
        
        return divisor;
    }
}

