/*
 *	Combination Sum
 *	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. The same repeated number may be chosen from C unlimited number of times.
 *	 Note:
 *	All numbers (including target) will be positive integers.
 *	Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *	The combinations themselves must be sorted in ascending order.
 *	CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
 *	The solution set must not contain duplicate combinations.
 *	Example, Given candidate set 2,3,6,7 and target 7, A solution set is:
 *	[2, 2, 3]
 *	[7]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        
        findCombinations(ans, A, 0, B, new ArrayList<Integer>());
        
        return ans;
    }
    
    public void findCombinations(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer>candidates, int index, int sum, ArrayList<Integer>combination)
    {
        if(sum == 0){
            ans.add(new ArrayList<Integer>(combination));
            return;
        }
        
        if(sum < 0){
            return;
        }
        
        for(int i = index; i < candidates.size(); i++){
           if(i == 0 || candidates.get(i) != candidates.get(i - 1)){
                combination.add(candidates.get(i));
                findCombinations(ans, candidates, i, sum - candidates.get(i), combination);
                combination.remove(combination.size() - 1);
           }
        }
    }
}

