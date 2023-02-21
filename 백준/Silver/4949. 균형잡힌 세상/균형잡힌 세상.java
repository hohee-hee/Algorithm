import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//스택선언
		Stack<Character> s = new Stack<>();
		
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		char[] str = br.readLine().toCharArray();
		
		//str의 첫번째 원소가 .가 아니면 while 반복 
		//첫 번째 원소가 .라면 종료조건이므로 while문 종료		
		while(str[0] != '.') {
			//str의 각 원소를 방문하면서
			//1. 왼쪽괄호면 무조건 push
			//2. 오른쪽 괄호면, 스택이 비어있지 않고 top의 값이 오른쪽 괄호에 상응하는 왼쪽괄호라면 pop
			//				아니라면 괄호를 push해주고 for문 종료

			//				상응하는 괄호가 없을때 바로 break하면 스택이 비어있는 채로 종료되는 경우가 있기 때문에 push 후 종료
			for(int i = 0 ; i < str.length ; i++) {
				if(str[i] == '[' || str[i] == '(') { s.push(str[i]); }
				else if(str[i] == ']') {
					if(!s.isEmpty() && s.peek() == '[') { s.pop(); }
					else { 
						s.push(str[i]);
						break; 
					}
				}
				else if(str[i] == ')') {
					if(!s.isEmpty() && s.peek() == '(') { s.pop(); }
					else { 
						s.push(str[i]);
						break; 
					}
				}
			}
			
			//스택이 비어있으면 yes
			//아니면 no 출력
			if(s.isEmpty()) { System.out.println("yes"); }
			else { System.out.println("no"); }
			
			//스택 비워주기
			s.clear();
			//새로운 입력 받아오기
			str = br.readLine().toCharArray();
		}
	}
}
