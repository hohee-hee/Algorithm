
import java.io.*;

public class Main {	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb.append((int)Math.pow(2,N) - 1).append("\n");
		hanoi(1,3,N);	
		System.out.println(sb);
	}
	
	//a : 시작기둥
	//b : 도착기둥
	//n : 옮길 원판의 개수
	public static void hanoi(int a, int b, int n) {
		if(n== 1) {
			sb.append(a + " " + b).append("\n");
			return;
		}
		
		hanoi (a, 6-a-b, n-1);
		sb.append(a + " " + b).append("\n");
		hanoi (6-a-b, b, n-1);
	}
}
