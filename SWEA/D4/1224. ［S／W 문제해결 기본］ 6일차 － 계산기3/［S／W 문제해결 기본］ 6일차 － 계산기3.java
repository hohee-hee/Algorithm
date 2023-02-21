import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> s1 = new Stack<>(); //후위 표기식 전환을 위한 스택
		Stack<Integer> s2 = new Stack<>(); //계산용 스택
		
		for(int test_case = 1 ; test_case <= 10 ; test_case++) {
			int len = sc.nextInt(); //길이 입력받기
			char[] cal = sc.next().toCharArray(); //입력받은 문자열을 char 배열로
			ArrayList<Character> suf = new ArrayList<>();
			
			//1. 후위 표기식으로 전환하기
			for(int i = 0 ; i < len ; i++) {
				//1. 숫자일 때 : 바로 suf로 넣어준다
				if(cal[i] - '0' >= 0) {
					suf.add(cal[i]);
				}
				//2. 여는 괄호일 때 : 스택에 넣기
				else if(cal[i] == '(') {
					s1.push(cal[i]);
				}
				//3. 닫는 괄호일 때 : 여는 괄호가 나올 때까지 pop해서 suf에 넣어주기
				else if(cal[i] == ')') {
					while(s1.peek() != '(') {
						suf.add(s1.pop());
					}
					//여는 괄호는 버려주기
					s1.pop();
				}
				//4. + 또는 *일 때 : 우선순위를 확인한 후 스택에 바로 넣거나 스택에서 빼오고 넣는다
				else {
					//pop을 위한 반복문
					while(!s1.isEmpty()) {
						// 만약 cal[i]의 우선순위가 top보다 높으면 반복문 중단
						if(priority(s1.peek()) > priority(cal[i])) { break; }
						suf.add(s1.pop());
					}
					//어떤 경우에서든 cal[i]는 push 되어야한다.
					s1.push(cal[i]);
				}
			}
			//남아있는 요소 모두 suf에 넣기
			while(!s1.isEmpty()) {
				suf.add(s1.pop());
			}
			
			//2. 계산하기
			for(int i = 0 ; i < suf.size() ; i++) {
				//1. 숫자일 때 : 스택으로 넣기
				if(suf.get(i) - '0' >= 0) {
					s2.push(suf.get(i) - '0');
				}
				//2. 연산자 일때 :
				//- 연산자를 확인한다
				//- 각 연산자에 맞게 pop해온 2개의 원소를 계산한후
				//- 그 값을 스택에 다시 넣는다
				else {
					if(suf.get(i) == '*') {
						s2.push(s2.pop() * s2.pop());
					}
					else{
						s2.push(s2.pop() + s2.pop());
					}
				}
			}
			
			//3. 출력하기
			System.out.printf("#%d %d\n", test_case, s2.pop());
		}
	}
	
	static int priority(char ch) {
		if(ch == '*') return 1;
		if(ch == '+') return 2;
		return 3;
	}
}
