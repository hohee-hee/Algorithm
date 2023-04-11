import java.io.*;
import java.util.*;

public class Main {
	
	static final int M = 1234567891;
	
	public static void main(String[] args) throws IOException {
		
		//1. 입력 받기	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		//2. 배열 만들기
		int[] arr = new int[str.length()];
		//알파벳 변환해서 넣기
		for(int i = 0 ; i < str.length() ; i++) arr[i] = str.charAt(i) - 96;
		
		//3. 계산하기
		long answer = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			//r의 거듭제곱 구하기
			long r = 1;
			for(int j = 0 ; j < i ; j++) r *= 31;
			
			//더하기
			answer += arr[i] * r % M;
		}
		
		System.out.println(answer);
	}
}
