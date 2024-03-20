
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
    public static int[] depth;
    public static int[][] parent;

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

        depth = new int[N+1];
        parent = new int[N+1][log2(N)];
        parent[1][0] = -1;
        depth[1] = 1;
        makeTree(1);

        int M = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < M ; tc++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(LCA(A, B)).append("\n");
        }

        System.out.println(sb);
    }

    public static void makeTree(int curr) {
        if(node[curr].isEmpty()) return;

        for(int target : node[curr]) {
            if(parent[target][0] != 0) continue;
            parent[target][0] = curr;
            depth[target] = depth[curr] + 1;

            int pt = 0;
            while(pt < parent[0].length - 1 && parent[target][pt] > 1) {
                pt++;
                parent[target][pt] = parent[parent[target][pt-1]][pt-1];
            }
            makeTree(target);
        }
    }

    public static int LCA(int A, int B){

        // 1. 높이 맞추기
        int diff = depth[A] - depth[B];
        if(diff < 0) {
            while(diff < 0) {
                B = parent[B][log2(-diff) - 1];
                diff = diff + pow(log2(-diff) - 1);
            }
        } else if(diff > 0) {
            while(diff > 0) {
                A = parent[A][log2(diff) - 1];
                diff = diff - pow(log2(diff) - 1);
            }
        }

        // 2. 공통부모 찾기
        if(A == B) return A;

        int pt = parent[1].length-1;
        while(pt >= 0) {
            if(parent[A][pt] == parent[B][pt]) {
                pt--;
                continue;
            }

            A = parent[A][pt];
            B = parent[B][pt];
        }

        return parent[A][0];
    }

    public static int log2(int N){
        int i = 1;
        while(N > 1) {
            N /= 2;
            i++;
        }
        return i;
    }

    public static int pow(int N) {
        int re = 1;
        while(N > 0){
            re *= 2;
            N--;
        }
        return re;
    }
}