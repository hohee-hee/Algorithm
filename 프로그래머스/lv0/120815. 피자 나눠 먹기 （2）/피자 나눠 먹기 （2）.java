class Solution {
    public int solution(int n) {
        int answer = 1;
        while(true){
            if((answer*6)%n != 0){
                answer++;
            }
            else
                break;
        }
        return answer;
    }
}