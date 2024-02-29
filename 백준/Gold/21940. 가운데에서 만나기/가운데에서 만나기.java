import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N+1][N+1];
        for(int r = 1 ; r <= N ; r++) {
            for(int c = 1 ; c <= N ; c++) {
                if(r == c) dist[r][c] = 0;
                else dist[r][c] = 200002;
            }
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            dist[A][B] = Math.min(dist[A][B], T);
        }

        int K = Integer.parseInt(br.readLine());
        int[] cities = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K ; i++) cities[i] = Integer.parseInt(st.nextToken());

        for(int k = 1 ; k <= N ; k++) {
            for(int r = 1 ; r <= N ; r++) {
                for(int c = 1 ; c <= N ; c++) {
                    if(dist[r][c] > dist[r][k] + dist[k][c]) dist[r][c] = dist[r][k] + dist[k][c];
                }
            }
        }
        int[][] minOfmax = new int[N][2];
        for(int i = 1 ; i <= N ; i++) {
            int max = 0;
            for(int j = 0 ; j < K ; j++) {
                max = Math.max(max, dist[cities[j]][i] + dist[i][cities[j]]);
            }
            minOfmax[i-1][0] = i;
            minOfmax[i-1][1] = max;
        }


        Arrays.sort(minOfmax, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int min = minOfmax[0][1];
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(idx < N && min == minOfmax[idx][1]) {
            pq.offer(minOfmax[idx][0]);
            idx++;
        }
        while(!pq.isEmpty()) sb.append(pq.poll()).append(" ");
        System.out.println(sb);
    }
}

