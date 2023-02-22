
import java.util.*;
import java.io.*;


public class Main{
	
	static char[][] tree;
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		tree = new char[N][3];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 3 ; j++)
				tree[i][j] = st.nextToken().charAt(0);
		}
		preorder(tree[0][0]);
		sb.append("\n");
		inorder(tree[0][0]);
		sb.append("\n");
		postorder(tree[0][0]);
		
		System.out.println(sb);
	}

	static void preorder(char ch) {
		//base case
		if(ch == '.') return;	
		
		//recursive case
		for(int i = 0 ; i < N ; i++) {
			if(tree[i][0] == ch) { 
				sb.append(ch);
				preorder(tree[i][1]); //left node
				preorder(tree[i][2]); //right node	
			}
		}			
	}
	
	static void inorder(char ch) {
		//base case
		if(ch == '.') return;
		
		//recursive case
		for(int i = 0 ; i < N ; i++) {
			if(tree[i][0] == ch) { 
				inorder(tree[i][1]); //left node
				sb.append(ch);
				inorder(tree[i][2]); //right node	
			}			
		}
	}
	
	static void postorder(char ch) {
		//base case
		if(ch == '.') return;
		//recursive case
		for(int i = 0 ; i < N ; i++) {
			if(tree[i][0] == ch) { 
				postorder(tree[i][1]); //left node
				postorder(tree[i][2]); //right node	
				sb.append(ch);
			}
		}
		
	}
}
