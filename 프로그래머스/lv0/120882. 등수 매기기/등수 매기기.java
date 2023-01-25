import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
		double[] avg = new double[score.length];
		
		for(int i = 0; i<score.length ;i++) {
			avg[i] = (score[i][0] + score[i][1]) /2.0;
		}
		
		Double[] rank = new Double[avg.length];
		
		for(int i = 0 ; i < avg.length ; i++) {
			rank[i] = avg[i];
		}
		
		Arrays.sort(rank,Collections.reverseOrder());
		
		for(int i = 0 ; i < avg.length ; i++) {
			for(int j = 0 ; j <avg.length ; j++) {
				if(rank[j] == avg [i]) {
					answer[i] = j+1;
					break;
				}
			}
		}
        return answer;
    }
}