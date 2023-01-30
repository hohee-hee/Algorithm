import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 666;
		for(int i = 0 ; i < N ; i++) {
			String tmp = Integer.toString(answer);
			while(true) {
				tmp = Integer.toString(answer);
				if(tmp.contains("666")) {
					answer++;
					break;
				}
				answer++;
			}
		}
		System.out.println(answer-1);
	}
}