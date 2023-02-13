
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {	
	public static void main(String args[]) throws Exception	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num1 = 0;
		int num2 = 1;
		if(N == 1) {
			num2 = 1;
		}
		else {
			for(int i = 2; i <= N ; i++) {		
				int tmp = num2;
				num2 = num1+num2;
				num1 = tmp;
			}
		}
		System.out.println(num2);
	}
	

}
