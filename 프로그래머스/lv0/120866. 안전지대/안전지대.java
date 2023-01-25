class Solution {
    public int solution(int[][] board) {
        //상하좌우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int answer = board.length * board.length;
        
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j <board.length ; j++) {
            	outer : if(board[i][j] == 0) {
	            	for(int k = 0 ; k < 4 ; k++) {
	            		int nr = i + dr[k];
	            		int nc = j + dc[k];
	            		if(nr >= 0 && nr < board.length && nc >=0 && nc < board.length) {
	            			if(board[nr][nc] == 1) {
	            				answer--;
	            				break outer;              				
	            			}          			
	            		}	            		
	            	}
	            	for(int k = 0; k < 2 ; k++) {
	            		int nr = i + dr[k];
	            		int nc = j + dc[2];
	            		if(nr >= 0 && nr < board.length && nc >=0 && nc < board.length) {
	            			if(board[nr][nc] == 1) {
	            				answer--;
	            				break outer;              				
	            			}          			
	            		}
	            		nr = i + dr[k];
	            		nc = j + dc[3];
	            		if(nr >= 0 && nr < board.length && nc >=0 && nc < board.length) {
	            			if(board[nr][nc] == 1) {
	            				answer--;
	            				break outer;              				
	            			}          			
	            		}
	            	}
            	}
            	else{
            		answer--;
                }
            }
        }
        return answer;
    }
}