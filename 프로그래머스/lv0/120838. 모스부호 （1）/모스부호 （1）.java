class Solution {
    public String solution(String letter) {
        
        String answer = "";
        String[] str = letter.split(" ");
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int ascii = 0;
        for(int i = 0 ; i < str.length ; i++){
            for(int j = 0 ; j < morse.length ; j++){
                if(str[i].equals(morse[j])){
                    ascii = j + 97;
                    break;
                }
            }
            answer = answer + (char)ascii;
        }        
        return answer;
    }
}