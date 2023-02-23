import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer> dq = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push_front":
				push_front(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				push_back(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				pop_front();
				break;
			case "pop_back":
				pop_back();
				break;
			case "size":
				size();
				break;
			case "empty":
				isEmpty();
				break;
			case "front":
				front();
				break;
			case "back":
				back();
				break;
			}
		}
		System.out.println(sb);
	}
	
	static void push_front(int x) {
		dq.add(0, x);
	}
	
	static void push_back(int x) {
		dq.add(dq.size(), x);
	}
	
	static void pop_front() {
		if(dq.size() == 0) sb.append(-1).append("\n");
		else {
			sb.append(dq.get(0)).append("\n");
			dq.remove(0);
		}
	}
	
	static void pop_back() {
		if(dq.size() == 0) sb.append(-1).append("\n");
		else {
			sb.append(dq.get(dq.size()-1)).append("\n");
			dq.remove(dq.size()-1);
		}
	}
	
	static void size() {
		sb.append(dq.size()).append("\n");
	}

	static void isEmpty() {
		if(dq.size() == 0) sb.append(1).append("\n");
		else sb.append(0).append("\n");
	}
	
	static void front() {
		if(dq.size() == 0) sb.append(-1).append("\n");
		else sb.append(dq.get(0)).append("\n");
	}
	
	static void back() {
		if(dq.size() == 0) sb.append(-1).append("\n");
		else sb.append(dq.get(dq.size()-1)).append("\n");
	}
}


