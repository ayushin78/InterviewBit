/*
 *	Subset
 *	Given a set of distinct integers, S, return all possible subsets.
 *	 Note:
 *	Elements in a subset must be in non-descending order.
 *	The solution set must not contain duplicate subsets.
 *	Also, the subsets should be sorted in ascending ( lexicographic ) order.
 *	The list is not necessarily sorted.
 *	Example : If S = [1,2,3], a solution is:
 *	[
 *	  [],
 *	  [1],
 *	  [1, 2],
 *	  [1, 2, 3],
 *	  [1, 3],
 *	  [2],
 *	  [2, 3],
 *	  [3],
 *	]
 */


public class Solution {
    public int[][] subsets(int[] A) {
        Arrays.sort(A);
        return getSubsets(A, 0);
    }
    
    public int[][] getSubsets(int[]A, int a){
        if(a == A.length){
            return new int[1][0];
        }
        
        int[][] smallAns = getSubsets(A, a + 1);
        
        int ans[][] = new int[2 * smallAns.length][];
        int k = 0;

        ans[k++] = smallAns[0];
       
        for(int i = 0; i < smallAns.length ; i++){
          ans[k] = new int[smallAns[i].length + 1];
          ans[k][0] = A[a];
           
          for(int j = 0; j < smallAns[i].length; j++){
              ans[k][j + 1] = smallAns[i][j];
          }
        
	  k++;
        }
       
        for(int i = 1; i < smallAns.length; i++){
           ans[k++] = smallAns[i];
        }
        
	return ans;
    }
}



