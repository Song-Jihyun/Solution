//Time Complexity: O(N^2)

import java.util.Scanner;

public class Main {
	static int arr[];
	static int cache[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		
		for(int c=0; c<C; c++) {
			int N = sc.nextInt();
			
			arr = new int[N];
			cache = new int[N][N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.println(lis(0, -1));
		}
	}
	
	static int lis(int idx, int before_idx) {
		if(idx == arr.length) return 0;
		if(before_idx > -1 && cache[idx][before_idx] != 0) return cache[idx][before_idx];
		
		int before = 0;
		if(before_idx > -1) before = arr[before_idx];
		
		int ret = 0;
		if(before < arr[idx]) ret = Math.max(ret, 1+lis(idx+1, idx));
		ret = Math.max(ret, lis(idx+1, before_idx));
		
		if(before_idx > -1) return cache[idx][before_idx] = ret;
		else return ret;
	}
}
