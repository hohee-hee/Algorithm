import java.util.*;
import java.io.*;

public class Main{
    public static boolean[] isVisited;
    public static ArrayList<int[]>[] tree;
    public static int answer = 0;
    public static int target = 0;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        isVisited = new boolean[V+1];

        tree = new ArrayList[V+1];
        for(int i = 1 ; i <= V ; i++) tree[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0 ; i < V ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            while(next != -1) {
                tree[start].add(new int[]{next, Integer.parseInt(st.nextToken())});
                next = Integer.parseInt(st.nextToken());
            }
        }

        isVisited[1] = true;
        dfs(1, 1, 0);

        answer = 0;
        isVisited[target] = false;
        dfs(target, target, 0);
        System.out.println(answer);
    }

    public static void dfs(int root, int cn, int cd) {
        for(int[] nextInfo : tree[cn]) {
            if(isVisited[nextInfo[0]] == isVisited[root]) continue;
            isVisited[nextInfo[0]] = !isVisited[nextInfo[0]];
            int nd = cd + nextInfo[1];
            if(nd > answer) {
                answer = nd;
                target = nextInfo[0];
            }
            dfs(root, nextInfo[0], nd);
        }
    }
}