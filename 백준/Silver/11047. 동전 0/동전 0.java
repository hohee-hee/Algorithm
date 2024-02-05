import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for(int i = 0 ; i < N ; i++) A[i] = Integer.parseInt(br.readLine());

        int rest = K;
        int answer = 0;
        for(int i = N-1 ; i >= 0 ; i--) {
            if(A[i] > rest) continue;

            while(A[i] <= rest) {
                rest -= A[i];
                answer++;
            }

            if(rest == 0) break;
        }

        System.out.println(answer);
    }
}

