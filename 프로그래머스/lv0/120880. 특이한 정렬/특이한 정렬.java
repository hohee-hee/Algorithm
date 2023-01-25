import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        
        int len = numlist.length;
		int[] answer = new int[len];
		int[] dist = new int[len];
		
		for(int i = 0 ; i < len ; i++) {
			dist[i] = Math.abs(numlist[i] - n);			
		}
		
		int[] rank = Arrays.copyOf(dist, len);
		Arrays.sort(rank);
		int tmp = 0;
		int idx = 0;
		
		for(int i = 0 ; i < len ; i++) {
			tmp = 0;
			idx = 0;
			for(int j = 0 ; j < len ; j++) {
				if(rank[i] == dist[j]) {
					if(tmp < numlist[j]) {
						tmp = numlist[j];
						idx = j;
					}
				}
			}
			answer[i] = numlist[idx];
			dist[idx] = -1;
		}
        
        return answer;
    }
}