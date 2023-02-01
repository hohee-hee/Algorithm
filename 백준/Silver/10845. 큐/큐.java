import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());	
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String statement = st.nextToken();			
			if(statement.equals("push")) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			else if(statement.equals("pop")) {
				if(queue.peek() == null) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(queue.poll()).append("\n");
				}					
			}
			else if(statement.equals("size")) {
				sb.append(queue.size()).append("\n");
			}
			else if(statement.equals("empty")) {
				sb.append(queue.isEmpty() ? 1 : 0).append("\n");
			}
			else if(statement.equals("front")) {
				if(queue.peek() == null) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(queue.peek()).append("\n");
				}					
			}
			else {
				if(queue.peek() == null) {
					sb.append(-1).append("\n");
				}
				else {
					int len = queue.size();
					int[] copy = new int[len];
					for(int j = 0 ; j < len ; j++) {
						copy[j] = ((LinkedList<Integer>) queue).get(j);
					}
					sb.append(copy[len - 1]).append("\n");
				}	
			}			
		}
		System.out.println(sb);
	}	
}