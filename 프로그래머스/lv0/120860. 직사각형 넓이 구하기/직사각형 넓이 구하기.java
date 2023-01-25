class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int l1 = 0;
        int l2 = 0;
        int i = 0;
        for(i = 1 ; i < dots.length ; i++){
            if(dots[0][0] == dots[i][0]){
               l1 =  Math.abs(dots[0][1] - dots[i][1]);              
            }
            else
                l2 = Math.abs(dots[0][0] - dots[i][0]);
        }
        answer = l1 * l2;
        return answer;
    }
}