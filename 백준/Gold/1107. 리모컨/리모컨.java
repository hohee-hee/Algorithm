import java.util.*;
import java.io.*;

public class Main{
    public static boolean[] istKaputt = new boolean[10];
    public static int answer;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if(M == 0) {
            answer = Math.min(Math.abs(100-N), Integer.toString(N).length());
            System.out.println(answer);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++) istKaputt[Integer.parseInt(st.nextToken())] = true;

        answer = Math.abs(100-N);
        bt(0, 1, N);
        System.out.println(answer);
    }

    public static void bt(int cn, int digit, int N){
        for(int i = 0 ; i < 10 ; i++) {
            if(istKaputt[i]) continue;
            int nn = cn + i*digit;
            int cnt = Integer.toString(digit).length() + Math.abs(N - nn);
            if(answer > cnt) answer = cnt;
            if(digit != 100000) bt(nn, digit*10, N);
        }
    }
}