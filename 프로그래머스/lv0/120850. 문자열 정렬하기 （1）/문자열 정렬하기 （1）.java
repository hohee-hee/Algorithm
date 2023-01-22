import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> list = new ArrayList<Integer>();        
        char[] str = my_string.toCharArray();
        for(int i = 0 ; i < str.length ; i++){
            if((int)str[i] >=48 && (int)str[i]<=57){
                list.add((int)str[i] - 48);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++)
            answer[i] = list.get(i);
        Arrays.sort(answer);
        return answer;
    }
}