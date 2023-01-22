class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int tmp = 0;
        for(int i = 0 ; i < numbers.length - 1 ; i++)
        {
            for(int j = i+1 ; j < numbers.length ; j++)
            {
                tmp = numbers[i] * numbers[j];
                if(tmp>answer)
                    answer = tmp;
            }
        }
        return answer;
    }
}