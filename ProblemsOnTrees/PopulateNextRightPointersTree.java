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
        
        TreeLinkNode vert = root;
        
        while(vert != null){
            TreeLinkNode horiz = vert;
            
            while(horiz != null){
                if(horiz.left != null && horiz.right != null){
                    horiz.left.next = horiz.right;
                    horiz.right.next = getRight(horiz.next);
                }else if(horiz.left != null){
                    horiz.left.next = getRight(horiz.next);
                }else if(horiz.right != null){
                    horiz.right.next = getRight(horiz.next);
                }
                
                horiz = horiz.next;
            }
            
            if(vert.left != null){
                vert = vert.left;
            }else if(vert.right != null){
                vert = vert.right;
            }else{
                vert = getRight(vert.next);
            }   
        }
    }
    
    public TreeLinkNode getRight(TreeLinkNode root){
        while(root != null){
            if(root.left != null){
                return root.left;    
            }
            
            if(root.right != null){
                return root.right;
            }
            
            root = root.next;
        }
        
        return root;
    }
}


/*
 
    Time Complexity : O(n)
    Space Complexity : O(n)

*/
