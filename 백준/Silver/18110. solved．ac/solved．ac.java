import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] diff = new int[n];
        for(int i = 0 ; i < n ; i++) {
            diff[i] = Integer.parseInt(br.readLine());
        }

        Arrays.parallelSort(diff);
        double cut = Math.round(n * 0.15);

        int answer = 0;

        for(int i = (int) cut ; i < n - cut ; i++) {
            answer += diff[i];
        }
        
        System.out.println(Math.round((double) answer / (n - (2*cut))));
    }
}
