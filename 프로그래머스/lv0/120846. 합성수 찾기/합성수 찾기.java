class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1 ; i <= n ; i++)
        {
            int middle = (int)Math.sqrt(i);
            for(int j = 2 ; j <= middle ; j++){
                if(i%j == 0){
                    answer++;
                    break;
                }                    
            }
                
        }
        return answer;
    }
}