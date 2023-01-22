class Solution {
    public String solution(String rsp) {
        String answer = "";
        char[] str = rsp.toCharArray();
        for(int i = 0 ; i < str.length ; i++){
            if(str[i] == '2'){
                answer += "0";
            }
            else if(str[i] == '0'){
                answer += "5";
            }
            else
                answer += "2";
        }
        return answer;
    }
}