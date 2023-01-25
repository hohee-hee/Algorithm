class Solution {
    public int solution(int[][] lines) {
		int answer = 0;
        
        int[] line = new int[201];
        
        for(int i = 0 ; i < 3 ; i++) {
        	for(int j = lines[i][0] + 1 ; j <= lines[i][1] ; j++) {
        		line[j+100] ++ ;
        	}
        }
        
        for(int i = 0 ; i < 201 ; i++) {
        	if(line[i] >= 2)
        		answer++;        	
        }
        return answer;
    }
}