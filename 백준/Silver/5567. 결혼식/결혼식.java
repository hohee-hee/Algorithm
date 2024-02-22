import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            graph[B].add(A);
        }

        int answer = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{1,0});

        boolean[] isVisited = new boolean[N+1];
        isVisited[1] = true;

        while(!q.isEmpty()){
            int cf = q.peekFirst()[0];
            int depth = q.pollFirst()[1];

            if(depth == 2) continue;

            for(int i = 0 ; i < graph[cf].size() ; i++) {
                int nf = graph[cf].get(i);

                if(isVisited[nf]) continue;

                q.offerLast(new int[]{nf, depth+1});
                isVisited[nf] = true;
                answer++;
            }
        }


        System.out.println(answer);
    }
}