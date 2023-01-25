class Solution {
    public String solution(String polynomial) {
         String answer = "";
        int x = 0;
        int inde = 0;
        int tmp = 0;
        String[] str = polynomial.split(" ");
        
        for(int i = 0 ; i < str.length ; i++){
            if(str[i].contains("x")){
            	try {
            	String s = str[i].replace("x","");
            	if(s.equals(""))
            		tmp = 1;
            	else
            		tmp = Integer.parseInt(s);
            	}
            	catch(NumberFormatException e){
            		
            	}
                x += Integer.valueOf(tmp);
                
            }
            else if(str[i].equals("+")) {
            	continue;
            }
            else {
            	inde += Integer.valueOf(str[i]);
            }            	
        }
        
        if(x == 1)            
            answer = "x";
        else if(x != 0) {
            answer = String.valueOf(x)+"x";
        }
        
        if(inde != 0) {
        	if(x != 0)
        		answer = answer + " + ";
            answer = answer + String.valueOf(inde);
        }
        return answer;
    }
}