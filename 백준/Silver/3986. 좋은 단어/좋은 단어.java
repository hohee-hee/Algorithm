import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		//스택선언
		Stack<Character> s = new Stack<>();
		
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		//좋은 단어의 개수
		int cnt = 0;
		
		//좋은 단어 개수 세기
		//1. 문자열 입력 받기
		//2. 문자 하나하나 방문하면서 스택이 비었거나 top이 해당 문자와 일치하지 않으면 push
		//   아니라면 pop
		//3. 스택이 비었으면 개수에 1 더해주기
		//4. 스택 비우기
		for(int i = 0 ; i < N ; i++) {
			//문자열을 문자로 저장할 배열
			char[] str = br.readLine().toCharArray();
			//각 문자에 방문하면서 조건에 따라 push or pop 해주기
			for(int j = 0 ; j < str.length ; j++) {
				if(s.isEmpty() || s.peek() != str[j]) { s.push(str[j]); }
				else { s.pop(); }
			}
			if(s.isEmpty()) { cnt++; }
			else { s.clear(); }
		}
		
		//출력
		System.out.println(cnt);
	}
}
