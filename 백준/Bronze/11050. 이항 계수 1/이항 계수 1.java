import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int answer = 1;
            if(k != 0 && n != k) answer = fact(n) / (fact(k) * fact(n-k));
            System.out.println(answer);

    }


    public static int fact(int n) {
        for(int i = n-1 ; i > 0 ; i--){
            n *= i;
        }
        return n;
    }
}
