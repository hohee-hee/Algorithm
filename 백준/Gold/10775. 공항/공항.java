import java.util.*;
import java.io.*;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G+1];
        for(int i = 1 ; i <= G ; i++) parent[i] = i;
        int answer = 0;
        boolean isDocked = false;
        for (int i = 0; i < P; i++) {
            int plain = Integer.parseInt(br.readLine());
            int gate = find(plain);
            if(gate == 0) break;
            answer++;
            union(gate, gate-1);
        }

        System.out.println(answer);
    }

    public static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if(fx != fy) parent[fx] = fy;
    }
}
