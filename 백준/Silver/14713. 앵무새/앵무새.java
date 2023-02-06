import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
    	int N = Integer.parseInt(br.readLine());
    	ArrayList<Queue<String>> msg = new ArrayList<>();//앵무새 N마리의 말을 각각 담아놓을 어레이리스트
    	for(int i = 0 ; i < N ; i++) {
    		String str = br.readLine();
    		String[] tmp = str.split(" ");
    		Queue<String> parrot = new LinkedList<>(); //앵무새가 하는 말을 단어 단위로 끊어서 담을 큐
    		for(int j = 0 ; j < tmp.length ; j++) {
    			parrot.offer(tmp[j]);
    		}
    		//한 앵무새가 말한 내용을 담으면 그 큐를 어레이리스트에 저장
    		msg.add(parrot);
    	}
    	

    	String cseteram = br.readLine(); //필기한 문장
    	String[] words = cseteram.split(" "); //필기한 문장을 단어 단위로 나눠서 저장
    	
    	/*
    	 * words의 길이만큼 반복하며 각 인덱스에 방문
    	 * 그 다음 해시테이블의 각 키에 방문하면서
    	 * value값에 있는 큐의 맨 앞의 값이 words[i]와 같은지 확인
    	 * 같은 값을 찾았다면 flag를 true로 바꾸고 해당 반복문을 종료시킨다.
    	 * 그러나 words[i]와 같지 않다면 flag는 여전히 false
    	 * 한 단어라도 flase가 나온다면 불가능한 문장이므로 전체 반복문을 종료하고 출력 부분으로 이동
    	 */
    	
		boolean flag = false; //value에 있는 queue.peek()이 words[i]와 동일한지 확인하는 불리안 변수
		//루프문
		for(int i = 0 ; i < words.length ; i++){	
			flag = false; //words의 새 항목에 들어갈 때마다 false로 초기화
			//해시테이블의 value에 방문
			for(int j = 0 ; j < N ; j++) {		
				//만약 value의 큐가 비어있지 않고 큐의 peek값이 words[i]와 같다면
				//먼저 큐에서 맨 앞을 빼내고 flag를 true로 변경 후 해당 반복문 종료
				if(!msg.get(j).isEmpty()&& words[i].equals(msg.get(j).peek())) {
					msg.get(j).poll();
					flag = true;
					break;
				}
			}
			//flag가 true로 바뀌지 않았다면 불가능한 문장이므로 전체 반복문 종료
			if(!flag) {
				break;	
			}
		}
		
		
		//cseteram이 적은 단어가 앵무새가 말한 단어보다 적은 경우
		//msg의 queue에 여전히 단어가 남아있다.
		//이 단어가 남아있는 케이스도 불가능한 경우이므로 false로 변경해준다.
		for(int i = 0 ; i < N ; i++) {
			if(!msg.get(i).isEmpty()) { 
				flag = false; 
			}
		}

		
		//만약 마지막 words의 요소까지 조건에 맞았다면 현재 flag는 true이다.
		//만약 반복문이 flag가 false여서 중단되었다면 여전히 false이다.
		//따라서 flag가 true이면 Possible을,
		//아니면 Impossible을 출력
		if(flag) {
			System.out.println("Possible");
		}
		else{
			System.out.println("Impossible");
		}
    	
    }   
    
}
