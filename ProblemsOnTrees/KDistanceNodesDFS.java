/*
Given a binary tree of integers. All nodes in the binary tree have distinct values. You are given an integer B. You have to find all the nodes that are at a distance of exactly C from the node containing value B. Return an array of integers consisting all the nodes that are C distance from node containing value B. Note:
You may return the nodes in any order.
Your solution will run on multiple test cases, if you are using global variables make sure to clear every time .
Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= Node values <= 10^9 
0 <= B <= 10^9
0 <= C <= 100
For Example
Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 

     B = 3
     C = 3
Output 1:
    [4, 5]

Input 2:
            1
           /  \
          2    3
           \
            4
             \
              5
        B = 4
        C = 1
Output 2:
    [2, 5]
    
*/


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
        isPresent(A, B, C, arr);
        return arr;
    }
    
      public static int isPresent(TreeNode A, int B, int C, ArrayList<Integer> arr){
        if(A == null){
            return -2;
        }
        
        
        int left = isPresent(A.left, B, C, arr);
        int right = isPresent(A.right, B, C, arr);
        
        
        // If current node is at c dist from given node
        if(left == C - 1 || right == C  - 1){
            arr.add(A.val);
            return -2;
        }
        
        // If found in left, call for right subtree
        if(left != -2){
          
            KdistanceChildNodes(A.right, C -2 -left,arr);
            return left + 1;
        }
        
        //If found in right, call in left subtree
        if(right != -2){
          
            KdistanceChildNodes(A.left, C -2 - right,arr);
            return right + 1;
        }
        
        
        if(A.val == B){
            KdistanceChildNodes(A, C, arr);
            return 0;
        }
        
        return -2;
    }
    
    public static void KdistanceChildNodes(TreeNode A, int K, ArrayList<Integer> arr){
       
    	if(A == null){
        	
            return;
        }
        if(K < 0){
            return;
        }
        
        if(K == 0){
        
            arr.add(A.val);
        }
        KdistanceChildNodes(A.left, K - 1, arr);
        KdistanceChildNodes(A.right, K - 1, arr);
        
    }
}


    
