import java.util.Scanner;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			char[] str_arr = sc.next().toCharArray();
			int answer = 1;
			int len = str_arr.length;
			for(int i = 0 ; i < len ; i++) {
				if(str_arr[i] != str_arr[len - 1 -i]) {
					answer = 0;
					break;
				}
			}
			System.out.printf("#%d %d\n",test_case,answer);
		}
	}
}