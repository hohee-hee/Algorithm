import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테케
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] stop = new int[5001]; //삼성 시에 있는 모든 정류장에 방문하는 버스의 수를 셀 배열
			
			//1. 정류장마다 노선 추가해주기
			int N = sc.nextInt(); //노선 개수
			for(int i = 0 ; i < N ; i++) {
				int start = sc.nextInt(); //기점
				int end = sc.nextInt(); //종점
				
				//각 노선별로 기점부터 종점까지 방문하는 모든 정류장에 1씩 더해주기(노선추가)
				for(int j = start ; j <= end ; j++) {
					stop[j]++;
				}
			}
			
			//2. 정류장 번호에 맞게 스트링 빌더에 추가하기
			sb.append("#" + test_case);
			int P = sc.nextInt();
			for(int i = 0 ; i < P ; i++) {				
				sb.append(" " + stop[sc.nextInt()]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
