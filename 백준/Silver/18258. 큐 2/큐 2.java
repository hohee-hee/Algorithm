
import java.io.*;
import java.util.*;

public class Main {
	static int[] queue;
	static int front = -1, rear = -1;
 	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		queue = new int[N];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				pop();
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
	
	static void push(int x) {
		if(rear != queue.length -1) queue[++rear] = x;
	}
	
	static void pop() {
		if(front == rear) sb.append(-1).append("\n");
		else {
			sb.append(queue[++front]).append("\n");
		}
	}
	
	static void size() {
		sb.append(rear-front).append("\n");
	}

	static void isEmpty() {
		if(front == rear) sb.append(1).append("\n");
		else sb.append(0).append("\n");
	}
	
	static void front() {
		if(front == rear) sb.append(-1).append("\n");
		else sb.append(queue[front+1]).append("\n");
	}
	
	static void back() {
		if(front == rear) sb.append(-1).append("\n");
		else sb.append(queue[rear]).append("\n");
	}
}
