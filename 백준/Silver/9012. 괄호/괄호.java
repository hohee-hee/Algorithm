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
	
	static String vps(String str) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++) {
			char c = str.charAt(i);
			if(c == '(') {
				stack.push(1);
			}
			else {
				if(!stack.isEmpty()) {
					stack.pop();
				}
				else {
					return "NO";
				}
			}			
		}
		if(stack.isEmpty())
			return "YES";
		else
			return "NO";
	}	
}