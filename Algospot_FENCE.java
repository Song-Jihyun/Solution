//Time Complexity: O(NlogN)

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		for(int c=0; c<C; c++) {
			int N = sc.nextInt();
			int[] board = new int[N];
			for(int i=0; i<N; i++) {
				board[i] = sc.nextInt();
			}
			
			System.out.println(maxArea(0, N, board));
		}
	}
	
	static int maxArea (int start, int end, int[] board) {
		if(end-start <= 1) {
			return board[start];
		}
		
		int mid = (start+end) / 2;
		int ret = Math.max(maxArea(start, mid, board), maxArea(mid, end, board));
		
		int lidx = mid-2;
		int ridx = mid+1;
		int minh = Math.min(board[mid-1], board[mid]);
		ret = Math.max(ret, minh * 2);
		while(lidx >= start || ridx < end) {
			if(ridx >= end || lidx >= start && board[lidx] >= board[ridx]) {
				minh = Math.min(minh, board[lidx]);
				ret = Math.max(ret, minh * (ridx-lidx));
				lidx--;
			}
			else {
				minh = Math.min(minh, board[ridx]);
				ret = Math.max(ret, minh * (ridx-lidx));
				ridx++;
			}
		}
		
		return ret;
	}
}
