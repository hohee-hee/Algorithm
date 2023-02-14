import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BigInteger bignumber1 = new BigInteger(st.nextToken());
		BigInteger bignumber2 = new BigInteger(st.nextToken());
		
		System.out.println(bignumber1.add(bignumber2));
	}
}
