/*
 *	Preimage Size of Factorial Zeroes Function
 *	Let f(A) be the number of zeroes at the end of A!. (Recall that x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.) For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has 2 zeroes at the end. Given A, find how many non-negative integers x have the property that f(x) = A. Input Format:
 *	    First and only argument to input is a single integer A.
 *	Output Format:
 *	    Return a single integer denoting number of non-negative integers x having f(x) = A.
 *	Constraints:
 *	    0 <= A <= 10^9
 *	For Example:
 *	Input 1:
 *	    A = 0
 *	Output 1:
 *	    5
 *	Explanation:
 *	    0!, 1!, 2!, 3!, and 4! end with K = 0 zeroes.
 *	Input 2:
 *	    A = 5
 *	Output 2:
 *	    0
 */

public class Solution {
    public int solve(int A) {
        long low = 0L;
        long high = 5L * (A+1);
        
        long mid;
        
        while(low <= high){
            mid = low + (high - low)/2;
            int num = numOfTrailingZeroes(mid);
            
            if(num < A){
                low = mid + 1;
            }else if(num > A){
                high = mid - 1;
            }else{
                return 5;
            }
        }
        
        return 0;
    }

    int numOfTrailingZeroes(long n){
        int count = 0;
        for(long i = 5; n/i >= 1; i *= 5L){
            count += n/i;
        }
        return count;
    }
}

