class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }
    
    public List<Integer> dfs(TreeNode root, List<Integer> list){
        if(root == null)
            return list;
        
        list.add(root.val);
        list = dfs(root.left, list);
        list = dfs(root.right, list);
        
        return list;
    }
}
