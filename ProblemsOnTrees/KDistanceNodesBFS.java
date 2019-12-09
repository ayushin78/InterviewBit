/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
 


public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B, int C) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
         traverse(A, parent);
          parent.put(A, null);
        A = findNode(A, B);
        
        HashMap<TreeNode, Boolean> seen = new HashMap<TreeNode, Boolean>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(A);
        int currentSize = q.size();
        int level = 0;
       
         if(level == C){
                    while(!q.isEmpty()){
                        arr.add(q.remove().val);
                    }
                    return arr;
                }
        while(!q.isEmpty()){
            if(currentSize == 0){
                level++;
                if(level == C){
                    while(!q.isEmpty()){
                        arr.add(q.remove().val);
                    }
                    return arr;
                }
                currentSize = q.size();
            }
            
            TreeNode current = q.remove();
            
            if(current.left != null && !seen.containsKey(current.left)){
                parent.put(current.left, current);
                q.add(current.left);
            }
            
            if(current.right != null && !seen.containsKey(current.right)){
                parent.put(current.right, current);
                q.add(current.right);
            }
            
            if(parent.get(current) != null && !seen.containsKey(parent.get(current))){
                q.add(parent.get(current));
            }
            
            seen.put(current, true);
            currentSize--;
            
        }
        return arr;
    }
    
    
    public void traverse(TreeNode A, HashMap<TreeNode, TreeNode>hm){
        if(A == null){
            return;
        }
        
        if(A.left != null){
            hm.put(A.left, A);
        }
        
        if(A.right != null){
            hm.put(A.right, A);
        }
        
        traverse(A.left, hm);
        traverse(A.right, hm);
        
    }
     
     
    public TreeNode findNode(TreeNode A, int num){
        if(A == null){
            return A;
        }
        
        if(A.val == num){
            return A;
        }
        
        TreeNode left = findNode(A.left, num);
        TreeNode right = findNode(A.right, num);
        
        if(left != null){
            return left;
        }
        
        return right;
    }
  
}

