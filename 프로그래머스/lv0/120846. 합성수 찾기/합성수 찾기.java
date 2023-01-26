class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++){
            int c =0;
            for(int j=1; j<=n; j++){
                if(i%j==0){
                    c +=1;
                }
            }
            if( c >=3){
                answer++;
            }
        }
        return answer;
    }
}