class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        char[] str = cipher.toCharArray();
        int range = str.length / code;
        for(int i = 1 ; i <= range ; i++){
            answer += str[code*i-1];
        }
        return answer;
    }
}