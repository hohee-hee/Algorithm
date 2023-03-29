import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			//1. input
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			//2. initialize
			p = new int[N+1];

			//3. makeSet
			for(int i = 1 ; i <= N ; i++) {
				p[i] = i;
			}
			
			//4. union
			for(int i = 0 ; i < M ; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				union(findset(x), findset(y));
			}
			
			//5. counting
			HashSet<Integer> hs = new HashSet<>();			
			for(int i = 1 ; i <= N ; i++) {
				hs.add(findset(p[i]));
			}
			System.out.println("#" + tc + " " + hs.size());
		}
	}

	private static void union(int px, int py) {
		p[py] = px;
	}

	private static int findset(int x) {
		if(x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}
}
