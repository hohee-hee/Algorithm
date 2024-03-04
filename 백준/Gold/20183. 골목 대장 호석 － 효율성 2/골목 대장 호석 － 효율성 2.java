import java.io.*;
import java.util.*;

public class Main {
    public static final long INF = 500_000_000_000_002L;
    public static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v,w});
            graph[v].add(new int[]{u,w});
            start = Math.min(start, w);
            end = Math.max(end, w);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[2] == o2[2]) {
                    if(o1[1] > o2[1]) return 1;
                    return -1;
                }

                if(o1[2] > o2[2]) return 1;
                return -1;
            }
        });
        if(!dijkstra(N, A, B, C, pq, INF)) {
            System.out.println(-1);
            return;
        }

        // 이분탐색 -> 다익
        int answer = end;
        while(start <= end) {
            pq.clear();
            int mid = (start+end) / 2;
            if(dijkstra(N, A, B, C, pq, mid)){
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean dijkstra(int N, int depart, int arrival, long limit, PriorityQueue<long[]> pq, long maxCost){
        boolean[] isVisited = new boolean[N+1];
        long[] dist = new long[N+1];
        for(int i = 1 ; i <= N ; i++) dist[i] = INF;

        pq.offer(new long[]{depart, 0, 0});
        dist[depart] = 0;
        isVisited[depart] = true;

        loop: while(!pq.isEmpty()) {
            int cn = (int) pq.peek()[0];
            long cc = pq.peek()[1];
            long cm = pq.poll()[2];
            if(cc > dist[cn]) continue;

            for(int i = 0 ; i < graph[cn].size() ; i++) {
                int nn = graph[cn].get(i)[0];
                long nc = graph[cn].get(i)[1];
                long nm = Math.max(nc, cm);

                if(isVisited[nn]) continue;
                if(nm > maxCost) continue;
                if(dist[nn] < nc + cc || nc + cc > limit) continue;

                dist[nn] = nc+cc;
                isVisited[nn] = true;
                pq.offer(new long[]{nn, nc+cc, nm});
            }
        }

        if(dist[arrival] > limit || dist[arrival] == INF) return false;
        return true;
    }
}

