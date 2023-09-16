import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        int answer = 0;

        boolean[] isVisited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if(isVisited[i]) continue;

            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offerLast(i);
            isVisited[i] = true;
            while (!q.isEmpty()) {
                int node = q.pollFirst();

                for(int j = 0 ; j < adj[node].size() ; j++) {
                    int next = adj[node].get(j);

                    if(isVisited[next]) continue;

                    isVisited[next] = true;
                    q.offerLast(next);
                }
            }

            answer++;
        }
        System.out.println(answer);
    }
}
