import java.util.stream.Stream;

class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        int[] digits = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();  
        int i = 0;
        for(i = 0 ; i < digits.length ; i++){
            if(digits[i] == k){
                answer = i+1;
                break;
            }                
        }
        if (i == digits.length)
            answer = -1;
        return answer;
    }
}