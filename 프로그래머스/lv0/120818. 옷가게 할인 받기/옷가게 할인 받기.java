class Solution {
    public int solution(int price) {
        int answer = 0;
        double np = 0;
        if(price>=500000)
            np = price * 0.8;
        else if(price>=300000)
            np = price * 0.9;
        else if(price>=100000)
            np = price * 0.95;
        else
            np = price;
        answer = (int)np;
        return answer;
    }
}