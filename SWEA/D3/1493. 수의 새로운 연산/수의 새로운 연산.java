
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T ; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			//1. 좌표구하기
			int[] pco = coordinate(p);
			int px = pco[0], py = pco[1];
			int[] qco = coordinate(q);
			int qx = qco[0], qy = qco[1];
			
			//2. 더하기
			int nx = px + qx;
			int ny = py + qy;
			
			//3. 수찾기
			//-1. #(nx,1)찾기
			int m = 0;
			for(int i = 1 ; i <= nx ; i++) {
				m += i;
			}
			//-2. nx, ny 찾기
			for(int j = 1 ; j <= ny - 1 ; j++) {
				m+= nx;
				nx++;
			}
			
			System.out.printf("#%d %d\n", tc, m);
		}
	}
	
	private static int[] coordinate(int p) {
		int co[] = new int[2];
		int st = 1;
		int k = 1;
		while(st <= p) {
			st += k;
			k++;
		}
		
		st -= k-1;
		if(st==p) {
			co[0] = 1;
			co[1] = k-1;
		}
		else {
			for(int i = 2 ; i < k ; i++) {
				st++;
				if(st == p) {
					co[0] = i;
					co[1] = k-i;
				}
			}
		}
		return co;
	}
}
