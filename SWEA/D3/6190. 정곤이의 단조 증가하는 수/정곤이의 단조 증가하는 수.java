import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1 ; test_case <= T ; test_case++) {
			int N = sc.nextInt();
			int[] A = new int[N];
			for(int i = 0 ; i < N ; i++) {
				A[i] = sc.nextInt();
			}
			
			int max = 0;
			for(int i = 0 ; i < N-1 ; i++) {
				for(int j = i+1 ; j < N ; j++) {
					int num = check(A[i] * A[j]);
					if(max < num) { max = num; }
				}
			}
			
			if(max == 0) System.out.printf("#%d %d\n",test_case,-1);
			else System.out.printf("#%d %d\n",test_case,max);
		}
		
	}
	
	public static int check(int num) {
		boolean flag = true;
		boolean go = true;
		int prenum = 10;
		int div = 10;	
		int re_num = num;
		while(go) {
			if(num/div == 0) { go = false;}
			
			int tmp = num%div;
			if(tmp > prenum) {
				flag = false;
				break;
			}
			
			num /= div;
			prenum = tmp;
		}
		
		if(!flag) return -1;
		else return re_num;
	}
}
