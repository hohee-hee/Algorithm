import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int N = Integer.parseInt(br.readLine());	
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ;i++) { 
			String sc = br.readLine();
			sb.append(vps(sc)).append("\n");
		}
		System.out.println(sb);
	}
	
	/*
	 * 상태에 알맞은 출력값(String)을 반환해주는 함수
	 * 
	 * 기본 원리
	 * 1. 스택 생성
	 * 2. '(' -> push
	 * 3. ')' -> pop
	 * 
	 * 반환 조건
	 * 1. ')'를 입력 받았는데 pop할 원소가 없을 때 -> "NO"
	 * 2. 입력 값들을 모두 스택에 push&pop을 한 후
	 *  - 스택이 비어있으면 -> "YES"
	 *  - 스택이 비어있지 않으면 -> "NO"
	 *  : 스택이 비어있다는 말은 (와 )의 짝이 맞는 다는 의미이므로
	 */
	static String vps(String str) {
		Stack<Integer> stack = new Stack<>(); //새 스택 생성
		//괄호 문자열의 각 char들을 확인해야하므로 문자열의 length만큼 반복
		for(int i = 0 ; i < str.length() ; i++) { 
			char c = str.charAt(i); //문자열의 char을 한개씩 방문
			//만약 (라면 push
			if(c == '(') {
				stack.push(1);
			}
			//만약 (라면,
			else {
				//비어있지 않다면 pop
				if(!stack.isEmpty()) {
					stack.pop();
				}
				//pop을 해야하는데 pop할 함수가 없으므로 NO를 반환하며 이번 문자열에서의 vps 탐색을 종료
				else {
					return "NO";
				}
			}			
		}
		//반복문을 완료했을때 스택이 비어있다면 YES
		//비어있지 않고 엘리먼트가 남아있다면 NO
		if(stack.isEmpty())
			return "YES";
		else
			return "NO";
	}	
}