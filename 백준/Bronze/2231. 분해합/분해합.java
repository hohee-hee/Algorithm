import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i = 1 ; i < N ; i++) {
            int x = i;
            int sum = i;

            while(x > 0) {
                sum += x % 10;
                x /= 10;
            }

            if(sum == N) {
                answer = i;
                break;
            }

        }

        System.out.println(answer);

    }
}