import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[12];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			if(gender == 0) { arr[(grade-1) * 2]++; }
			else { arr[grade * 2 - 1]++; }			
		}
		
		int cnt = 0;
		for(int i = 0 ; i < 12 ; i++) {
			if(arr[i] == 0) continue;
			
			if(arr[i] <= limit) {
				cnt++;
			}
			else {
				cnt += arr[i] / limit;
				if(arr[i] % limit != 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
