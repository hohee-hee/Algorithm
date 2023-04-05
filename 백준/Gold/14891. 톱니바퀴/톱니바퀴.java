import java.io.*;
import java.util.*;


public class Main {
	
	static ArrayList<Integer>[] wheels; //톱니바퀴 정보
	static ArrayList<int[]> toMove; //움직여야하는 톱니바퀴 정보
	
	public static void main(String[] args) throws IOException {
		//1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//- 톱니바퀴 정보 입력
		wheels = new ArrayList[4];
		for(int i = 0 ; i < 4 ; i++) wheels[i] = new ArrayList<>();		
		for(int i = 0 ; i < 4 ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < 8 ; j++) {
				wheels[i].add(str.charAt(j) - '0');
			}
		}
		
		//- K
		int K = Integer.parseInt(br.readLine());
		
		//- 회전 정보 저장
		int[][] turn = new int[K][2];
		for(int i = 0 ; i < K ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken());
			turn[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//2. 회전하기
		for(int i = 0 ; i < K ; i++) {
			int wnum = turn[i][0]-1; //톱니바퀴 번호
			int dir = turn[i][1]; //회전 방향
			
			//1. 회전하는 바퀴 찾기
			//회전하는 바퀴 정보를 저장할 배열 선언
			toMove = new ArrayList<>();
			//현재 바퀴 정보 저장
			toMove.add(new int[] {wnum, dir});
			//움직여야하는 바퀴 정보 저장하기
			find(wnum, dir);
			
			//2. 바퀴 움직이기
			for(int j = 0 ; j < toMove.size() ; j++) {
				int num = toMove.get(j)[0];
				int d = toMove.get(j)[1];
				
				//시계방향 회전
				if(d == 1) {
					//맨 뒤 애를 빼와서
					int remove = wheels[num].remove(7);
					//맨 앞에 추가
					wheels[num].add(0, remove);
				}
				
				//반시계 회전
				else {
					//맨 앞 애를 빼 와서
					int remove = wheels[num].remove(0);
					//맨 뒤에 추가
					wheels[num].add(remove);					
				}
			}
		}
		
		//3. 점수 계산하기
		int score = 0;
		for(int i = 0 ; i < 4; i++) {
			if(wheels[i].get(0) == 1) score += (int) Math.pow(2, i);
		}
		
		//4. 출력하기
		System.out.println(score);
	}

	private static void find(int wnum, int dir) {
		switch (wnum){
			case 0 :
				//우측에 있는 모든 바퀴 검색
				//현재 바퀴와 맞닿은 톱니의 극이 같다면 멈추기
				for(int i = wnum ; i < 3 ; i++) {
					//맞닿은 톱니의 극이 같음
					if(wheels[i].get(2) == wheels[i+1].get(6)) break;
					
					//같지 않음
					dir *= -1;
					toMove.add(new int[] {i+1,dir});					
				}
				
				break;
			case 1 :
				//왼쪽 바퀴(0번 바퀴)부터 검사
				if(wheels[wnum-1].get(2) != wheels[wnum].get(6)) {
					toMove.add(new int[] {wnum-1,dir*(-1)});
				}
				
				//오른쪽 바퀴들 검사
				for(int i = wnum ; i < 3 ; i++) {
					//맞닿은 톱니의 극이 같음
					if(wheels[i].get(2) == wheels[i+1].get(6)) break;
					
					//같지 않음
					dir *= -1;
					toMove.add(new int[] {i+1,dir});
				}
				
				break;
			case 2 :
				//오른쪽 바퀴(3번바퀴)부터 검사
				if(wheels[wnum].get(2) != wheels[wnum+1].get(6)) toMove.add(new int[] {wnum+1,dir*(-1)});
				//왼쪽 바퀴들 검사
				for(int i = wnum ; i > 0 ; i--) {
					//맞닿은 톱니의 극이 같음
					if(wheels[i-1].get(2) == wheels[i].get(6)) break;
					
					//같지 않음
					dir *= -1;
					toMove.add(new int[] {i-1,dir});					
				}
				
				break;
			case 3:
				//좌측에 있는 모든 바퀴 탐색
				for(int i = wnum; i > 0 ;i--) {
					//맞닿은 톱니의 극이 같음
					if(wheels[i-1].get(2) == wheels[i].get(6)) break;
					
					//같지 않음
					dir *= -1;
					toMove.add(new int[] {i-1,dir});
				}
				
				break;
		}
	}
}
