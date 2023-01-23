import java.util.stream.Stream;

class Solution {
    public int solution(int i, int j, int k) {        
        int answer = 0;        
		char para = (char) (k + '0');
        String str = "";
        for(int a = i ; a <= j ; a++ ){
            str = str + a;
        }
        char[] num = str.toCharArray();
        for(int a = 0 ; a < num.length ; a++){
            if(num[a] == para )
                answer++;
        }
        return answer;
    }
}