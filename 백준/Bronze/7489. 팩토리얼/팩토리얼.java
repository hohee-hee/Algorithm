import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < t ; i ++) {
			int n = Integer.parseInt(br.readLine());
			long num = 1;
			for(int j = 1 ; j <= n ; j++) {
				num *= j;
				while(true) {
					if(num%10 != 0) {
						num=num%10000;
						break;
					}
					else {
						num /= 10;
					}
				}
			}
			sb.append((num%10) + "\n");
		}		
		System.out.println(sb);		
	}
}
