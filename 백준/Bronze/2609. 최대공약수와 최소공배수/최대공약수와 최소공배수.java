import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//유클리드 호제법
		int num_1 = Math.max(N, M);		
		int num_2 = Math.min(N, M);
				
		System.out.println(gcd(num_1,num_2));		
		
		System.out.println((N * M ) /gcd(num_1,num_2));
	}
	
	public static int gcd(int n1, int n2) {
		if(n1%n2 == 0)
			return n2;
		return gcd(n2,n1%n2);
	}

}
