import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> truth = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < T ; i++) truth.add(Integer.parseInt(st.nextToken()));

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) graph[i] = new ArrayList<>();

        ArrayList<Integer>[] party = new ArrayList[M];
        for(int i = 0 ; i < M ; i++) party[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());

            for(int j = 0 ; j < P ; j++) party[i].add(Integer.parseInt(st.nextToken()));

            for(int j = 0 ; j < P; j++) {
                for(int k = 0 ; k < P ; k++) {
                    if(k == j) continue;
                    graph[party[i].get(j)].add(party[i].get(k));
                }
            }

        }

        for(int i = 1 ; i <= N ; i++) {
            if(!truth.contains(i)) continue;

            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offerLast(i);
            boolean[] isVisited = new boolean[N+1];
            isVisited[i] = true;
            while(!q.isEmpty()) {
                int cn = q.pollFirst();
                for(int j = 0 ; j < graph[cn].size() ; j++) {
                    int nn = graph[cn].get(j);
                    if(isVisited[nn]) continue;
                    truth.add(nn);
                    isVisited[nn] = true;
                    q.offerLast(nn);
                }
            }
        }


        int answer = 0;
        find: for(int i = 0 ; i < M ; i++) {
            for(int j = 0 ; j < party[i].size(); j++) {
                if(truth.contains(party[i].get(j))) continue find;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
