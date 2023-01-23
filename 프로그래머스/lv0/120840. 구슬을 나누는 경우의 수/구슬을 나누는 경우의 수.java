import java.math.*;

class Solution {
    public BigInteger solution(int balls, int share) {  
		BigInteger tmp = new BigInteger("1");
        BigInteger answer = new BigInteger("1");
        if(balls != share){
        	for(int i = 0 ; i < share ; i++) {
        		answer = answer.multiply(BigInteger.valueOf(balls));
        		balls--;
        	}
        	for(int i = share ; i > 0 ; i--) {
        		tmp = tmp.multiply(BigInteger.valueOf(i));
        	}
            answer = answer.divide(tmp);
        }
        return answer;
    }
}