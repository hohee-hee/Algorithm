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

        int max = 0;
        int min = 0;

        PriorityQueue<int[]> asc = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        PriorityQueue<int[]> desc = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        for(int i = 0 ; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(A == 0 || B == 0) {
                if(C == 1) {
                    min = 1; max = 1;
                }
                continue;
            }

            int[] pair = {A, B, C};
            asc.offer(pair);
            desc.offer(pair);
        }

        int E = 0;

        // 최소
        initialize(N);
        while(!desc.isEmpty() && E < N-1) {
            int u = desc.peek()[0];
            int v = desc.peek()[1];
            int c = desc.poll()[2];

            if(!union(u,v)) continue;
            min += c;
            E++;
        }

        // 최대
        E = 0;
        initialize(N);
        while(!asc.isEmpty() && E < N-1) {
            int u = asc.peek()[0];
            int v = asc.peek()[1];
            int c = asc.poll()[2];

            if(!union(u,v)) continue;
            max += c;
            E++;
        }

        System.out.println((N-max)*(N-max)-(N-min)*(N-min));
    }

    public static void initialize(int N){
        rank = new int[N+1];
        parent = new int[N+1];
        for(int i = 1 ; i <= N ; i++) parent[i] = i;
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

