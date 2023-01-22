class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char[] num = {'0','1','2','3','4','5','6','7','8','9'};
        char[] str = my_string.toCharArray();
        for(int i = 1 ; i<=9 ; i++){
            for(int j = 0 ; j < str.length ;j++){
                if(num[i] == str[j])
                    answer += i;
            }
        }        
        return answer;
    }
}