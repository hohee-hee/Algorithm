import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) P[i] = Integer.parseInt(st.nextToken());

        Arrays.parallelSort(P);

        int answer = 0;
        for(int i = 0 ; i < N ; i++) answer += P[i] * (N-i);
        System.out.println(answer);

    }
}

