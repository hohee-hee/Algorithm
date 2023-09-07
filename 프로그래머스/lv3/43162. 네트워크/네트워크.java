import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 1. 사용할 자료구조 할당
        HashSet<Integer> hs = new HashSet<>(); // 방문 여부를 확인할 hashset
        for(int i = 0 ; i < n ; i++) hs.add(i);
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0 ; i < n ; i++) graph[i] = new ArrayList<Integer>();
    
        // 2. 그래프에 값 넣기
        for(int r = 0 ; r < n ; r++){
            for(int c = 0 ; c < n ; c++){
                if(r == c) continue;
                
                if(computers[r][c] == 1) graph[r].add(c);
            }
        }
        
        // 3. 탐색하기
        
        int com = 0;
        
        while(!hs.isEmpty()){
            hs.remove(com);
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.offerLast(com);
            
            while(!queue.isEmpty()) {
                int curr = queue.pollLast();
                
                for(int i = 0 ; i < graph[curr].size() ; i++) {
                    if(hs.contains(graph[curr].get(i))) {
                        queue.offerLast(graph[curr].get(i));
                        hs.remove(graph[curr].get(i));
                    }
                }
            }
            
            answer++;
            
                
            if(!hs.isEmpty()) {
              ArrayList<Integer> temp = new ArrayList<>(hs);
              com = temp.get(0);                    
            }
            
        }
        
        return answer;
    }
}