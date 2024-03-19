import java.util.*;
import java.io.*;

public class Main{
    public static class Result{
        int num;
        boolean isAncestor;

        Result(int num, boolean isAncestor) {
            this.num = num;
            this.isAncestor = isAncestor;
        }
    }
    public static ArrayList<Integer>[] node;
    public static int[] parent, depth;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        node = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) node[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 1 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            node[A].add(B);
            node[B].add(A);
        }

        parent = new int[N+1];
        depth = new int[N+1];
        parent[1] = -1;
        depth[1] = 1;
        makeTree(1);

        int M = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < M ; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            while(depth[A] != depth[B]){
                if(depth[A] > depth[B]) A = parent[A];
                else B = parent[B];
            }

            while(A != B) {
                A = parent[A];
                B = parent[B];
            }

            sb.append(A).append("\n");
        }


        System.out.println(sb);
    }

    public static void makeTree(int curr) {
        if(node[curr].isEmpty()) return;

        for(int target : node[curr]) {
            if(parent[target] != 0) continue;
            parent[target] = curr;
            depth[target] = depth[curr] + 1;
            makeTree(target);
        }
    }
}