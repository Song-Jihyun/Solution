//! DP로도 풀어보기 !

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = Integer.parseInt(sc.nextLine());
		for(int c=0; c<C; c++) {
			String wild = sc.nextLine();
			int N = Integer.parseInt(sc.nextLine());
			
			ArrayList<String> ret = new ArrayList<>();
			for(int i=0; i<N; i++) {
				String file = sc.nextLine();
				
				if(search(file, wild)) {
					ret.add(file);
				}
			}
			
			Collections.sort(ret);
			
			for(String s : ret) {
				System.out.println(s);
			}
		}
	}
	static boolean search(String file, String wild) {
		if(file.length() == 0 && wild.length() == 0) return true;
		if(wild.equals("*")) return true;
		if((file.length() == 0 || wild.length() == 0)) return false;
		
		if(wild.charAt(0) == file.charAt(0) || wild.charAt(0) == '?')
			return search(file.substring(1), wild.substring(1));
		else if(wild.charAt(0) == '*') {
			for(int i=0; i<=file.length(); i++) {
				if(search(file.substring(i), wild.substring(1)))
					return true;
			}
		}
		return false;
	}
}
