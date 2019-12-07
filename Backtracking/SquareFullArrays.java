	* 
	* Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square. Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[ i ] != A2[ i ]. 
	* Input Format
	* The only argument given is the integer array A.
	* Output Format
	* Return the number of permutations of A that are squareful.
	* Constraints
	* 1 <= length of the array <= 12
	* 1 <= A[i] <= 10^9 
	* For Example
	* Input 1:
	*     A = [2, 2, 2]
	* Output 1:
	*     1
	* 
	* Input 2:
	*     A = [1, 17, 8]
	* Output 2:
	*     2
	* 
public class Solution {
    public int solve(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
			Collections.sort(arr);
			getPermutations(ans, arr, new ArrayList<Integer>());
			return ans.size();
    }

    	private static void getPermutations(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> candidates, ArrayList<Integer> permutation) {
			// TODO Auto-generated method stub
			if(candidates.size() == 0 && permutation.size() > 1) {
				ans.add(new ArrayList<Integer>(permutation));
				return;
			}
			
			for(int i = 0; i < candidates.size(); i++) {
				if(i == 0 || (int)candidates.get(i) != (int)candidates.get(i - 1)) {
					
					int num = candidates.get(i);
					candidates.remove(i);
					int sum = num;
					if(permutation.size() > 0)
						  sum += permutation.get(permutation.size() - 1) ;
					
					int sqrt = (int)Math.sqrt(sum);
					if(permutation.size() == 0 || sqrt * sqrt == sum) {
						permutation.add(num);
						getPermutations(ans,  candidates, permutation);
						permutation.remove(permutation.size() - 1);
						
					}
					candidates.add(i, num);
				}
			}
			
		}
}


