/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return ans;
    }
    
    public void backtrack(List<List<Integer>>ans, List<Integer> perm, int[] nums, boolean[] used) {
        if(perm.size() == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]){
                perm.add(nums[i]);
                used[i] = true;
                backtrack(ans, perm, nums, used);
                used[i] = false;
                perm.remove(perm.size() - 1);   
            }
        }
    }
}
