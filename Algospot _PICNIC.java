import java.util.Scanner;

public class Main {
	static boolean friend[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			friend = new boolean[n][n];
			for(int i=0; i<m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				friend[a][b] = friend[b][a] = true;
			}
			
			boolean selected[] = new boolean[n];
			System.out.println(friendCaseNum(selected, 0));
		}
	}
	
	static int friendCaseNum(boolean[] selected, int count) {
		if(count == selected.length) return 1;
		
		int ret = 0;
		int child = -1;
		
		for(int i=0; i<selected.length; i++) {
			if(selected[i] == false) {
				if(child != -1) {
					if(friend[child][i]) {
						selected[i] = true;
						ret += friendCaseNum(selected, count+2);
						selected[i] = false;
					}
				}
				else {
					child = i;
					selected[child] = true;
				}
			}
		}
		selected[child] = false;
		return ret;
	}
}
