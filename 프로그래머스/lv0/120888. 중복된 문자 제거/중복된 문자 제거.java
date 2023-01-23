class Solution {
    public String solution(String my_string) {        
        String answer = "";
        char[] str = my_string.toCharArray();
        for(int i = 0 ; i < str.length ; i++){
            for(int j = i+1; j < str.length ; j++){
                if(str[i] == str[j]){
                    str[j] =  '\u0000';
                }
            }
        }
        for(int i = 0 ; i < str.length ; i++) {
        	if(str[i] !=  '\u0000')
        		answer = answer + str[i];
        }
        return answer;
    }
}