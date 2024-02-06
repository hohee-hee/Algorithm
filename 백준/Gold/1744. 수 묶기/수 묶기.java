import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		//1. 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int cnt = 0; //음수 개수
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());			
		}
		
		//2. 정렬하기
		Arrays.parallelSort(arr);
		
		//3. 양수 / 음수 찾기
		int idx = 0;
		while(idx < N && arr[idx] < 0) idx++;
		
//		System.out.println(idx);
		
		boolean isZero = false;
		if(idx < N && arr[idx] == 0) {
			isZero = true;
			idx++;
		}
		
//		System.out.println(idx);
		
		//3. 수묶기
		int answer = 0;
		
		//음수 계산
		for(int i = 1 ; i < idx ; i+=2) {
			answer += arr[i] * arr[i-1];
			arr[i] = 0;
			arr[i-1] = 0;
		}
		//음수 & 0 계산
		if(idx > 0 && arr[idx-1] != 0 && isZero) arr[idx-1] = 0;		


//		System.out.println(Arrays.toString(arr));
		//양수 계산
		for(int i = N-1 ; i > idx ; i-=2) {
			if(arr[i] == 1 || arr[i-1] == 1) continue;
			answer += arr[i] * arr[i-1];
			arr[i] = 0;
			arr[i-1] = 0;
		}
//		System.out.println(Arrays.toString(arr));
		
		//나머지 더하기
		for(int i = 0 ; i < N ; i++) answer += arr[i];
		
		System.out.println(answer);
		
	}
}
