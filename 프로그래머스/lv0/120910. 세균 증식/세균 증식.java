class Solution {
    public int solution(int n, int t) {
        int answer = 0;
        double tmp = n * Math.pow(2,t);
        answer = (int) tmp;
        return answer ;
    }
}