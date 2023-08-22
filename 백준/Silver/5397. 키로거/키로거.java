import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 1. 입력 받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 0 ; tc < T ; tc++) {
        	String log = br.readLine();
        	ArrayDeque<Character> preStack = new ArrayDeque<>();
        	ArrayDeque<Character> postStack = new ArrayDeque<>();
        	for(int i = 0 ; i < log.length() ; i++) {        		
        		if(log.charAt(i) == '-') {
        			if(preStack.isEmpty()) continue;
        			preStack.pollLast();
        		}
        		else if(log.charAt(i) == '<') {
        			if(preStack.isEmpty()) continue;
        			postStack.offerLast(preStack.pollLast());
        		}
        		else if(log.charAt(i) == '>') {
        			if(postStack.isEmpty()) continue;
        			preStack.offerLast(postStack.pollLast());
        		}
        		else {
        			preStack.offerLast(log.charAt(i));
        		}
        	}
        	
        	while(!preStack.isEmpty()) {
        		sb.append(preStack.pollFirst());
        	}
        	while(!postStack.isEmpty()) {
        		sb.append(postStack.pollLast());
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
		
	}
}
