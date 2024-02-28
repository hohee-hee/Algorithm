import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent, rank;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] coordinate = new int[2][N+1];
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            coordinate[0][i] = X;
            coordinate[1][i] = Y;
        }

        int E = 0;
        rank = new int[N+1];
        parent = new int[N+1];
        for(int i = 1 ; i <= N ; i++) parent[i] = i;

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(union(u,v)) E++;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[2] - o2[2] < 0) return -1;
                return 1;
            }
        });

        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j < i ; j++) {
                if(parent[i] == parent[j]) continue;
                long width = coordinate[0][i] - coordinate[0][j];
                long height = coordinate[1][i] - coordinate[1][j];
                width *= width;
                height *= height;
                long cost = width+height;
                pq.offer(new long[]{i, j, cost});
            }
        }

        double answer = 0;
        while(!pq.isEmpty() && E < N-1) {
            int x = (int) pq.peek()[0];
            int y = (int) pq.peek()[1];
            long c = pq.poll()[2];

            if(!union(x, y)) continue;

            answer += Math.sqrt(c);
            E++;
        }
        System.out.println(String.format("%.2f", answer));

    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return false;

        if(rank[x] < rank[y]) parent[x] = y;
        else parent[y] = x;

        if(rank[x] == rank[y]) rank[x]++;
        return true;
    }

}

