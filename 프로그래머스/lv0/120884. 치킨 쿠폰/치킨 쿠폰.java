class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int tmp = 0;
        while(chicken / 10 != 0){
            tmp = chicken / 10;
            answer += tmp;
            chicken = chicken % 10 + tmp; 
        }
        return answer;
    }
}