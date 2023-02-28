import java.util.Scanner;

public class Solution {
	
	static char[] tree;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1 ; test_case <= 10; test_case++) {
			sb.append("#" + test_case + " ");
			
			int N = sc.nextInt(); //노드의 개수
			
			tree = new char[N+1];
			
			//배열에 노드 추가
			//완전 이진 트리이므로 왼쪽, 오른쪽 자식 노드의 넘버는 필요하지 않음
			//따라서 왼오 자식노드가 있으면 날려주기
			for(int i = 1 ; i <= N ; i++) {
				tree[sc.nextInt()] = sc.next().charAt(0);
				if( i * 2 <= N) { sc.nextInt(); } //왼쪽 자식노드가 있을 때 날려주기
				if( i * 2 + 1 <= N ) { sc.nextInt(); } //오른쪽 자식노드가 있을 때 날려주기
			}
			
			//중위 순회
			inorder(1);
			
			//테케 당 개행문자 추가
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	//중위 순회
	public static void inorder(int n) {
		if(n < tree.length) {
			inorder(n*2); //왼쪽 노드 순회
			sb.append(tree[n]); //자기 자신 방문
			inorder(n*2+1); //오른쪽 노드 순회
		}
	}
}
