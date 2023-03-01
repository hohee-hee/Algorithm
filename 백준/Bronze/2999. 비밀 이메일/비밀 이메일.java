
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		int R = 0;
		int C = 0;
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = i ; j <= N ; j++) {
				if(i * j == N && R < i) {
					R = i;
					C = j;
					break;
				}
			}
		}
		
		
		char[][] matrix = new char[R][C];
		int sdx = 0; //input 받은 string의 인덱스
		for(int i = 0 ; i < C ; i++) {
			for(int j = 0 ; j < R ; j++) {
				matrix[j][i] = str.charAt(sdx++);
			}				
		}
		
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				System.out.print(matrix[i][j]);
			}
		}
		
	}
}
