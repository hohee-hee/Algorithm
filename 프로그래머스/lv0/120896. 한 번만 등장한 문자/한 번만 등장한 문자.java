class Solution {
    public String solution(String s) {
        String answer = "";
        char[] str = s.toCharArray();
        int[] freq = new int[26];
        for(int i = 0 ; i < str.length ; i++){
            freq[(int)str[i]-97]++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] == 1){
                int n = i + 97;
                answer = answer + (char)n;
            }                
        }
        return answer;
    }
}