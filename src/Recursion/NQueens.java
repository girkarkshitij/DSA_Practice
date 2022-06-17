// Brute force -> In validate function extra O(n) for checking row, O(n) for upper diagonal and O(n) for lower diagonal
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(0, board, res);
        return res;
    }
    
    private boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col; 
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') return false; 
            row--;
            col--; 
        }
        
        row = duprow; 
        col = dupcol; 
        while(col >= 0) {
            if(board[row][col] == 'Q') return false; 
            col--; 
        }
        
        row = duprow; 
        col = dupcol; 
        while(col >= 0 && row < board.length) {
            if(board[row][col] == 'Q') return false; 
            col--;
            row++; 
        }
        return true; 
    }
    
    private void dfs(int col, char[][] board, List<List<String>> res) {
        if(col == board.length) {
            res.add(construct(board));
            return;
        }
        
        for(int row = 0; row < board.length; row++) {
            if(validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col+1, board, res);
                board[row][col] = '.';
            }
        }
    }
      
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}

// Optimized
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        solve(n, ans);
        return ans;
    }
    
    public void solve(int n, List<List<String>> ans){
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        int[] leftRow = new int[n];
        int[] upDiagonal = new int[2*n-1];
        int[] lowDiagonal = new int[2*n-1];
        
        fun(0, board, ans, leftRow, lowDiagonal, upDiagonal);
    }
    
    public void fun(int col, char[][] board, List<List<String>> ans, int[] leftRow, int[] lowDiagonal, int[] upDiagonal){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }
        
        for(int row = 0; row<board.length; row++){
            if(leftRow[row] == 0 && lowDiagonal[row+col] == 0 && upDiagonal[board.length-1+col-row] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowDiagonal[row+col] = 1;
                upDiagonal[board.length-1+col-row] = 1;
                fun(col+1, board, ans, leftRow, lowDiagonal, upDiagonal);
                
                board[row][col] = '.';
                leftRow[row] = 0;
                lowDiagonal[row+col] = 0;
                upDiagonal[board.length-1+col-row] = 0;
            }
        }
    }
    
    public List<String> construct(char[][] board){
        List<String> temp = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            String s = new String(board[i]);
            temp.add(s);
        }
        return temp;
    }
}
