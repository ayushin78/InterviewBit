 /*
 *	Interesting Array
 *	You have an array A[] with N elements. We have 2 types of operation available on this array :
 *	We can split a element B into 2 elements C and D such that B = C + D.
 *	We can merge 2 elements P and Q as one element R such that R = P^Q i.e XOR of P and Q.
 *	You have to determine whether it is possible to make array A[] containing only 1 element 0 after several splits and/or merge? Input
 *	The first argument is an array of size N containing integer values Ai. 
 *	(1<=N<=100000) 
 *	(1<=Ai<=10^6) 
 *	Output
 *	Return "Yes" if it is possible otherwise return "No".
 *	Examples Input
 *	9 17
 *	Output
 *	Yes
 *	Explanation Testcase 1-
 *	Following is one possible sequence of operations -  
 *	1) Merge i.e 9 XOR 17 = 24  
 *	2) Split 24 into two parts each of size 12  
 *	3) Merge i.e 12 XOR 12 = 0  
 *	As there is only 1 element i.e 0. So it is possible.
 *	
 */


public class Solution {
    public String solve(int[] A) {
        /* 
	 * Idea is to count the odd numbers in array. If count of odd numbers
	 * is even. That means their xor will be even and later can be split up
	 * to finally make the xor 0.
	 *
	 */


	int count = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 != 0){
                count++;
            }
        }

        if(count %2 == 0){
            return "Yes";
        }else{
            return "No";
        }

    }
}

