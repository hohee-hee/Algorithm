import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int cnt = 0;
		
		for(int i = 0 ; i < str.length ; i++) {
			char ch = str[i];
            if(ch == '-' || ch == '=') {
				continue;
			}
			else if(ch == 'c' && i < str.length - 1) {
				if(str[i+1] == '=' || str[i+1] == '-') { i++; }
			}
			else if(ch == 'l' || ch == 'n') {
				if(i < str.length - 1 && str[i+1] == 'j') { i++; }
			}
			else if(ch == 's' || ch == 'z') {
				if(i < str.length - 1 && str[i+1] == '=') { i++; }
			}
			else if(ch == 'd' && i < str.length - 2) {
				if(str[i+1] == 'z' && str[i+2] == '=') { i += 2;}
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
