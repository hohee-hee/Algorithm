import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        
        int T = Integer.parseInt(br.readLine());
        
        outer: for(int tc = 0 ; tc < T ; tc++) {
        	// 1. 입력 받기
        	String command = br.readLine();
        	int N = Integer.parseInt(br.readLine());
        	String list = br.readLine();
        	
        	String[] nums  = list.substring(1, list.length()-1).split(",");        	
        	
        	// 2. 입력받은 숫자를 덱에 넣기
        	ArrayDeque<Integer> dq = new ArrayDeque<>();
        	for(int i = 0 ; i < N ; i++){
        		dq.offerLast(Integer.parseInt(nums[i]));
        	}
        	
        	boolean dir = true; // true : pollFirst, false: pollLast
        	
        	// 3. 명령어 수행하기
        	for(int i = 0 ; i < command.length() ; i++) {
        		if(command.charAt(i) == 'R') {
        			dir = !dir;
        		} else if (dq.isEmpty()) { 
        			sb.append("error\n");
        			continue outer;
        		} else if (dir) {
        			dq.pollFirst();
        		} else {
        			dq.pollLast();
        		}
        	}
        	
        	int[] ac = new int[dq.size()];
        	if(!dir) {
        		for(int i = 0 ; i < ac.length ; i++) {
        			ac[i] = dq.pollLast();
        		}
        	} else {
        		for(int i = 0 ; i < ac.length ; i++) {
        			ac[i] = dq.pollFirst();
        		}        		
        	}
        	
        	sb.append("[");
        	for(int i = 0 ; i < ac.length ; i ++) {
        		sb.append(ac[i]);
        		if(i != ac.length - 1) {
        			sb.append(",");
        		}
        	}
        	sb.append("]\n");
        	
        }
        
		System.out.println(sb);
	}
}
