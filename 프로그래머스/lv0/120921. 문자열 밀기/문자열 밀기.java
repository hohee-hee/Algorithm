class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        char[] Alist = A.toCharArray();
        int idx = Alist.length-1;
        int res = 0;
        
        for(int i = 0 ; i < A.length() ; i++ ){
            char tmp = Alist[idx];
            for(int j = idx ; j > 0 ; j--){
                Alist[j] = Alist[j-1];
            }
            Alist[0] = tmp;
            A = String.valueOf(Alist);
            if(A.equals(B)) {
            	res = i+1;
            	break;
            }                
        }
        if(res == A.length())
            answer = 0;
        else if (res == 0)
            answer = -1;
        else
            answer = res;
        return answer;
    }
}