class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0 ; i < quiz.length ; i++)
        {
            String[] str = quiz[i].split(" ");
            int check = 0;
            if(str[1].equals("-")){
                check = Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
            }
            else if(str[1].equals("+")){
                check = Integer.parseInt(str[0]) + Integer.parseInt(str[2]);
            }
            
            if(check == Integer.parseInt(str[4])){
                answer[i] = "O";
            }
            else{
                answer[i] = "X";
            }
        }
        return answer;
    }
}