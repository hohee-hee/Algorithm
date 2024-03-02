import java.io.*;
import java.util.*;

public class Main {
    public static final int INF = 1000002;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            graph[A].add(new int[]{B, T});
        }

        int[][] dist = new int[N+1][N+1];
        for(int r = 1 ; r <= N ; r++) {
            for(int c = 1; c <= N ; c++) {
                if(r == c) dist[r][c] = 0;
                else dist[r][c] = INF;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(int stu = 1 ; stu <= N ; stu++) {
            pq.offer(new int[]{stu, 0});

            while(!pq.isEmpty()) {
                int cn = pq.peek()[0];
                int cd = pq.poll()[1];

                for(int i = 0 ; i < graph[cn].size() ; i++) {
                    int nn = graph[cn].get(i)[0];
                    int nd = graph[cn].get(i)[1] + cd;

                    if(dist[stu][nn] > nd) {
                        dist[stu][nn] = nd;
                        pq.offer(new int[]{nn, nd});
                    }
                }
            }
        }

        int answer = 0;
        for(int stu = 1 ; stu <= N ; stu++) {
            int total = dist[stu][X] + dist[X][stu];
            if(total > answer) answer = total;
        }

        System.out.println(answer);
    }
}

