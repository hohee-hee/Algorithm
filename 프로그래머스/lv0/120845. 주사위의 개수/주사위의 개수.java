class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        for(int i = 0 ; i < 3 ; i++){
            int cnt = box[i]/n;
            answer = answer * cnt;
        }
        return answer;
    }
}