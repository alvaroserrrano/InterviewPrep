/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Recursion
/**
O(n). each node is visited only once. n is number of Nodes. 
*/
class Solution () {
    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
    }
}

/**
we need to swap left and right child of all nodes
we create a queue to store nodes whose left and right children have not been swapped yet
iniitally only the roo is in the queue
*/
class Solution () {
    public TreeNode invertTree (TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if(current.left != null) 
                queue.add(current.left);
            if(current.right != null)
                queue.add(current.right);
        }
        return root;
    }
}
