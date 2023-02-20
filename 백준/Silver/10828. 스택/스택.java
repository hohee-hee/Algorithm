import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> stack = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push" :
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop" :
				pop();
				break;
			case "size" :
				size();
				break;
			case "empty" :
				empty();
				break;
			case "top" :
				top();
				break;
			}
		}
	}
	
	static void push(int x) {
		stack.add(x);
	}
	
	static void pop() {
		if(stack.size() == 0) { 
			System.out.println(-1);
		}
		else {
			System.out.println(stack.get(stack.size()-1));
			stack.remove(stack.size()-1);
		}
	}
	
	static void size() {
		System.out.println(stack.size());
	}
	
	static void empty() {
		if(stack.size() == 0) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	
	static void top() {
		if(stack.size() == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(stack.get(stack.size()-1));
		}
	}
}
