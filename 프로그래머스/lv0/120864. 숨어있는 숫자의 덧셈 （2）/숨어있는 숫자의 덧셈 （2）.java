class Solution {
    public int solution(String my_string) {
		int answer = 0;
        String str = my_string.replaceAll("[^0-9]", " ");
        String[] num = str.split(" ");
        for(int i = 0 ; i < num.length ; i++) {
        	if(num[i].length()>=1) {
	        	int tmp = Integer.parseInt(num[i]);
	        	answer += tmp;
        	}
        }
        return answer;
    }
}