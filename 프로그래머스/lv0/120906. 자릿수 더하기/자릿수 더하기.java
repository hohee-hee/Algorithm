class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1000000;
        while(i>=10){
            answer += n/i;
            n = n%i;
            i = i/10;
        }
        answer += n;
        return answer;
    }
}