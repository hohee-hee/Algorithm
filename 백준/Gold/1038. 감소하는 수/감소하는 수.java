import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int cnt;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 최댓값(==1022)을 넘어설 때
        if(N > 1022) {
            System.out.println(-1);
            return;
        } else if(N <= 10) {
            System.out.println(N);
            return;
        }

        int[][] num = new int[11][10];
        cnt = 0;
        int digit = 0;
        int startWith = 0;
        num[1][0] = 1;
        outer: for(int r = 1 ; r <= 10 ; r++){
            for(int c = 1 ; c < 10 ; c++) {
                num[r][c] = num[r-1][c-1] + num[r][c-1];

                if(cnt+num[r][c] >= N) {
                    digit = r;
                    startWith = c;
                    break outer;
                }

                cnt += num[r][c];
            }
        }

        int[] answer = new int[digit];
        answer[0] = startWith;
        recur(answer, 1, N);


        System.out.println(sb);
    }

    public static void recur(int[] number, int idx, int N) {
        if(idx == number.length) {
            cnt++;
            if(cnt == N) {
                for(int i = 0 ; i < number.length ; i++) sb.append(number[i]);
            }
            return;
        }


        for(int i = 0 ; i < 10 ; i++) {
            if(i >= number[idx-1]) break;
            number[idx] = i;
            recur(number, idx+1, N);
        }
    }
}