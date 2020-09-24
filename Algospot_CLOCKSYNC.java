// 각 버튼은 0~3번 눌릴 수 있음.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int button[][] = {{0,1,2},{3,7,9,11},{4,10,14,15},{0,4,5,6,7},{6,7,8,10,12},{0,2,14,15},{3,14,15},{4,5,7,14,15},{1,2,3,4,5},{3,4,5,9,13}};

		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int clock[] = new int[16];
			
			for(int i=0; i<16; i++) {
				clock[i] = sc.nextInt();
				if(clock[i] == 12) clock[i] = 0;
			}
			
			int press = pressButton(clock, button, 0);
			
			if(press == 100) System.out.println(-1);
			else System.out.println(press);
		}
	}
	
	static int pressButton(int[] clock, int[][] button, int idx) {
		boolean finish = true;
		for(int i=0; i<16; i++) {
			if(clock[i] != 0) finish = false;
		}
		
		if(finish) return 0;
		if(idx == 10) return 100;
		
		int ret=100;
		for(int p=1; p<=4; p++) {
			for(int i=0; i<button[idx].length; i++) {
				int curr = button[idx][i];
				clock[curr] += 3;
				clock[curr] %= 12;
			}
		
			ret = Math.min(ret, p%4 + pressButton(clock, button, idx+1));
		}

		return ret;
	}
}
