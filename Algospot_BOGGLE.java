import java.util.Scanner;

public class Main {
	static String word;
	static char[][] board;
	static boolean[][][] cache;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			board = new char[5][5];
			for(int i=0; i<5; i++) {
				String str = sc.next();
				for(int j=0; j<5; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			
			int wordNum = sc.nextInt();
			for(int w=0; w<wordNum; w++) {
				word = sc.next();
				boolean res = false;
				cache = new boolean[word.length()][5][5];
				
				for(int x=0; x<5; x++){
					for(int y=0; y<5; y++) {
						res = findWord(0, x, y);
						if(res) break;
					}
					if(res) break;
				}
				System.out.println(word + (res ? " YES" : " NO"));
			}
		}
	}
	
	static boolean findWord(int idx, int x, int y) {
		if(x<0 || x>=5 || y<0 ||y>=5) return false;
		if(cache[idx][x][y]) return false;
		if(board[x][y] != word.charAt(idx)) return false;
		if(idx == word.length()-1) return true;
		
		int xdir[] = {-1, -1, -1, 0, 0, 1, 1, 1};
		int ydir[] = {-1, 0, 1, -1, 1, -1, 0, 1};
		boolean ret = false;
		
		for(int i=0; i<8; i++) {
			ret = findWord(idx+1, x+xdir[i], y+ydir[i]);
			if(ret) break;
		}
		
		if(!ret) cache[idx][x][y] = true;
		return ret;
	}
	
}
