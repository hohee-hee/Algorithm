import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static int[] p, combi; //대표값을 저장할 배열, 조합을 저장할 배열
	static int[][] loc; //섬의 위치를 저장할 배열
	static ArrayList<long[]> edge;
	static int eidx; //edge idx
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1 ; tc <= T ; tc++) {
			//1. 입력 받기
			int N = sc.nextInt();
			loc = new int[N][2];
			for(int i = 0 ; i < N ; i++) {
				loc[i][0] = sc.nextInt();				
			}
			for(int i = 0 ; i < N ; i++) {
				loc[i][1] = sc.nextInt();
			}
			double E = sc.nextDouble();
			
			//makeset
			p = new int[N];
			for(int i = 0 ; i < N ; i++) p[i] = i;
			
			
			//3. 간선정보 입력
			edge = new ArrayList<>();
			combi = new int[2];
			eidx = 0;
			BackTracking(N, E, 0, 0);
			//정렬
			Collections.sort(edge, new Comparator<long[]>() {

				@Override
				public int compare(long[] o1, long[] o2) {
					if (o1[2] < o2[2]) return -1;
					if (o1[2] > o2[2]) return 1;
					return (int)(o1[0] - o2[0]);
				}
			});
			
			//4. MST
			int pick = 0;
			double ans = 0;
			
			for(long[] e : edge) {
				int px = findset((int)e[0]);
				int py = findset((int)e[1]);
				
				//같으면 pass
				if(px == py) continue;
				
				union(px, py);
				pick++;
				ans += e[2];
				if(pick == N-1) break;
			}
			//5. 출력
			
			System.out.println("#" + tc + " " + Math.round(ans*E));
		}
	}

	private static void union(int px, int py) {
		p[px] = py;
	}

	private static int findset(int x) {
		if(x != p[x]) p[x] = findset(p[x]);
		return p[x];
	}

	private static void BackTracking(int N, double E, int depth, int pre) {
		//기저조건
		if(depth == 2) {
			//거리 구하기
			long x = loc[combi[0]][1] - loc[combi[1]][1];
			long y = loc[combi[0]][0] - loc[combi[1]][0];
			long d = x * x + y * y;
			//가중치 넣기
			long[] input = new long[] {combi[0], combi[1], d};
			edge.add(input);
			return;
		}
		
		//재귀 조건
		for(int i = pre ; i < N ; i++) {
			combi[depth] = i;
			BackTracking(N, E, depth+1, i+1);
		}
	}
	
	
	
}
