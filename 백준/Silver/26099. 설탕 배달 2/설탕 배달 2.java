import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long answer = 0;
		
		//1. 5로 나누기
		answer += N / 5;
		N %= 5;
		
		//2. 3으로 나누기
		if(N%3 == 0) {
			answer += N/3;
			System.out.println(answer);
			return;
		}
		
		//3. 안나눠진다면
		while(answer > 0 && N%3 != 0) {
			answer--;
			N += 5;
		}
		
        //4. 맞게 출력하기
		if(N%3 != 0) answer = -1;
		else answer += N/3;
        
		System.out.println(answer);
	}
}
