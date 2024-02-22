import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] toSmall = new ArrayList[N+1];
        ArrayList<Integer>[] toBig = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++) {
            toSmall[i] = new ArrayList<>();
            toBig[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            toSmall[u].add(v);
            toBig[v].add(u);
        }

        int[] small = new int[N+1];
        int[] big = new int[N+1];
        for(int i = 1 ; i <= N ; i++) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offerLast(i);
            boolean[] isVisited = new boolean[N+1];
            isVisited[i] = true;
            while(!q.isEmpty()) {
                int cn = q.pollFirst();
                for(int j = 0 ; j < toSmall[cn].size() ; j++) {
                    int nn = toSmall[cn].get(j);
                    if(isVisited[nn]) continue;

                    isVisited[nn] = true;
                    q.offerLast(nn);
                    small[i]++;
                }
            }

            q.offerLast(i);
            isVisited = new boolean[N+1];
            isVisited[i] = true;

            while(!q.isEmpty()) {
                int cn = q.pollFirst();
                for(int j = 0 ; j < toBig[cn].size() ; j++) {
                    int nn = toBig[cn].get(j);
                    if(isVisited[nn]) continue;
                    isVisited[nn] = true;
                    q.offerLast(nn);
                    big[i]++;
                }
            }
        }


        int answer = 0;
        int mid = (N+1)/2;
        for(int i = 1 ; i <= N ; i++) {
            if(big[i] >= mid || small[i] >= mid) answer++;
        }


        System.out.println(answer);
    }
}
