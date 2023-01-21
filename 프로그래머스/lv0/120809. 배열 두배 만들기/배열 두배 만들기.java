class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = numbers;
        for(int i = 0 ; i < numbers.length ; i++)
            numbers[i] = numbers[i] * 2;
        return answer;
    }
}