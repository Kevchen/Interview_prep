/*  0= dead to dead
    1= alive to alive
    2= dead to alive
    3= alive to dead
*/
class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length<1)
            return;
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0;i<rows;++i)
            for(int j=0;j<cols;++j)
                update(board,i,j);
        
        for(int i = 0;i<rows;++i)
            for(int j=0;j<cols;++j){
                if(board[i][j]==0 || board[i][j]==3)
                    board[i][j] = 0;
                else
                    board[i][j]=1;
            }
    }
    
    public void update(int[][] board, int i, int j){
        int count = 0;
        for(int row=Math.max(i-1,0);row<=Math.min(i+1,board.length-1);++row){
            for(int col = Math.max(j-1,0);col<=Math.min(j+1,board[0].length-1);++col){
                if(board[row][col]==1 || board[row][col]==3){
                    ++count;
                }
            }
        }
        if(board[i][j]==1){
            if(count<3 || count>4)
                board[i][j] = 3;
        }else{
            if(count==3)
                board[i][j] = 2;
        }
    }
}