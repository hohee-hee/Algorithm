import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isNotPrime = new boolean[246913];
        isNotPrime[1] = true;
        for(int i = 2 ; i < 500 ; i++) {
            if(isNotPrime[i]) continue;
            for(int j = i*2 ; j < 246913 ; j+=i) {
                isNotPrime[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());
        while(n != 0) {
            int answer = 0;
            for(int i = n+1 ; i <= 2*n ; i++) {
                if(isNotPrime[i]) continue;
                answer++;
            }

            sb.append(answer).append("\n");
            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }
}