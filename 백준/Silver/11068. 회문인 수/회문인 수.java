
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			boolean flag = true;
			int num = Integer.parseInt(br.readLine());
			
			//2진법부터 64진법까지 확인할 반복문
			for(int j = 2 ; j <=64 ; j++) {
				//회문 가능 여부를 확인할 불리안타입 변수
				flag = true;
				//j진법으로 바꾸기
				int n = num;
				Deque<Integer> dq = new ArrayDeque<>();
				while(n >= j) {
					dq.offer(n%j);
					n/= j;
				}
				dq.offer(n);
				
				int len = dq.size();
				//앞과 뒤를 확인할 반복문
				for(int k = 0 ; k < (len+1) / 2 ; k++) {
					//만약 앞과 뒤가 같으면 poll하기
					if(dq.peekFirst() == dq.peekLast()) {
						dq.pollFirst();
						dq.pollLast();
					}
					//같지 않다면 j진법은 회문이 불가능하므로 flag를 false로 바꾸고 반복문 종료
					else  {
						flag = false;
						break;
					}					
				}
				//만약 flag가 참으로 유지되었다면 회문인 것이기 때문에 더 이상 j진법을 검사하지 않는다
				if(flag) {
					break;
				}
			}
			
			//종료 후 flag 가 참이면 1, false면 0 저장
			if(flag) {
				sb.append("1").append("\n");
			}
			else {
				sb.append("0").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}