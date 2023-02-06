import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	
    	Set<String> hs = new HashSet<>(); //듣도 못한 사람을 넣을 해시맵
    	for(int i = 0 ; i < N ; i++) { hs.add(br.readLine()); }    	//입력받기
    	
    	ArrayList<String> list = new ArrayList<>(); //듣도 보도 못한 사람을 넣을 리스트
    	
    	/*
    	 * M개의 이름을 모두 hs에 동일한 문자열이 포함되어 있는지를 확인한다.
    	 * 만약 포함되어있으면 list에 저장
    	 */
    	for(int i = 0 ; i < M ; i++) {
    		String str = br.readLine();
    		if(hs.contains(str)) { 
    			list.add(str);
    		}
    	}
    	
    	//사전순으로 만들기 위해 list를 정렬
    	Collections.sort(list);
    	
    	//리스트의 크기를 출력하고 각 항목을 돌며 출력
    	System.out.println(list.size());
    	for(int i = 0 ; i < list.size() ; i++) {
    		System.out.println(list.get(i));
    	}
    }   
}
