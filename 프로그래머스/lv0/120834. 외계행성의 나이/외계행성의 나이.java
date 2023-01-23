class Solution {
    public String solution(int age) {
        String answer = "";
        String str = String.valueOf(age);
        char[] arr = str.toCharArray();
        int ascii = 0;
        for(int i = 0 ; i < arr.length ; i++){
            ascii = (int)arr[i] + 49;
            answer = answer + (char)ascii;
        }
        return answer;
    }
}