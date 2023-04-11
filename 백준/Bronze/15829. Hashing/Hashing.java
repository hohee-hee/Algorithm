import java.io.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
		
		//1. 입력 받기	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		//3. 계산하기
		long answer = 0;
		long r = 1;
		
		for(int i = 0 ; i < str.length() ; i++) {
			int n = str.charAt(i) - 96;
			//r의 거듭제곱 구하기
			if(i > 0) r *= 31;

			//더하기
			answer += n * (r % 1234567891);
		}
		
		System.out.println(answer % 1234567891);
	}
}
