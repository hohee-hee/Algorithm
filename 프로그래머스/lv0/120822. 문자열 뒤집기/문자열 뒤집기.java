class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] list = my_string.toCharArray();
        int lp = 0;
        int rp = list.length-1;
        char tmp;
        while(lp<rp){
            tmp = list[lp];
            list[lp] = list[rp];
            list[rp] = tmp;
            lp++;
            rp--;
        }
        for(int i = 0 ; i < list.length ; i++)
            answer = answer + list[i];
        return answer;
    }
}