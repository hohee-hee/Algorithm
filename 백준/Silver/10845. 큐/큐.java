import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//LinkedList 형의 큐 생성
		Queue<Integer> queue = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());	
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String statement = st.nextToken(); //Line 입력을 받을 때 push의 경우에는 요소값을 같이 입력받으므로 이를 분리해줄 Tokenizer 선언			
			//push일 때 받은 정수를 int로 형변환 하면 push
			if(statement.equals("push")) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			//pop일때 pop할 데이터가 없으면(앞 있는 데이터가 null이면)
			//-1 출력,
			//그렇지 않다면 poll함수를 활용하여 출력과 동시에 데이터 빼내기
			else if(statement.equals("pop")) {
				if(queue.peek() == null) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(queue.poll()).append("\n");
				}					
			}
			//size일 때 size 출력
			else if(statement.equals("size")) {
				sb.append(queue.size()).append("\n");
			}
			//empty일때 empty 이면 1, 아니면 0 반환
			else if(statement.equals("empty")) {
				sb.append(queue.isEmpty() ? 1 : 0).append("\n"); //람다식 : ~하면(?) true일 때 반환값 : false일 때 반환값
			}
			//front일때 pop할 데이터가 없으면(앞 있는 데이터가 null이면)
			//-1 출력,
			//그렇지 않다면 peek함수를 활용하여 출력			
			else if(statement.equals("front")) {
				if(queue.peek() == null) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(queue.peek()).append("\n");
				}					
			}
			//back일때 pop할 데이터가 없으면(앞 있는 데이터가 null이면)
			//-1 출력,
			//그렇지 않다면 queue 사이즈 만큼 정적 배열 생성 및 복사
			//copy의 마지막 요소를 출력
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