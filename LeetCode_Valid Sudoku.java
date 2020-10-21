//Sulution 1. faster than 100% / memory less than 10.50&

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //row check
        for(int i=0; i<9; i++){
            boolean set[] = new boolean[9];
            for(int j=0; j<9; j++){
                char c = board[i][j];
                if (c == '.') continue;
                if (set[c - '1']) return false;
                set[c - '1'] = true;
            }
        }
        
        //column check
        for(int i=0; i<9; i++){
            boolean set[] = new boolean[9];
            for(int j=0; j<9; j++){
                char c = board[j][i];
                if (c == '.') continue;
                if (set[c - '1']) return false;
                set[c - '1'] = true;
            }
        }
        
        // box check
        int sp[] = {0, 3, 6};
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                boolean set[] = new boolean[9];
                for(int k=0; k<9; k++){
                    char c = board[sp[i] + k/3][sp[j] + k%3];
                    if (c == '.') continue;
                    if (set[c - '1']) return false;
                    set[c - '1'] = true;
                }
            }
        }
        
        return true;
    }
}
