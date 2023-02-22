import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1 ; test_case <= 10 ; test_case++) {
			//유효성 변수를 1로 초기화
			int valid =1;
			
			//스택 선언
			Stack<Character> s = new Stack<>();
			
			//길이 입력받기
			int len = Integer.parseInt(sc.next());
			//문자열 입력받기
			char[] str = sc.next().toCharArray();
			
			for(int i = 0 ; i < len ; i++) {
				
				//여는괄호라면 push하기
				if(str[i] == '(' || str[i] == '[' ||str[i] == '<' ||str[i] == '{') {
					s.push(str[i]);
				}
				//닫는 괄호라면 스택이 비어있는지 확인
				// - 비어있다면 유효성에 0을 넣고 break
				// - 여는 괄호라면 pair 확인 후 유효성 체크				
				else {
					//stack is empty
					if(s.isEmpty()) {
						valid = 0;
						break;
					}
					else {
						if(pair(str[i]) != s.peek()) {
							valid = 0;
							break;
						}
						else {
							s.pop();
						}
					}
				}
			}
			if(!s.isEmpty()) { valid = 0; }
			System.out.printf("#%d %d\n", test_case, valid);
		}
	}
	
	public static char pair(char ch) {
		switch(ch) {
		case ')':
			return '(';
			
		case ']':
			return '[';
			
		case '}':
			return '{';
			
		case '>':
			return '<';
		}
		return '\u0000';
	}
}
