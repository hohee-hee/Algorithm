class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        outer : for(int i = 0 ; i < babbling.length ; i++){
            String s = babbling[i];         
            while(true){
                if(s.contains("aya")){
                	s = s.replace("aya"," ");
                }
                else if(s.contains("ye")){
                	s = s.replace("ye"," ");
                }
                else if(s.contains("woo")){
                	s = s.replace("woo"," ");
                }
                else if(s.contains("ma")){
                	s = s.replace("ma"," ");              
                }
                else {
                    break;
                }
            }
            int j = 0;
            for(j = 0 ; j < s.length() ; j++) {
            	if(s.charAt(j) != ' ') {
            		break;
            	}            	
            }
            if(j == s.length())
            	answer++;       
        }      
        return answer;
    }
}