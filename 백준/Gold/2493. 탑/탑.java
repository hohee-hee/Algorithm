import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> stack = new ArrayList<>(); //탑 높이를 저장할 스택
	static ArrayList<Integer> index = new ArrayList<>(); //인덱스 스택
	public static void main(String[] args) throws IOException {
		
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //N
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for(int i = 0 ; i < N ; i++) {
			
			int input = Integer.parseInt(st.nextToken());
			while(peek(stack) != 0 && peek(stack) < input) {
				pop(stack);
				pop(index);
			}
			sb.append(peek(index)).append(" ");
			push(stack, input);
			push(index, i+1);
		}

		System.out.println(sb);
	}
	
	static void push(ArrayList<Integer> list,int x) {
		list.add(x);
	}
	
	static void pop(ArrayList<Integer> list) {
		if(list.size() == 0) return;
		list.remove(list.size() -1);
	}
	
	static int peek(ArrayList<Integer> list) {
		if(list.size() == 0) return 0;
		return list.get(list.size() - 1);
	}
}