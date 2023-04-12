import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		//1. 입력 받기	
		int max = Integer.MIN_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meeting = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//2.정렬하기
		Arrays.sort(meeting, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		//3. 회의 개수 구하기
		
		//0번 인덱스에 들어간 값은 무조건 회의 할 수 있다!
		int time = meeting[0][1];
		int cnt = 1;
		
		for(int i = 1 ; i < N ; i++) {
			if(meeting[i][0] < time) continue;

			time = meeting[i][1];
			cnt++;			
		}
		
		System.out.println(cnt);
	}
}
