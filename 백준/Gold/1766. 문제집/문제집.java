import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();
        int[] indegree = new int[N+1];
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            indegree[B]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 1 ; i <= N ; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()) {
            int cp = q.poll();
            answer.add(cp);

            for(int np: graph[cp]){
                indegree[np]--;
                if(indegree[np] == 0) q.offer(np);
            }
        }

        for(int problem: answer) sb.append(problem).append(" ");

        System.out.println(sb);
    }
}
