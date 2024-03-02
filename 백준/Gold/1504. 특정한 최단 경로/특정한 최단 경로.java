import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = 200000002;
    public static ArrayList<int[]>[] graph;
    public static int type1, type2, N, v1, v2;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();
        for(int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        type1 = 0;
        type2 = 0;
        int[] dist;
        dist = dijkstra(1);
        type1 += dist[v1];
        type2 += dist[v2];

        dist = dijkstra(v1);
        type1 += dist[v2];
        type2 += dist[v2];

        dist = dijkstra(N);
        type1 += dist[v2];
        type2 += dist[v1];

        int answer = Math.min(type1, type2);
        if(answer >= INF) answer = -1;
        System.out.println(answer);
    }

    public static int[] dijkstra(int vst){
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        pq.offer(new int[]{vst, 0});
        dist[vst] = 0;

        while(!pq.isEmpty()) {
            int cn = pq.peek()[0];
            int cd = pq.poll()[1];
            for(int i = 0 ; i < graph[cn].size() ; i++) {
                int nn = graph[cn].get(i)[0];
                int nd = graph[cn].get(i)[1] + cd;

                if(dist[nn] > nd) {
                    dist[nn] = nd;
                    pq.offer(new int[]{nn, nd});
                }
            }
        }

        return dist;
    }
}

