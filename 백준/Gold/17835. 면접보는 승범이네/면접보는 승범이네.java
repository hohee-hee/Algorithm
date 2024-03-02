import java.io.*;
import java.util.*;

public class Main {
    public static final long INF = 500000000002L;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[V].add(new int[]{U, C}); // 반대로 저장하기
        }

        long[] dist = new long[N+1];
        for(int i = 1 ; i <= N ; i++) dist[i] = INF;

        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if(o1[1] > o2[1]) return 1;
                return -1;
            }
        });

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K ; i++) {
            int spot = Integer.parseInt(st.nextToken());
            dist[spot] = 0;
            pq.offer(new long[]{spot, 0});
        }

        while(!pq.isEmpty()) {
            int cn = (int)(pq.peek()[0]);
            long cd = pq.poll()[1];

            if(cd > dist[cn]) continue;

            for(int i = 0 ; i < graph[cn].size() ; i++) {
                int nn = graph[cn].get(i)[0];
                long nd = graph[cn].get(i)[1] + cd;

                if(dist[nn] > nd) {
                    dist[nn] = nd;
                    pq.offer(new long[]{nn, nd});
                }
            }
        }

        int city = 0;
        long max = 0;
        for(int i = 1 ; i <= N ; i++) {
            if(max < dist[i]) {
                city = i;
                max = dist[i];
            }
        }
        sb.append(city).append("\n").append(max);
        System.out.println(sb);
    }
}

