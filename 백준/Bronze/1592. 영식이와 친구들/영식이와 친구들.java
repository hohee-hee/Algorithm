import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int ball = 0; //현재 공의 위치
		int cnt = 0; //공을 던진 횟수
		int[] arr = new int[N]; //각자 공을 몇 번이나 받았을지를 저장할 배열
		
		while(true) {
			arr[ball]++;
			//종료조건 : 공을 M번이상 받은 사람이 생겼을 때
			if(arr[ball] >= M) break;
			
			//공 던지기
			//- 짝수면 반시계, 홀수면 시계방향으로 던지기
			if(arr[ball]%2 == 0) ball = ball-L;
			else ball = ball+L;
			//ball이 index의 범위를 벗어났을 떄 조정해주기
			if(ball < 0) ball += N;
			else ball %= N;
			
			cnt++;			
		}
		System.out.println(cnt);
	}
}
