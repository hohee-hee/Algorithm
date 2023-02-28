import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		int holder = 0;
		
		for(int i = 0 ; i < N ; i++) {
			if(line.charAt(i) == 'S') { holder++; }
			else {
				holder++;
				i++;
			}
		}
		
		holder++; //맨 끝 홀더
		if(N < holder) System.out.println(N);
		else System.out.println(holder);
	}
}
