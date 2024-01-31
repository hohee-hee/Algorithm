import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] P = new long[101];
        P[1] = 1; P[2] = 1; P[3] = 1; P[4] = 2; P[5] = 2;
        int pt = 6;

        for(int tc = 0 ; tc < T ; tc++) {
            int N = Integer.parseInt(br.readLine());

            if(P[N] == 0) {
                for(int i = pt ; i <= N ; i++) P[i] = P[i-5] + P[i-1];
                pt = N;
            }

            sb.append(P[N]).append("\n");
        }
        System.out.println(sb);
    }
}

