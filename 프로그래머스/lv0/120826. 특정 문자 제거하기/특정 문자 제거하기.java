class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        for(char c : my_string.toCharArray()){
            answer = my_string.replace(String.valueOf(letter),"");
        }
        return answer;
    }
}