//Time Complexity: O(N^2)

import java.util.Scanner;
import java.util.HashMap;

public class Main {
	static int[][] board;
	static boolean[][] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		
		for(int c=0; c<C; c++) {
			int n = sc.nextInt();
			board = new int[n][n];
			cache = new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			System.out.println(jumpgame(0, 0, n) ? "YES" : "NO");
		}
	}
	
	static boolean jumpgame(int x, int y, int n) {
		if(x==n-1 && y==n-1) return true;
		if(x >= n || y >= n) return false;
		if(cache[x][y]) return false;
		
		if(jumpgame(x+board[x][y], y, n)) return true;
		if(jumpgame(x, y+board[x][y], n)) return true;
		
		cache[x][y] = true;
		return false;
	}
}
