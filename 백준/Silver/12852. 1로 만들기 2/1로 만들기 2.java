import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;
	
	public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        //입력값이 1일 경우, 출력하고 메인메소드 바로 종료
		if(N == 1) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		
		//그 외의 경우
        dp = new int[N][2]; //회차와 이전 수를 저장할 dp 배열
        int turn = 1; //회차
        //1이 되면 종료 = dp[1]이 초기값이었던 0이 아닐때 종료
        while(dp[1][0] == 0) {
        	//첫 회차에서는 이전 수를 확인할 필요가 없다
        	if(turn == 1) {
        		cal(turn, N);
        		turn++;
        		continue;
        	}
        	
        	//그 이후 회차에서는 해당  회차였던 정수 N을 찾아서 연산 진행
        	for(int i = 1; i < N ; i++) {
        		if(dp[i][0] != turn - 1) continue;
        		cal(turn, i);
        	}
        	
        	//회차 더하기
        	turn++;
        }
        
        //해당 수하는 수를 스택에 넣기
        Deque<Integer> s = new ArrayDeque<>();
        s.offerFirst(1);
        for(int i = 1; i < turn ; i++) {
        	s.offerFirst(dp[s.peekFirst()][1]);
        }
        
        //출력
        StringBuilder sb = new StringBuilder();
        sb.append(turn -1 + "\n");
        for(int i = 0 ; i < turn ; i++) {
        	sb.append(s.pollFirst() + " ");
        }
        System.out.println(sb);
	}

	//연산 메소드
	private static void cal(int turn, int n) {
		if(n%3 == 0 && dp[n/3][0] == 0) {
			dp[n/3][0] = turn;
			dp[n/3][1] = n;
		}
		if(n%2 == 0 && dp[n/2][0] == 0) {
			dp[n/2][0] = turn;
			dp[n/2][1] = n;
		}
		if(dp[n-1][0] == 0) {
			dp[n-1][0] = turn;
			dp[n-1][1] = n;
		}
	}
}
