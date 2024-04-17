import java.io.*;
import java.util.*;

public class Main {
    public static int[] selected;
    public static boolean[] isChosen;
    public static int[][] dist;
    public static int min;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++) {
            int N = Integer.parseInt(br.readLine());
            String[] map = new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i++) map[i] = st.nextToken();
            
            if(N > 32) {
                sb.append(0).append("\n");
                continue;
            }

            dist = new int[N][N];
            for(int i = 0 ; i < N ; i++) {
                String type1 = map[i];
                for(int j = 0 ; j <= i ; j++) {
                    if(i == j) {
                        dist[i][j] = -1;
                        continue;
                    }

                    String type2 = map[j];
                    int cd = 0;
                    for(int ch = 0 ; ch < 4 ; ch++) {
                        if(type1.charAt(ch) != type2.charAt(ch)) cd++;
                    }

                    dist[i][j] = dist[j][i] = cd;
                }
            }

            selected = new int[3];
            isChosen = new boolean[N];
            min = 12;

            bt(0,N,0);
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    public static void bt(int idx, int N, int cur){
        if(idx == 3) {
            int sum = dist[selected[0]][selected[1]] + dist[selected[1]][selected[2]] + dist[selected[2]][selected[0]];
            if(min > sum) min = sum;
            return;
        }

        for(int i = cur ; i < N ; i++) {
            if(isChosen[i]) continue;
            isChosen[i] = true;
            selected[idx] = i;
            bt(idx+1, N, cur+1);
            isChosen[i] = false;
            selected[idx] = -1;
        }
    }
}