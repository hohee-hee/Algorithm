import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] div = new int[10];
		for(int i = 0 ; i < 10 ; i++) {
			int n = Integer.parseInt(br.readLine());
			div[i] = n % 42;
		}
		
		Arrays.sort(div);
		
		int cnt = 0;
		for(int i = 0 ; i < 10 ; i++) {
			if(i == 0) { 
				cnt++;
				continue;
			}
			
			if(div[i] != div[i-1]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
