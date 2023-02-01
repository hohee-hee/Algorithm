import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.math.BigInteger;
	import java.util.StringTokenizer;
	
	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			String tmp1 = br.readLine();
			StringTokenizer st = new StringTokenizer(tmp1);
			BigInteger A = new BigInteger("1");
			for(int i = 0 ; i < N ; i++) {
				BigInteger bint = new BigInteger(st.nextToken());
				A = A.multiply(bint);
			}
			int M = Integer.parseInt(br.readLine());
			String tmp2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(tmp2);
			BigInteger B = new BigInteger("1");
			for(int i = 0 ; i < M ; i++) {
				BigInteger bint2 = new BigInteger(st2.nextToken());
				B = B.multiply(bint2);
			}
			BigInteger num = A.gcd(B);
			String stnum = num.toString();
			if(stnum.length() > 9 ) {
				System.out.println(stnum.substring(stnum.length()-9, stnum.length()));
			}
			else {
				System.out.println(num);
			}
		}
	}
