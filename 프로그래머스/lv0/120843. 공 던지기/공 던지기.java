class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int idx = -2;
        for(int i = 0 ; i < k ; i++){
            idx += 2;
            if(idx>numbers.length)
                idx = idx - numbers.length;
        }
        answer = numbers[idx];
        return answer;
    }
}