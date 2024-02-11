import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snack = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) snack[i] = Integer.parseInt(st.nextToken());

        int s = 1;
        int e = 1000000000;
        int answer = 0;
        while(s < e) {
            int mid = (s+e) / 2;

            int piece = 0;
            for(int i = 0 ; i < N ; i++) piece += snack[i] / mid;
            if(piece >= M) {
                answer = mid;
            }
            if(piece >= M) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        System.out.println(answer);
    }
}