import java.util.ArrayList;

class Solution {
    public int solution(int a, int b) {
        		int answer = 1;
		int min = Math.min(a, b);
		for(int i = 2 ; i <= min ; i++) {
			if(a % i == 0 && b % i == 0) {
				a = a/i;
				b = b/i;
			}
		}
			
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 2; i<= b ; i++){
            outer : if(b % i == 0){
            	int tmp = i;
            	for(int j = 2 ; j <= tmp ; j++) {
            		if(tmp != j && tmp % j == 0)
            				break outer;        		
            	}        		
                list.add(i);
            }
        }
        
        int[] div = list.stream().mapToInt(Integer::intValue).toArray();
        
        for(int i = 0 ; i < div.length ; i++) {
        	if(div[i] != 2 && div[i] != 5) {
        		answer = 2;
        		break;
        	}
        }      
        
        return answer;
    }
}