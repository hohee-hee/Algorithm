import java.util.Scanner;

class Solution
{
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
	
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			//변수 선언
			int test = Integer.parseInt(sc.next());
			char[] p = sc.next().toCharArray(); //입력 받기
			char[] t = sc.next().toCharArray(); //입력 받기
			int cnt = 0; //일치하는 패턴 개수 세기
			int p_len = p.length; //패턴 길이
			int t_len = t.length; //텍스트 길이
			
			//패턴 찾기
			//i를 우측으로 계속 이동하면서 동일한 패턴 찾기
			for(int i = 0 ; i < t_len - p_len + 1 ; i++) {
				boolean flag = true; //일치 여부를 확인해줄 flag
				for(int j = 0 ; j < p_len ; j++) {
					//만약 패턴의 char와 텍스트의 char가 일치하지 않으면 패턴이 아니므로 
					//flag를 false로 바꾸고 내부 for문 중단
					if(p[j] != t[i+j]) {
						flag = false;
						break;
					}
				}
				//내부 for문 종료 후에도 flag가 true이면 패턴을 찾았다는 의미
				//카운트 변수 더해주기
				if(flag) { cnt++; }
			}
			
			System.out.printf("#%d %d\n", test, cnt);
			
		}
		
	}
}