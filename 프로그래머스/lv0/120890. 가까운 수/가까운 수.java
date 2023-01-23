import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int answer = 0;
        int minus = 0;
        int min = array[array.length-1];
        for(int i = 0 ; i < array.length ; i++){
            minus = Math.abs(n-array[i]);
            if(min>minus){
                min = minus;
                answer = array[i];
            }
        }
        return answer;
    }
}