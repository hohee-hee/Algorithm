import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        double para = n;
        int middle = (int)Math.sqrt(para);
        for(int i = 1 ; i <= middle ; i++){
            if(n%i == 0){
                list.add(i);
                if(i!=n/i)
                	list.add(n/i);
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0 ; i<list.size() ; i++)
        {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}