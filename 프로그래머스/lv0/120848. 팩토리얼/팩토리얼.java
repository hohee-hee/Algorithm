class Solution {
    public int solution(int n) {
        int answer = 1;
        int fact = 1;
        while(true){
            fact = fact * answer;
            if(fact > n){
                answer--;
                break;
            }
            else
                answer++;
        }
        return answer;
    }
}