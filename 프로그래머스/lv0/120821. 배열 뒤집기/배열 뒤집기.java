class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int lp = 0;
        int rp = num_list.length-1;
        int tmp;
        while(lp<rp){
            tmp = num_list[lp];
            num_list[lp] = num_list[rp];
            num_list[rp] = tmp;
            lp++;
            rp--;
        }
        answer = num_list;
        return answer;
    }
}