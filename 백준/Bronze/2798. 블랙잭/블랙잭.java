import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr= new int[N];
		
		
		//입력받기
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = 0;
		
		//조합 찾기
		for(int i = 0 ; i < N-2 ; i++) {
			for(int j = i+1 ; j < N-1 ; j++) {
				for(int k = j+1 ; k < N ; k++) {
					if(arr[i] + arr[j] + arr[k] <= M && arr[i] + arr[j] + arr[k] > num)
						num = arr[i] + arr[j] + arr[k];
				}
			}
		}
		
		System.out.println(num);
	}
}
