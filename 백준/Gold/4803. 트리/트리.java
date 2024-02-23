import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] isVisited;
    public static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;
        test: while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            graph = new ArrayList[N+1];
            for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();
            for(int i = 0 ; i < M ; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            int T = 0;
            isVisited = new boolean[N+1];
            for(int i = 1 ; i <= N ; i++) {
                if(isVisited[i]) continue;

                if(!dfs(N, i)) T++;
            }

            sb.append("Case ").append(tc).append(": ");
            if(T > 1) sb.append("A forest of ").append(T).append(" trees.");
            else if(T == 1)  sb.append("There is one tree.");
            else sb.append("No trees.");
            sb.append("\n");
            tc++;
        }

        System.out.println(sb);
    }

    public static boolean dfs(int N, int start) {
        boolean isCycled = false;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(start);
        while(!stack.isEmpty()) {
            int cn = stack.pollFirst();
            isVisited[cn] = true;
            for(int i = 0 ; i < graph[cn].size() ; i++) {
                int nn = graph[cn].get(i);
                if(isVisited[nn]) continue;
                if(stack.contains(nn)) isCycled = true;
                stack.offerFirst(nn);
            }
        }
        return isCycled;
    }
}
