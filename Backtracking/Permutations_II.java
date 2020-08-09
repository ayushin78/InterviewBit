/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans, new ArrayList<Integer>(), new boolean[nums.length], nums);
        return ans;
    }
    public void dfs(List<List<Integer>> ans, List<Integer> permutation, boolean[] used, int[] nums) {
        if(permutation.size() == nums.length) {
            ans.add(new ArrayList<>(permutation));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            permutation.add(nums[i]);
            used[i] = true;
            dfs(ans, permutation, used, nums);
            used[i] = false;
            permutation.remove(permutation.size() - 1);
            while( i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            } 
        }
    }
}

/*
Time Complexity : O(n * n!)
Space Complexity : O(n * n!)
*/
