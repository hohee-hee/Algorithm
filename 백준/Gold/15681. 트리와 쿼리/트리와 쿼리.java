import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] isVisited;
    public static ArrayList<Integer>[] graph;
    public static int[] nodeCnt;
    public static int R;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();
        for(int i = 0 ; i < N-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }


        nodeCnt = new int[N+1];
        isVisited = new boolean[N+1];
        dfs(R);

        for(int i = 0 ; i < Q ; i++) {
            int U = Integer.parseInt(br.readLine());
            sb.append(nodeCnt[U]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int curr){
        isVisited[curr] = true;

        if(graph[curr].size() == 1 && curr != R) {
            nodeCnt[curr] = 1;
            return;
        }

        for(int i = 0 ; i < graph[curr].size() ; i++) {
            if(isVisited[graph[curr].get(i)]) continue;
            dfs(graph[curr].get(i));
            nodeCnt[curr] += nodeCnt[graph[curr].get(i)];
        }
        nodeCnt[curr]++;
    }
}
