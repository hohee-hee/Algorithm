class Solution {
    
    	public double slope(int[] dot1, int[] dot2) {
			double d = (double) Math.abs(dot1[1] - dot2[1]) / Math.abs(dot1[0] - dot2[0]);
			return d;
		}
		
		public int solution(int[][] dots) {
			int answer = 0 ;
			if(slope(dots[0],dots[1]) == slope(dots[2],dots[3]))
				return answer = 1;
			else if(slope(dots[0],dots[2]) == slope(dots[1], dots[3]))
				return answer = 1;
			else if(slope(dots[0],dots[3]) == slope(dots[1], dots[2]))
				return answer = 1;
            return answer;
			
		}
//     public int solution(int[][] dots) {
//         int answer = 0;
        
//         double dr1 = Math.abs(dots[0][1] - dots[1][1]) / Math.abs(dots[0][0] - dots[1][0]);
//         double dr2 = Math.abs(dots[3][0] - dots[2][0]) / Math.abs(dots[3][1] - dots[2][1]);
//         if(dr1 == dr2) {
//         	return answer = 1;
//         }
        
//         dr1 = Math.abs(dots[0][0] - dots[2][0]) / Math.abs(dots[0][1] - dots[2][1]);
//         dr2 = Math.abs(dots[3][0] - dots[1][0]) / Math.abs(dots[3][1] - dots[1][1]);
//         if(dr1 == dr2){ 
//            return answer = 1;
//         }
      
//         dr1 = Math.abs(dots[0][0] - dots[3][0]) + Math.abs(dots[0][1] - dots[3][1]);
//         dr2 = Math.abs(dots[2][0] - dots[1][0]) + Math.abs(dots[2][1] - dots[1][1]);
//         if(dr1 == dr2){
//         	return answer = 1;
//         }
//         return answer;
//     }
}