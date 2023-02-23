import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			boolean check = false; //기본값 false : 다 0이니까
			int cnt  = 0;
			String str = sc.next();
			
			for(int i = 0 ; i < str.length() ; i++)  {
				if((str.charAt(i) == '0' && check) || (str.charAt(i) == '1' && !check) ) { 
					cnt++;
					check = !check;
				}
			}
			
			System.out.printf("#%d %d\n", test_case, cnt);
		}
			
	}
}
