//Time Complexity: O(n^2)

import java.util.Scanner;

public class Main {
	static int[][] cache;
	static int[][] triangle;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		
		for(int c=0; c<C; c++) {
			int n = sc.nextInt();
			
			cache = new int[n][n];
			triangle = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<=i; j++) {
					triangle[i][j] = sc.nextInt();
				}
			}
			
			System.out.println(maxPath(0, 0));
		}
	}
	
	static int maxPath(int x, int y) {
		if(x == triangle.length-1) return triangle[x][y];
		if(cache[x][y] != 0) return cache[x][y];
		
		int max = Integer.MIN_VALUE;
		
		max = Math.max(max, maxPath(x+1, y));
		max = Math.max(max, maxPath(x+1, y+1));
		
		return cache[x][y] = max + triangle[x][y];
	}
}
