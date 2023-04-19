import java.io.*;

public class Main{
	
	public static void main(String[] args)  throws IOException {
		
		//1. 입력 받기		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        
        //조기종료 : 1일때
        if(N == 1) {
			System.out.println(1);
			return;
		}
        
		long[] fibo = new long[N+1];
		
		fibo[1] = 1;
		fibo[2] = 2;
		
		for(int i = 3 ; i <= N ; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
			fibo[i] %= 10007;
		}
		
		System.out.println(fibo[N]);
		
	}
}
