import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
	
	//노드 클래스
	public static class Node{
		String data;
		int left;
		int right;
		
		public Node(String data) {
			this.data = data;
			this.left = 0;
			this.right = 0;
		}
	}
	
	static Node[] tree; //트리
	static String[] suf; //후위연산식
	static int N; //노드 개수
	static int sdx; //후위연산식 인덱스
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1 ; tc <= 10 ; tc++) {	
			
			//트리 만들기
			N = sc.nextInt(); //정점 개수
			tree = new Node[N+1]; //트리
			for(int i = 1 ; i <= N ; i++) {
				int idx = sc.nextInt(); //인덱스
				String data = sc.next(); //노드의 값 받아오기
				Node n = new Node(data); //받아온 값으로 새 노드 만들기
				//만약 노드의 값이 연산자라면 자식노드의 번호 받아오기
				if(data.equals("-") || data.equals("+") || data.equals("/") || data.equals("*")) {
					n.left = sc.nextInt();
					n.right = sc.nextInt();
				}
				//배열에 노드 넣어주기
				tree[idx] = n;
			}
			
			suf = new String[N]; //후위연산식을 넣을 배열 초기화
			sdx = 0; //후위연산식 인덱스 초기화
			//순회하기
			post(1);
			
			//연산에 사용할 스택 선언
			Deque<Float> s = new ArrayDeque<>();
			for(int i = 0 ; i < sdx ; i++) {
				if(suf[i].equals("-") || suf[i].equals("+") || suf[i].equals("/") || suf[i].equals("*")) {					
					float num2 = s.pollLast();
					float num1 = s.pollLast();
					float res = 0;
					switch(suf[i]) {
					case "-" :
						res = num1 - num2;
						s.offer(res);
						break;
					case "+" :
						res = num1 + num2;
						s.offer(res);
						break;
					case "/" :
						res = num1 / num2;
						s.offer(res);
						break;
					case "*" :
						res = num1 * num2;
						s.offer(res);
						break;
					}
				}
				else {
					s.offer((float)Integer.parseInt(suf[i]));
				}
			}
			System.out.printf("#%d %.0f\n", tc, s.pollLast());
		}
	}
	
	public static void post(int i) {
		if(i <= N) {
			Node cur = tree[i];
			if(cur.left != 0) {	post(cur.left); }
			if(cur.right != 0) { post(cur.right); }
			suf[sdx++] = cur.data;
		}
	}
}
