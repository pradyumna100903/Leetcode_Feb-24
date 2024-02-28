/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int parent=-1;
    static int ans=0;
    public int findBottomLeftValue(TreeNode root) {
       help(root,0);
       int res=ans;ans=0;
       parent=-1;
       return res;
    }

    public static void help(TreeNode root,int level)
    {
        if(root==null)return ;
        if(level>parent){
            ans=root.val;
            parent=level;
        }
        help(root.left,level+1);
        help(root.right,level+1);
    }
}
