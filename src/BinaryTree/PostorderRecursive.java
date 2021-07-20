class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }
    
    public List<Integer> dfs(TreeNode root, List<Integer> ans){
        if(root == null)
            return ans;
        
        ans = dfs(root.left, ans);
        ans = dfs(root.right, ans);
        ans.add(root.val);
        
        return ans;
    }
}
