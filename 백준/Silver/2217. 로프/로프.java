import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        for(int i = 0 ; i < N ; i++) ropes[i] = Integer.parseInt(br.readLine());

        Arrays.parallelSort(ropes);

        int answer = 0;
        for(int i = 0 ; i < N ; i++) {
            int w = ropes[i] * (N-i);
            if(answer < w) answer = w;
        }
        System.out.println(answer);

    }
}

