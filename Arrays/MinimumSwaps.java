/*
 *	Minimum swaps required to bring all elements less than or equal to k together
 *	Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together. Note: It is possible to swap any two elements, not necessarily consecutive. 
 *	Input Format
 *	The first argument given is the integer array A.
 *	The second argument given is the integer B.
 *	Output Format
 *	Return the minimum number of swaps.
 *	Constraints
 *	1 <= length of the array <= 100000
 *	-10^9 <= A[i], B <= 10^9 
 *	For Example
 *	Input 1:
 *	    A = [1, 12, 10, 3, 14, 10, 5]
 *	    B = 8
 *	Output 1:
 *	    2
 *	
 *	Input 2:
 *	    A = [5, 17, 100, 11]
 *	    B = 20
 *	Output 2:
 *	    1
 *	× 
 */

public class Solution {
    public int solve(int[] A, int B) {
        int count = 0;
        
        // Count total wanted elements that needs to be together
        for(int i = 0; i < A.length; i++){
            if(A[i] <= B){
                count++;
            }
        }
        
        
        // Count total unwanted elements in current window
        int unwanted = 0;
        for(int i = 0; i < count; i++){
            if(A[i] > B){
                unwanted++;
            }
        }
        
        // Minimum number of swaps initialized to total unwanted
        int minSwaps = unwanted;
        int prevStart = 0;
        int newEnd = count;
        
        // For each window, calculate total unwanted elements
        while(newEnd < A.length){
            if(A[prevStart] > B){
                unwanted--;
            }
            if(A[newEnd] > B){
                unwanted++;
            }
            
            minSwaps = Math.min(minSwaps, unwanted);
            prevStart++;
            newEnd++;
        }
        
        return minSwaps;
    }
}

