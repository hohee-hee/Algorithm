import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent;
    public static HashSet<Integer> YNY;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        YNY = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < K ; i++) YNY.add(Integer.parseInt(st.nextToken()));

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{u,v,w});
        }

        int answer = 0;
        parent = new int[N+1];
        for(int i = 1 ; i <=N ; i++) parent[i] = i;
        while(!pq.isEmpty()) {
            int u = pq.peek()[0];
            int v = pq.peek()[1];
            int w = pq.poll()[2];
            if(!union(u, v)) continue;
            answer += w;
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if(parent[x] == x || YNY.contains(parent[x])) return parent[x];
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(YNY.contains(x) && YNY.contains(y) || x == y) return false;

        if(YNY.contains(x)) parent[y] = parent[x];
        else parent[x] = parent[y];

        return true;
    }

}

