import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//스택선언
		Stack<Character> s = new Stack<>();
		
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		char[] str = br.readLine().toCharArray();
		
		int piece = 0 ;//막대기 조각
		
		for(int i = 0 ; i < str.length ; i++) {
			if(str[i] == '(') { s.push(str[i]); }
			else {
				if(str[i-1] == '(') { 
					s.pop();
					piece += s.size();
				}
				else {
					s.pop();
					piece++;
				}
			}			
		}
		
		System.out.println(piece);
		
	}
}
