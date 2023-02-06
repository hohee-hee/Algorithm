import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
    	int N = Integer.parseInt(br.readLine());
    	Queue<Integer> q = new LinkedList<>();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0 ; i < N ; i++) {
    		q.offer(Integer.parseInt(st.nextToken()));
    	}
    	
    	Stack<Integer> waiting = new Stack<>(); //대기열 스택
    	
    	outer : for(int i = 1 ; i <= N ; i++) {
    		while(true) {
    			if(!q.isEmpty() && q.peek() == i) {
    				q.poll();
    				break;
    			}
    			else if(!waiting.isEmpty() && waiting.peek() == i){
    				waiting.pop();
    				break;
    			}
    			else if(q.isEmpty() && !waiting.isEmpty()) {
    				if(waiting.peek() == i) {
    					waiting.pop();
    					break;
    				}
    				else {
    					break outer;
    				}	
    			}
    			else {
    				waiting.push(q.poll());
    			}
    		}
    	}
    	
    	if(q.isEmpty() && waiting.isEmpty())
    		System.out.println("Nice");
    	else
    		System.out.println("Sad");
    }   
    
}
