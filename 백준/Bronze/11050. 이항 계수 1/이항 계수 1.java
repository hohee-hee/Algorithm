import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int deno  = 1;
        int nume = 1;
        for(int i = 1 ; i <= N ; i++) deno *= i;
        for(int i = 1 ; i <= N-K ; i++) nume *= i;
        for(int i = 1 ; i <= K ; i++) nume *= i;

        System.out.println(deno / nume);
    }
}