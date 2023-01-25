import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 2; i<= n ; i++){
            outer : if(n % i == 0){
            	int tmp = i;
            	for(int j = 2 ; j <= tmp ; j++) {
            		if(tmp != j && tmp % j == 0)
            				break outer;        		
            	}        		
                list.add(i);
            }
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();        
            
        return answer;
    }
}