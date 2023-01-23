class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length()/n;
        String str ="";
        if(my_str.length()%n != 0)
            len++;        
        String[] answer = new String[len];
        for(int i = 1 ; i <= len ; i++){
        	str = "";
            for(int j = i*n-n ; j < n*i ; j++){
            	if(j>=my_str.length())
            		break;
                str += my_str.charAt(j);
            }
            answer[i-1] = str;
        }        
        return answer;
    }
}