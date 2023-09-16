import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] adj = new ArrayList[N+1];
        for(int i = 0 ; i < N+1 ; i++) adj[i] = new ArrayList<int[]>();

        for(int i = 0 ; i < M ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new int[]{v,w});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int[] route = new int[N+1];
        route[start] = -1;
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.offer(new int[]{start, 0});

        outer : while(!pq.isEmpty()) {
            int cn = pq.peek()[0];
            int cw = pq.poll()[1];

            if(dist[cn] < cw) continue;

            for(int i = 0 ; i < adj[cn].size() ; i++) {
                int nn = adj[cn].get(i)[0];
                int nw = cw + adj[cn].get(i)[1];

                if(dist[nn] <= nw) continue;

                pq.offer(new int[]{nn, nw});
                dist[nn] = nw;
                route[nn] = cn;
            }
        }

        sb.append(dist[end]).append("\n");

        ArrayList<Integer> visit = new ArrayList<>();

        int curr = end;
        visit.add(curr);
        while(curr != start) {
            int next = route[curr];
            curr = next;
            visit.add(curr);
        }

        sb.append(visit.size()).append("\n");

        for(int i = visit.size() - 1 ; i >= 0 ; i--) sb.append(visit.get(i) + " ");

        System.out.println(sb);
    }
}
