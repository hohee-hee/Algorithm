import java.io.*;
import java.util.*;

public class Main {
    private static final int INF = 100_000_000;
        
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] adj = new ArrayList[V+1];
        for(int i = 0 ; i < V+1 ; i++) adj[i] = new ArrayList<int[]>();

        for(int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v,w});
        }

        // 다익스트라
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.add(new int[]{K, dist[K]});

        while(!pq.isEmpty()) {
            int n = pq.peek()[0];
            int w = pq.poll()[1];

            for(int i = 0 ; i < adj[n].size() ; i++) {
                int next = adj[n].get(i)[0];
                int weight = adj[n].get(i)[1] + dist[n];

                if(dist[next] < weight) continue;
                if(dist[next] > weight) {
                    dist[next] = weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }

        }

        for(int i = 1; i < V + 1 ; i++) {
            if(dist[i] == INF) sb.append("INF");
            else sb.append(dist[i]);
            
            if(i != V) sb.append("\n");
        }
        System.out.println(sb);
    }
}
