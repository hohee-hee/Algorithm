import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String N = sc.next();
			if(N.equals("0"))
				break;
			String pal = "";
			for(int i = N.length() - 1 ; i>=0 ; i--)
				pal += N.charAt(i);		
			if(pal.equals(N))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}