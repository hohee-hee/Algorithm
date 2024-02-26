import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N+1];
        ArrayList<Integer>[] edges = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) edges[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            indegree[B]++;
            edges[A].add(B);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 1 ; i <= N ; i++) {
            if(indegree[i] == 0) q.offerLast(i);
        }

        while(!q.isEmpty()) {
            int cStu = q.pollFirst();
            sb.append(cStu).append(" ");

            for(int i = 0 ; i < edges[cStu].size() ; i++) {
                indegree[edges[cStu].get(i)]--;
                if(indegree[edges[cStu].get(i)] == 0) q.offerLast(edges[cStu].get(i));
            }
        }
        
        System.out.println(sb);
    }
}
