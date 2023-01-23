class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        char[] str1 = before.toCharArray();
        char[] str2 = after.toCharArray();
        for(int i = 0 ; i < str1.length ; i++){
            for(int j = 0 ; j < str2.length ; j++){
                if(str1[i] == str2[j]){
                    str2[j] =  '\u0000';
                    break;
                }
            }
        }
        int i = 0;
        for(i = 0 ; i < str2.length ; i++){
            if(str2[i] != '\u0000')
                break;
        }
        if(i == str2.length)
            answer = 1;
        else
            answer = 0;
        return answer;
    }
}