import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] prime = new int[246913];
        prime[1] = 1;
        int pt = 1;

        int n = Integer.parseInt(br.readLine());
        while(n != 0) {
            if(pt <= 2*n) {
                for (int i = pt+1; i <= 2 * n; i++) {
                    if (isPrime(i)) {
                        prime[i] = prime[i - 1] + 1;
                    } else {
                        prime[i] = prime[i - 1];
                    }
                }
            }

            sb.append(prime[2*n]-prime[n]).append("\n");
            pt = 2*n;
            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }

    public static boolean isPrime(int num) {
        if(num == 1) return false;

        for(int i = 2 ; i*i <= num ; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}