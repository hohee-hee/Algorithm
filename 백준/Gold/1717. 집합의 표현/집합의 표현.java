import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 0 ; i < n+1 ; i++) parent[i] = i;

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(type == 0){
                union(a, b);
            } else {
                if(find(a) == find(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }

    public static int find(int x){
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }


    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return;
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }


}
