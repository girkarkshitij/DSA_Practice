class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if(root == null)
            return ans;

        Deque<TreeNode> stack = new ArrayDeque<>();

        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.isEmpty())
                    break;
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        
        return ans;
    }
}
