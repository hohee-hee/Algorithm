class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int middle = total/num;
        if(num%2 == 1)        {
            int start = middle - num/2;
            for(int i = 0 ; i < num ; i++){
                answer[i] = start;
                start++;
            }
        }
        else{
            int start = middle - (num/2-1);
            for(int i = 0 ; i < num ; i++){
                answer[i] = start;
                start++;
            }
        }            
        
        return answer;
    }
}