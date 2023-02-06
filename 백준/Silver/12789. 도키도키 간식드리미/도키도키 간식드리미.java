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
    	Queue<Integer> q = new LinkedList<>(); //현재 줄 서있는 곳
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0 ; i < N ; i++) {
    		q.offer(Integer.parseInt(st.nextToken()));
    	}
    	
    	Stack<Integer> waiting = new Stack<>(); //대기열 (한 명씩만 설 수 있는 곳)
    	
    	outer : for(int i = 1 ; i <= N ; i++) {
    		while(true) {
    			//1. 
    			//만약 현재 줄 선 사람이 있고, 맨 앞에 사람이 현재 순서(i)와 같다면
    			//맨 앞사람을 큐에서 빼기 -> while문 중단하고 다음 순서로 넘어가기
    			if(!q.isEmpty() && q.peek() == i) { 
    				q.poll();
    				break;
    			}
    			//2. 
    			//만약 대기열에 사람이 있고 맨 앞에 서 있는 사람(마지막에 들어간 사람)이 현재 순서와 같다면    	
    			//맨 앞사람을 스택에서 빼기 -> while문 중단하고 다음 순서로 넘어가기
    			else if(!waiting.isEmpty() && waiting.peek() == i){
    				waiting.pop();
    				break;
    			}
    			//3.
    			//만약 현재 줄을 서 있는 사람은 없지만
    			//대기열에는 사람이 있을 때
    			else if(q.isEmpty() && !waiting.isEmpty()) {
    				//3-1.
    				//대기열 맨 앞사람의 순서가 i일때
    				//맨 앞 사람을 스택에서 빼기 -> while문 중단하고 다음 순서로 넘어가기
    				if(waiting.peek() == i) {
    					waiting.pop();
    					break;
    				}
    				//3-2.
    				//대기열 맨 앞 사람의 순서가 i가 아닐 때
    				//승환이가 간식을 받을 수 없으므로 for문 중단
    				else {
    					break outer;
    				}	
    			}
    			//4.
    			//큐와 스택의 맨 앞부분이 현재 순서는 아니지만 둘 다 비어있지 않으면
    			//큐의 맨 앞사람을 스택으로 이동하고 다시 탐색
    			else {
    				waiting.push(q.poll());
    			}
    		}
    	}
    	
    	//결국 큐와 스택 모두 비어 있을 때만 승환이가 간식을 받을 수 있다.
    	if(q.isEmpty() && waiting.isEmpty())
    		System.out.println("Nice");
    	else
    		System.out.println("Sad");
    }   
    
}
