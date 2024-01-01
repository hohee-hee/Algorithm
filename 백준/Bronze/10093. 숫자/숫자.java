import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long min = 0;
        long max = 0;

        if(A < B) {
            max = B;
            min = A;
        } else if(A > B) {
            max = A;
            min = B;
        }

        if(A == B) {
            sb.append(0);
        } else {
            sb.append(max - min - 1).append('\n');
            for(long i = min+1 ; i < max ; i++) sb.append(i).append(" ");
        }



        System.out.println(sb);
    }
}
