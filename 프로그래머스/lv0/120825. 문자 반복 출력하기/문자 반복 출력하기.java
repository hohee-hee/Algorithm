class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        char[] tmp = my_string.toCharArray();
        for(int i = 0 ; i<tmp.length ; i++){
            for(int j = 0 ; j < n ; j++){
                answer = answer + tmp[i];
            }
        }
        return answer;
    }
}