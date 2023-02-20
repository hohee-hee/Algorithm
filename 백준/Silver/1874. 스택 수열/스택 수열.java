import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<Integer> stack = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());
		int x = 1; //스택에 오름차순으로 넣어줄 수
		
		//입력값을 받아오면서
		//만약 top보다 num이 작다면 꺼낼 수 없으므로 NO 출력 후 main 메소드 종료
		//만약 top보다 num이 크다면 num까지 stack에 push해주기
		//만약 top과 num이 같다면 pop해주기

		for(int i = 0 ; i < n ; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(peek() > num) {
				System.out.println("NO");
				return;
			}
			
			else if(peek() < num) {
				while(x <= num) {
					push(x);
					x++;
				}
			}
			
			pop();			
		}
		
		System.out.println(sb);
	}
	
	//push
	//push을 수행한 후 StringBuilder에 '+' 추가
	static void push(int x) {
		stack.add(x);
		sb.append("+").append("\n");
	}
	
	//pop
	//pop을 수행한 후 StringBuilder에 '-' 추가
	static void pop() {
		stack.remove(stack.size() - 1);
		sb.append("-").append("\n");
	}
	
	//stack이 비어있지 않으면 top값 반환
	//비어있다면 -1 반환
	static int peek() {
		if(stack.size() != 0) {
			return stack.get(stack.size() - 1);
		}
		
		return -1;
	}
}
