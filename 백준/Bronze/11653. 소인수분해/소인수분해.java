import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) return;

        for(int i = 2 ; i*i <= N ; i++) {
            while(N % i == 0) {
                sb.append(i).append("\n");
                N /= i;
            }
        }
        if(N != 1) sb.append(N).append("\n");

        System.out.println(sb);
    }
}