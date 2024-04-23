import java.io.*;
import java.util.*;

public class Main {
    public static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[M][3];
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph[i][0] = A;
            graph[i][1] = B;
            graph[i][2] = W;
        }

        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for(int i = 0 ; i <=  N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(dist[graph[j][0]] == INF) continue;

                if(dist[graph[j][1]] > dist[graph[j][0]] + graph[j][2]) {
                    dist[graph[j][1]] = dist[graph[j][0]] + graph[j][2];
                    if(i == N) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        for(int i = 2 ; i <= N ; i++) {
            if(dist[i] == INF) sb.append("-1").append("\n");
            else sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }
}