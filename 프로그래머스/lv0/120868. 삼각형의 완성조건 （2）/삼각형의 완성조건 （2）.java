class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = Math.max(sides[0],sides[1]);
        int min = Math.min(sides[0],sides[1]);
        int side = 0;
        for(side = 1 ; side < max ; side++){
            if(side > max - min)
                answer++;
        }
        for(side = max ; side < max+min ; side++){
            if(max+min > side)
                answer++;
        }
        return answer;
    }
}