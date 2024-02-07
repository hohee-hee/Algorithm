import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            if(isPrime(Integer.parseInt(st.nextToken()))) answer++;
        }

        System.out.println(answer);
    }

    public static boolean isPrime(int num) {
        if(num == 1) return false;

        for(int i = 2 ; i*i <= num ; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}