import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        sb.append(A+B).append('\n')
                .append(A-B).append('\n')
                .append(A*B).append('\n')
                .append(A/B).append('\n')
                .append(A%B);

        System.out.println(sb);
    }
}
