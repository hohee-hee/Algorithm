import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] list = new boolean[M+1];
		for(int i = 0; i <= M ; i++) {
			list[i] = true;
		}
		list[0] = false;
		list[1] = false;
		for(long i = 2 ; i <= M ; i++) {
				for(long j = i*i ; j <= M ; j+=i) {
					list[(int)j] = false;
				}			
		}
		StringBuilder sb = new StringBuilder();
		for(int i = N; i <= M ; i++) {
			if(list[i])
				sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}

}
