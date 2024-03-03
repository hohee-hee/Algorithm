import java.io.*;
import java.util.*;

public class Main {
    public static int A,B,C;
    public static long answer;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long answer = recur(A, B);

        System.out.println(answer);
    }

    public static long recur(long num, int ex) {
        if(ex == 1) return num % C;

        long recurValue = recur(num, ex/2);
        if(ex % 2 == 0) {
            return recurValue * recurValue % C;
        } else {
            return recurValue * recurValue % C * num % C;
        }
    }
}

