 /*
 *	All Unique Permutations
 *	Given a collection of numbers that might contain duplicates, return all possible unique permutations. Example : [1,1,2] have the following unique permutations:
 *	[1,1,2]
 *	[1,2,1]
 *	[2,1,1]
 *	 NOTE : No 2 entries in the permutation sequence should be the same.
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Collections.sort(A);
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        findPermutations(ans, A, new ArrayList<Integer>());
        
        return ans;
    }
    public void findPermutations(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> candidates, ArrayList<Integer> permutation){
        if(candidates.size() == 0){
            ans.add(new ArrayList<Integer>(permutation));
            return ;
        }
        
        for(int i = 0; i < candidates.size(); i++){
            if(i == 0 || candidates.get(i) != candidates.get(i - 1)){
                int num = candidates.get(i);
                permutation.add(num);
                candidates.remove(i);
                findPermutations(ans, candidates, permutation);
                candidates.add(i, num);
                permutation.remove(permutation.size() - 1);
            }
            
        }
    }
}

