import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] isChosen;
    public static int[][] ability;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ability = new int[N+1][N+1];
        for(int r = 1 ; r <= N ; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 1 ; c <= N ; c++) {
                ability[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        isChosen = new boolean[N + 1];
        bt(1, 0, N);

        if(answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }

    public static void bt(int curr, int cnt, int N){
        if(cnt == N/2) {
            int diff = calc(N);
            if(diff < answer) answer = diff;
            return;
        }

        for(int i = curr ; i < N+1 ; i++) {
            if(isChosen[i]) continue;

            isChosen[i] = true;
            bt(i+1, cnt+1, N);
            isChosen[i] = false;
        }
    }

    public static int calc(int N) {

        int startAbility = 0;
        int linkAbility = 0;
        for(int i = 1 ; i < N ; i++) {
            for(int j = i+1 ; j <= N ; j++) {
                if(isChosen[i] && isChosen[j]) startAbility += ability[i][j] + ability[j][i];
                else if(!isChosen[i] && !isChosen[j]) linkAbility += ability[i][j] + ability[j][i];
            }
        }

        int diff = Math.abs(startAbility - linkAbility);

        return diff;
    }
}