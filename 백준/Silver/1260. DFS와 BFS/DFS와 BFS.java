import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int N, M, V;
    public static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<Integer>();

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1 ; i <= N ; i++) Collections.sort(graph[i]);


        // dfs
        boolean[] isVisited = new boolean[N+1];
        DFS(isVisited, V);
        sb.append("\n");
        // bfs
        isVisited = new boolean[N+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offerLast(V);
        isVisited[V] = true;
        sb.append(V).append(" ");
        while(!q.isEmpty()) {
            int cn = q.pollFirst();
            for(int i = 0 ; i < graph[cn].size() ; i++) {
                int tn = graph[cn].get(i);
                if(isVisited[tn]) continue;

                q.offerLast(tn);
                isVisited[tn] = true;
                sb.append(tn).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static void DFS(boolean[] isVisited, int cn){
        if(isVisited[cn]) {
            return;
        }

        isVisited[cn] = true;
        sb.append(cn).append(" ");
        for(int i = 0 ; i < graph[cn].size() ; i++) {
            int tn = graph[cn].get(i);
            DFS(isVisited, tn);
        }
    }

}