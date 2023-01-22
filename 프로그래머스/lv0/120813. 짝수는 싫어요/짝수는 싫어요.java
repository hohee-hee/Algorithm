import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n+1)/2];
        int idx = 0;
        for(int i = 1 ; i <= n ; i ++){
            if(i%2 != 0)
                answer[idx++] = i;
        }
        Arrays.sort(answer);
        return answer;
    }
}