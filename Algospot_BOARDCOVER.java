import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			boolean board[][] = new boolean[H][W];
			int empty = 0;
			for(int i=0; i<H; i++) {
				String row = sc.next();
				for(int j=0; j<W; j++) {
					if(row.charAt(j) == '#') board[i][j] = true;
					else empty++;
				}
			}
			
			if(empty % 3 != 0) System.out.println(0);
			else System.out.println(countBlockArrange(board, 0));
		}
	}
	
	static int countBlockArrange(boolean[][] board, int start_x) {
		int x = -1, y = -1;
		for(int i=start_x; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(!board[i][j]) {
					x = i;
					y = j;
					break;
				}
			}
			if(x != -1) break;
		}
		
		if(x == -1) return 1;
		
		int block_x[][] = {{0, 1}, {0, 1}, {1, 1}, {1, 1}};
		int block_y[][] = {{1, 0}, {1, 1}, {0, 1}, {-1, 0}};
		
		int ret = 0;
		
		for(int i=0; i<4; i++) {
			int ax = x+block_x[i][0];
			int ay = y+block_y[i][0];
			int bx = x+block_x[i][1];
			int by = y+block_y[i][1];
			if(ax < 0 || ax >= board.length || ay < 0 || ay >= board[0].length || 
			   bx < 0 || bx >= board.length || by < 0 || by >= board[0].length) continue;
			if(board[ax][ay] || board[bx][by]) continue;
			
			board[x][y] = true;
			board[ax][ay] = true;
			board[bx][by] = true;
			
			ret += countBlockArrange(board, x);
			
			board[x][y] = false;
			board[ax][ay] = false;
			board[bx][by] = false;
		}
		
		return ret;
	}
}
