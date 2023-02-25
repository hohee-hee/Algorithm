import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 1;
		
		//N=1이면 계산할 필요 없이 출력 후 반환
		if(N == 1) {
			System.out.println(answer);
			return;
		}
		
		//그렇지 않은 경우
		//6*(1+2+3+...+answer) + 1 < N을 만족하는 최솟값 answer 찾기
		while(true) {
			int num = 0; //num = 1+2+3+...+answer
			for(int i = 1 ; i <= answer ; i++) { num += i; }
			if(6*num+1 >= N) break;
			answer++;
		}
		
		System.out.println(answer+1);
	}
}
