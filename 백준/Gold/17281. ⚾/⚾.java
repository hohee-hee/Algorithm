import java.util.*;
import java.io.*;

public class Main{
    public static int answer = 0;
    public static int N;
    public static int[] order = new int[10];
    public static int[][] res;
    public static boolean[] isUsed = new boolean[10];

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        res = new int[N+1][10];
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= 9 ; j++) {
                res[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[4] = 1;
        isUsed[1] = true;
        bt(1);

        System.out.println(answer);
    }

    public static void bt(int cnt){
        if(cnt == 4) {
            bt(cnt+1);
        } else if(cnt == 10) {
            int score = game();
            if(score > answer) answer = score;
            return;
        } else {
            for(int i = 1 ; i <= 9 ; i++) {
                if(isUsed[i]) continue;

                isUsed[i] = true;
                order[cnt] = i;

                bt(cnt + 1);

                isUsed[i] = false;
                order[cnt] = 0;
            }
        }
    }

    public static int game(){
        ArrayDeque<Integer> players = new ArrayDeque<>();
        for(int i = 1; i <= 9 ; i++) {
            players.offerLast(order[i]);
        }

        int out = 0;
        int score = 0;
        boolean[] base = new boolean[4];
        for(int inning = 1 ; inning <= N ; inning++) {
            while(out < 3) {
                int currHitter = players.pollFirst();
                switch(res[inning][currHitter]) {
                    case 1:
                        if(base[3]) {
                            base[3] = false;
                            score++;
                        }

                        if(base[2]) {
                            base[3] = true;
                            base[2] = false;
                        }

                        if(base[1]) {
                            base[2] = true;
                        }

                        base[1] = true;

                        break;
                    case 2 :
                        if(base[3]) {
                            score++;
                            base[3] = false;
                        }

                        if(base[2]) {
                            score++;
                            base[2] = false;
                        }

                        if(base[1]){
                            base[3] = true;
                            base[1] = false;
                        }

                        base[2] = true;
                        break;
                    case 3:
                        if(base[3]) {
                            score++;
                        }
                        if(base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if(base[1]) {
                            score++;
                            base[1] = false;
                        }

                        base[3] = true;
                        break;
                    case 4:
                        score++;
                        for(int i = 1 ; i <= 3 ; i++) {
                            if(base[i]) score++;
                            base[i] = false;
                        }
                        break;
                    default:
                        out++;
                        break;
                }
                players.offerLast(currHitter);
            }

            for(int i = 1 ; i <= 3 ; i++) base[i] = false;
            out = 0;
        }

        return score;
    }
}