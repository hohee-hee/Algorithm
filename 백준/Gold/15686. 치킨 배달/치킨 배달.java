import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, minD;
	static int[][] map;
	static ArrayList<int[]> chicken, house;
	static boolean[] alive;
	
	public static void main(String[] args) throws IOException {
		
		//1. 입력 받기	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		chicken = new ArrayList<int[]>(); //치킨집 좌표 저장
		house = new ArrayList<int[]>();

		for(int r = 0 ; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < N ; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 2) chicken.add(new int[] {r,c});
				else if(map[r][c] == 1) house.add(new int[] {r,c});
			}
		}
		
		//2. 거리 찾기
		alive = new boolean[chicken.size()];
		minD = Integer.MAX_VALUE;
		powerSet(0, 0);
		
		//3. 출력
		System.out.println(minD);
		
	}

	private static void powerSet(int depth, int cnt) {
		if(cnt == M || depth == chicken.size()) {
			if(cnt == 0) return; //치킨집이 아예 없으면 안됨
			
			//거리계산
			int[][] DP = new int[N][N];
			
			for(int i = 0 ; i < chicken.size(); i++) {
				if(!alive[i]) continue;
				
				for(int j = 0 ; j < house.size(); j++) {
					int r1 = chicken.get(i)[0];
					int r2 = house.get(j)[0];
					int c1 = chicken.get(i)[1];
					int c2 = house.get(j)[1];
					
					int dist = Math.abs(r1-r2) + Math.abs(c1-c2);
					if(DP[r2][c2] == 0 || DP[r2][c2] > dist) {
						DP[r2][c2] = dist;
					}						
				}
			}
			
			int d = 0;
			for(int r = 0 ; r < N ; r++) {
				for(int c = 0 ; c < N ; c++) {
					if(DP[r][c] != Integer.MAX_VALUE) d += DP[r][c];
				}
			}
			
			if(minD > d) minD = d;
			return;
		}

		alive[depth] = true;
		powerSet(depth+1, cnt+1);

		alive[depth] = false;
		powerSet(depth+1, cnt);
	}
}
