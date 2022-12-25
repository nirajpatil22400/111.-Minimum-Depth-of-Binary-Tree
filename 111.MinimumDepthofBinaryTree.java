/*
Method 1: 
The idea is to traverse the given Binary Tree.
For every node,
check if it is a leaf node. If yes, then return 1. 
If not leaf node then
if the left subtree is NULL, then recur for the right subtree.
And if the right subtree is NULL, then recur for the left subtree. 
If both left and right subtrees are not NULL, then take the minimum of two heights.

Below is implementation of the above idea.  
 */
class Solution {
    public int minDepth(TreeNode root) {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;
 
        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;
 
        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minDepth(root.right) + 1;
 
        // If right subtree is NULL, recur for left subtree
        if (root.right == null)
            return minDepth(root.left) + 1;
 
        return Math.min(minDepth(root.left),
                        minDepth(root.right)) + 1;
    }
}
/*
Time Complexity: O(n), as it traverses the tree only once. 
Auxiliary Space: O(h), where h is the height of the tree, this space is due to the recursive call stack.
*/