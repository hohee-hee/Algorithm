import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<Integer> stack = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int K = Integer.parseInt(br.readLine());
		
		//스택에 pop과 push하기
		//0이면 pop , 0이 아니면 push
		for(int i = 0 ; i < K ; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) { push(num); }
			else { pop(); }
		}
		
		//합 구하기
		int node_sum = 0;
		while(stack.size() != 0) {
			node_sum += pop();
		}
		
		System.out.println(node_sum);
	}
	
	//push
	static void push(int x) {
		stack.add(x);
	}
	
	//pop
	//합을 구할 때 사용하기 위하여 pop하는 노드의 원소 반환
	static int pop() {
		int ele = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return ele;
	}
}
