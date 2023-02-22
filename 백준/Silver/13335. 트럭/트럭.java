import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //트럭 개수
		int w = Integer.parseInt(st.nextToken()); //단위길이
		int L = Integer.parseInt(st.nextToken()); //최대하중
		
		int[] truck = new int[n]; //트럭 배열
		int[] bridge = new int[w]; //다리 배열
		
		//트럭 배열에 트럭 넣기
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		
		int pt = 0; //현재 맨 앞에 있는 트럭 번호
		int tdx = 0; //다음에 다리를 건널 트럭의 번호
		int time = 0; //시간
		
		//다리 건너기
		//1. 먼저 다리의 맨 앞에 있는 트럭(다음 턴에 밖으로 나갈 트럭)의 무게를 뺀 다리위에 있는 나머지 트럭의 무게에 다음에 다리에 올라올 트럭의 무게를 더한다.
		//2. 트럭을 다 한 칸 앞으료 옮겨준다.
		//   이 때 맨 앞([0])에 트럭이 있었다면 truck[pt]를 0으로 만들고 포인터를 옮겨준다
		//3. 1번의 합이 최대하중보다 작거나 같다면 다리에 새로운 트럭을 올린다
		//4. 시간에 1을 추가한다
		while(truck[n-1] != 0) {
			int bridge_sum = 0; //다리 위에 올라간 맨 앞 트럭을 제외한 트럭의 무게 합

//			System.out.println(Arrays.toString(bridge));
			//1. 트럭 합 저장
			for(int i = 1 ; i < w ; i++) {
				bridge_sum += bridge[i];
			}
			
			//2. 트럭 옮기기
			if(bridge[0] != 0) {
				truck[pt++] = 0;
			}
			for(int i = 1 ; i < w ; i++) {
				bridge[i-1] = bridge[i];
			}
			
			//3.조건에 부합할 시 다리에 새로운 트럭 올리기
			if(tdx < n && bridge_sum + truck[tdx] <= L) {
				bridge[w-1] = truck[tdx++];
			}
			//아니라면 그냥 다리의 마지막을 0으로 초기화
			else {
				bridge[w-1] = 0;
			}
			
			//4. 시간 더해주기			
			time++;
		}
		
		System.out.println(time);
	}
}
