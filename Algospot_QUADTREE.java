//Solution 1
//RTE
//Time Complexity: O(NlogN)

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = Integer.parseInt(sc.nextLine()); // nextInt는 Enter를 처리할 수 없기 때문에 다음 tree변수에 공백 문자열이 들어가서 StackOverFlow 발생
		for(int c=0; c<C; c++) {
			String str = sc.nextLine();
			System.out.println(reverse(str));
		}
	}
	
	static String reverse(String str) {
		boolean x = false;
		int i = 0;
		
		if(str.length() <= 1) return str;
		if(str.charAt(0) == 'x') {
			x = true;
			i = 1;
		}
		
		Stack<Integer> st = new Stack<>();
		char ch[] = str.toCharArray();
		
		int mid[] = new int[4];
		int idx = 0;
		
		int count = 0;
		
		for(; i<str.length(); i++) {
			if(st.isEmpty()) {
				mid[idx] = i;
				idx++;
			}
			if(ch[i] == 'x') {
				st.add(count);
				count = 0;
				continue;
			}
			if(count == 3 && !st.isEmpty()) {
				count = st.pop();
			}
			count++;
		}
		
		String ret = x ? "x" : "";
		ret += reverse(str.substring(mid[2], mid[3]));
		ret += reverse(str.substring(mid[3], str.length()));
		ret += reverse(str.substring(mid[0], mid[1]));
		ret += reverse(str.substring(mid[1], mid[2]));
		
		return ret;
	}
}


//Solution 2
//Time Complexity: O(N);
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int pointer; // 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = Integer.parseInt(sc.nextLine()); // nextInt는 Enter를 처리할 수 없기 때문에 다음 tree변수에 공백 문자열이 들어가서 StackOverFlow 발생
		for(int c=0; c<C; c++) {
			String str = sc.nextLine();
			pointer = -1;
			System.out.println(reverse(str));
		}
	}
	
	static String reverse(String str) {
		pointer++;
		char c = str.charAt(pointer);
		if(c == 'w' || c == 'b') {
			return c + "";
		}
		
		String lt = reverse(str);
		String rt = reverse(str);
		String lb = reverse(str);
		String rb = reverse(str);
		
		return "x" + lb + rb + lt + rt;
	}
}
