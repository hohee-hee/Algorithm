import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i = 1 ; i < N+1 ; i++) parent[i] = i;

        for(int i = 1 ; i < N+1 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j < N+1 ; j++){
                int type = Integer.parseInt(st.nextToken());
                if(type == 0) continue;
                else union(i,j);
            }
        }

        boolean flag = true;
        String[] cities = br.readLine().split(" ");
        for(int i = 0 ; i < M-1 ; i++){
            int cityA = Integer.parseInt(cities[i]);
            int cityB = Integer.parseInt(cities[i+1]);

            if(find(cityA) != find(cityB)){
                flag = false;
                break;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
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
