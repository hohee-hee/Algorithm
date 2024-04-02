import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cities = new int[N];
        int sum = 0;
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
            sum += cities[i];
            if(answer < cities[i]) answer = cities[i];
        }

        int M = Integer.parseInt(br.readLine());
        if(sum <= M) {
            System.out.println(answer);
            return;
        }

        Arrays.parallelSort(cities);
        for(int i = 0 ; i < N ; i++) {
            if(cities[i] > M / (N-i)) {
                answer = M / (N - i);
                break;
            }
            M -= cities[i];
        }

        System.out.println(answer);
    }
}