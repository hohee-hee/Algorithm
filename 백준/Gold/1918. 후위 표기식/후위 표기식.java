import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String suf = "";
		Deque<Character> s = new ArrayDeque<>();
		
		for(int i = 0 ; i < str.length() ; i++) {
			char ch = str.charAt(i);
			if(ch > 64 && ch < 91) {
				suf += ch;
			}
			else if(ch == '(') {
				s.offerLast(ch);
			}
			else if(ch == ')') {
				while(s.peekLast() != '(') {
					suf += s.pollLast();
				}
				s.pollLast();
			}
			else {
				while(!s.isEmpty() && rank(s.peekLast()) <= rank(ch))
					suf += s.pollLast();
				s.offerLast(ch);
			}		
		}
		
		while(!s.isEmpty()) {
			suf += s.pollLast();
		}
		
		System.out.println(suf);
	}
	
	private static int rank(char ch) {

		if(ch == '+' || ch == '-') {
			return 2;
		}
		else if(ch == '*' || ch == '/'){
			return 1;
		} 
		else {
			return 3;
		}
	}
}
