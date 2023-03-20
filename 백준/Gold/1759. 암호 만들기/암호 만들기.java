	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.StringTokenizer;
	
	public class Main {
		
		static int L;
		static int C;
		static char[] ch;
		static char[] pw;
		static boolean[] isUsed;
		static StringBuilder sb;
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
	
			L = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ch = new char[C];
			for(int i = 0 ; i < C ; i++) {
				ch[i] = st.nextToken().charAt(0);
			}
			Arrays.sort(ch);
			
			pw = new char[L];
			isUsed = new boolean[C];
			
			sb = new StringBuilder();
			BackTracking(0, 0);
			
			System.out.println(sb);
		}
	
		private static void BackTracking(int idx, int cdx) {
			if(idx == L) {
				String answer = "";
				for(int i = 0 ; i < L ; i++) {
					answer += pw[i];
				}	
				//조건 검사
				int vo = 0; //모음
				int co = 0; //자음
				for(int i = 0 ; i < L ; i++) {
					if(answer.charAt(i) == 'a' || answer.charAt(i) == 'e' || answer.charAt(i) == 'o' || answer.charAt(i) == 'i' || answer.charAt(i) == 'u') {
						vo++;
					}
					else co++;
				}
				
				if(vo >= 1 && co >=2) {					
					sb.append(answer + "\n");
				}
				return;
			}
			
			for(int i = cdx ; i < C ; i++) {
				if(!isUsed[i]) {
					pw[idx] = ch[i];
					isUsed[i] = true;
					BackTracking(idx+1, i);
					isUsed[i] = false;
				}
			}
		}
	}
