/*
 *	Excel Column Title
 *	Given a positive integer, return its corresponding column title as appear in an Excel sheet. For example:
 *	    1 -> A
 *	    2 -> B
 *	    3 -> C
 *	    ...
 *	    26 -> Z
 *	    27 -> AA
 *	    28 -> AB 
 *
 * /


public class Solution {
    public String convertToTitle(int A) {
        String ans = "";
        while( A > 0){
            int rem = A % 26;
            if(rem == 0){
                ans = "Z" + ans;
                A = A/26 - 1;
            }
            else{
                ans = (char)((rem - 1) + 'A') + ans;
                A = A/26;
            }
        }
        
        return ans;
    }
}

