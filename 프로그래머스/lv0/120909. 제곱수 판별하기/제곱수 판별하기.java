

class Solution {
    public int solution(int n){
        if(Math.sqrt(n) % 1 != 0)
            return 2;
        else
            return 1;
    }
}