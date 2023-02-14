import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		if(V-A <= 0) {
			System.out.println(1);
			return;
		}
		int a = V-A;
		if(a%(A-B) == 0) {
			a/=(A-B);
		} else {
			a = a/(A-B) + 1;
		}
		System.out.println(a+1);
	}
}
