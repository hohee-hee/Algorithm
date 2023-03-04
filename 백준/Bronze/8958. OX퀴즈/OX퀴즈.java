import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=T ;tc++) {
			char[] ox = br.readLine().toCharArray();
			int con = 0;
			int score = 0;
			for(int i = 0 ; i < ox.length ; i++) {
				if(ox[i] == 'O') {
					con++;
					score += con;
				}
				else {
					con = 0;
				}
			}
			
			sb.append(score+"\n");
		}
		
		System.out.println(sb);
	}
}
