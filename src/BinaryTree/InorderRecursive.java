class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }
    
    public List<Integer> dfs(TreeNode root, List<Integer> ans){
        if(root == null)
            return ans;
        
        ans = dfs(root.left, ans);
        ans.add(root.val);
        ans = dfs(root.right, ans);

        return ans;
    }
}
