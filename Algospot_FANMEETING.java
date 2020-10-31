//Sulution 1
//시간초과
//Time Complexity: log(fan.len) * (mem.len)^2

import java.util.Scanner;

public class Main {
	static char[] member;
	static char[] fan;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		
		for(int c=0; c<C; c++) {
			member = sc.next().toCharArray();
			fan = sc.next().toCharArray();
			
			System.out.println(recursive(0, fan.length));
		}
	}
	
	static int recursive(int start, int end) {
		if(end - start < member.length) return 0;
		
		int ret = 0;
		int mid = (start+end)/2;
		ret += recursive(start, mid);
		ret += recursive(mid, end);
		
		boolean count = true;
		for(int i=mid-1; i>mid-member.length ; i--) {
			count = true;
			for(int j=0; j<member.length; j++) {
				if(i+j >= end || i+j < start) {
					count = false;
					break;
				}
				else if(member[j] == 'M' && fan[i+j] == 'M') {
					count = false;
					break;
				}
			}
			if(count) {
				ret++;
			}
		}
		
		return ret;
	}
}
