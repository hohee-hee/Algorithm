import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int score = 0;
		//최대 10회 반복
		//score은 점점 커지기 때문에 그 합이 100이 넘어가는 순간만 직전 스코어와 현재 스코어의 100과의 차를 계산
		for(int i = 0 ; i < 10 ; i++) {
			int n = Integer.parseInt(br.readLine());
			score += n;
			//현재 점수와 100의 차이가 직전 점수와 100의 차이보다 크다면 직전 점수로 score 변경
			//아니라면 score 유지
			//break
			if(score > 100) {
				if(score - 100 > 100 - (score - n)) {
					score -= n;
				}
				break;
			}
		}
		
		System.out.println(score);
	
	}
}