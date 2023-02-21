import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//스택선언
		Stack<Character> s = new Stack<>();
		
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		char[] str = br.readLine().toCharArray();
		
		int tmp = 1; //임시로 연산한 값을 저장
		int answer = 0; //답 저장
		
		for(int i = 0 ; i < str.length ; i++) {
			if(str[i]==')') {
				if(!s.isEmpty() && s.peek() == '(') { 
					if(str[i-1] == '(') { answer += tmp; }
					s.pop();
					tmp /= 2;
				}
				else {
					answer = 0;
					break;
				}
			}
			
			else if(str[i]==']') {
				if(!s.isEmpty() && s.peek() == '[') {
					if(str[i-1] == '['){ answer += tmp; }
					s.pop();
					tmp /= 3;
				}
				else {
					answer = 0;
					break;
				}
			}
			
			else {
				s.push(str[i]);
				if(str[i] == '(') { tmp *= 2; }
				else { tmp *= 3; }
			}
		}
		
		if(!s.isEmpty()) answer = 0;
		System.out.println(answer);
	}
}