import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));

        System.out.println(sb);
    }
}
