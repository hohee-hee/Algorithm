import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {        
        int[] answer = new int[emergency.length];
        Integer[] copy = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        Arrays.sort(copy,Collections.reverseOrder());
        for(int i = 0 ; i < emergency.length ; i++){
            for(int j = 0 ; j < copy.length ; j++){
                if(emergency[i] == copy[j]){
                    answer[i] = j+1;
                }
            }
        }
        return answer;
    }
}