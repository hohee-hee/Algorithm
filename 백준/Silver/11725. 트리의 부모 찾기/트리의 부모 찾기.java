import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i = 1 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] parent = new int[N+1];
        Arrays.fill(parent, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offerLast(1);
        while(!q.isEmpty()){
            int cn = q.pollFirst();
            for(int i = 0 ; i < graph[cn].size() ; i++) {
                int nn = graph[cn].get(i);
                if(parent[nn] != -1) continue;

                parent[nn] = cn;
                if(graph[cn].isEmpty()) continue;
                q.offerLast(nn);
            }
        }

        for(int i = 2 ; i <= N ; i++) sb.append(parent[i]).append("\n");
        System.out.println(sb);
    }
}
