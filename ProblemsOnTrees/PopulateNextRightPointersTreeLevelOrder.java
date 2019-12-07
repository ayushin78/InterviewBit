/*
Given a binary tree
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.
 Note:
You may only use constant extra space.
Example : Given the following binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {  
        if(root == null){
            return;
        }
        
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        TreeLinkNode prev = null;
        int currentSize = q.size();
        
        while(!q.isEmpty()){
            if(currentSize == 0){
                currentSize = q.size();
                prev.next = null;
                prev = null;
            }
            
            TreeLinkNode current = q.remove();
            if(prev != null){
                prev.next = current;
            }
            prev = current;
            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null){
                q.add(current.right);
            }
            
            currentSize--;
        }
        
        
    }
}


/*
    Time Complexity : O(n)
    Space Complexity : O(n)

*/
