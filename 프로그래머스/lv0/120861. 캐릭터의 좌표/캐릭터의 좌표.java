class Solution {
    public int[] solution(String[] keyinput, int[] board) { 
        int[] answer = new int[2];
        //board[r][c];
        int nr = 0;
        int nc = 0;
        for(int i = 0 ; i < keyinput.length ; i++){
            switch(keyinput[i]){
            case "left":
            	nc = 0;
            	nr = -1;
            	break;
            case "right":
            	nc = 0;
            	nr = 1;
            	break;
            case "up":
            	nr = 0;
                nc = 1;
            	break;
            case "down":
            	nr = 0;
            	nc = -1;
            	break;
            }
            if(Math.abs(answer[0]+nr) <= board[0]/2 && Math.abs(answer[1]+nc) <= board[1]/2) {            	
            	answer[0] += nr;
            	answer[1] += nc;
            }
        }
        return answer;
    }
}