import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int len = sc.nextInt();
		boolean[] btn = new boolean[len+1];
		
		for(int i = 1 ; i <= len ; i++) {
			int status = sc.nextInt();
			if(status == 1)
				btn[i] = true;
		}
		
		
		int stu = sc.nextInt();
		for(int i = 0 ; i < stu ; i++) {
			int gender = sc.nextInt();
			//1. 남학생
			if(gender == 1) {
				int num = sc.nextInt();
				int multi = 1;
				while(num * multi <= len) {
					btn[num * multi] = !btn[num * multi];
					multi++;
				}
			}
			
			//2. 여학생
			else {
				int num = sc.nextInt();
				int idx = 1;
				while((num+idx) <= len && (num-idx) > 0 && btn[num+idx] == btn[num-idx]) {
					idx++;
				}
				btn[num] = !btn[num];
				for(int j = 1 ; j < idx ; j++) {
					btn[num + j] = !btn[num + j];
					btn[num - j] = !btn[num - j];
				}
			}
		}
		
		
		//출력 : 20개씩
		for(int i = 1 ; i <= len ; i++) {
			if(btn[i]) sb.append(1);
			else sb.append(0);	
			
			if(i%20 == 0) sb.append("\n");
			else sb.append(" ");
		}
		
		System.out.println(sb);
	}
}
