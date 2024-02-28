import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent, root, rank;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        
        for(int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{A,B,C});
        }


        root = new int[V+1];
        rank = new int[V+1];
        for(int i = 1 ; i <= V ; i++) root[i] = i;
        int answer = 0;
        while(!pq.isEmpty()) {
            int u = pq.peek()[0];
            int v = pq.peek()[1];
            int w = pq.poll()[2];

            boolean isUnited = union(u, v);
            if(isUnited) answer += w;
        }

        System.out.println(answer);
    }

    public static int find(int x){
        if(root[x] == x) return x;
        else return root[x] = find(root[x]);
    }

    public static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) return false;

        if(rank[rootX] < rank[rootY]) root[rootX] = rootY;
        else root[rootY] = rootX;

        if(rank[rootX] == rank[rootY]) rank[rootX]++;
        return true;
    }
}
