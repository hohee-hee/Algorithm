import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String args[]) throws IOException
	    {
	        // 1. 입력 받기
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        String msg = br.readLine();
	        String keys = br.readLine();

	        // 2. 중복 되지 않게 리스트에 차례대로 넣기        
	        int cnt = 0;
	        boolean[] chk = new boolean[26]; // 중복 여부를 확인할 배열
	        chk[9] = true; // J
	        
	        ArrayDeque<Character> queue = new ArrayDeque<>(); // 알파벳을 저장할 리스트        
	        for(int i = 0 ; i < keys.length() ; i++){
	        	if(chk[keys.charAt(i) - 'A']) continue;
	        	queue.offerLast(keys.charAt(i));
	        	chk[keys.charAt(i) - 'A'] = true;
	        }  
	        
	        // 남은 자리에 A부터 넣기
	        int ascii = 64;	       
	        while(queue.size() < 25) {
	        	ascii++;
	        	if(chk[ascii - 65]) continue;
	        	queue.offerLast((char)ascii);
	        	chk[ascii - 65] = true;
	        }
	        

	        // 3. keyTable 만들면서 위치를 map에 저장하기
	        TreeMap<Character, int[]> loc = new TreeMap<>();
	        char[][] keyTable = new char[5][5];
	        for(int r = 0 ; r < 5 ; r++){
	            for(int c = 0 ; c < 5 ; c++){
	            	keyTable[r][c] = queue.peekFirst();	 
	            	loc.put(queue.pollFirst(), new int[] {r,c});
	            }
	        }
	        
	        // 4. 암호 계산하기
	        // (1) List에 msg 넣기
	        ArrayList<Character> msgChar = new ArrayList<>();
	        for(int i = 0 ; i < msg.length() ; i++) {
	        	msgChar.add(msg.charAt(i));
	        }
	        
	        // (2) 두 글자씩 계산하면서 X, Q넣기
	        int pt = 0;
	        while(pt < msgChar.size()) {
	        	if(pt == msgChar.size() - 1) {
	        		msgChar.add(pt+1,'X');
	        		break;
	        	}
	        	
	        	if(msgChar.get(pt) == msgChar.get(pt+1) && msgChar.get(pt) != 'X') {
	        		msgChar.add(pt+1, 'X');
	        	}
	        	else if(msgChar.get(pt) == msgChar.get(pt+1) && msgChar.get(pt) == 'X') {
	        		msgChar.add(pt+1, 'Q');
	        	}
	        	pt += 2;
	        }
	        
	        // (3) 암호 만들기
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0 ; i < msgChar.size() ; i += 2) {
	        	char ch1 = msgChar.get(i);
	        	char ch2 = msgChar.get(i+1);
	        	
	        	int ch1_r = loc.get(ch1)[0];
	        	int ch1_c = loc.get(ch1)[1];
	        	int ch2_r = loc.get(ch2)[0];
	        	int ch2_c = loc.get(ch2)[1];
	        	
	        	// 같은 행
	        	if(ch1_r == ch2_r) {
	        		sb.append(keyTable[ch1_r][(ch1_c+1) % 5]);
	        		sb.append(keyTable[ch2_r][(ch2_c+1) % 5]);
	        	}
	        	// 같은 열
	        	else if(ch1_c == ch2_c) {
	        		sb.append(keyTable[(ch1_r+1) % 5][ch1_c]);
	        		sb.append(keyTable[(ch2_r+1) % 5][ch2_c]);
	        	}
	        	// 둘 다 다를 때
	        	else {
	        		sb.append(keyTable[ch1_r][ch2_c]);
	        		sb.append(keyTable[ch2_r][ch1_c]);	        		
	        	}
	        	
	        }

	        System.out.println(sb);
	    }
}
