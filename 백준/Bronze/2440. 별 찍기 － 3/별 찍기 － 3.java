import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = N ; i > 0; i--) {
            for(int j = i ; j > 0 ; j--) sb.append("*");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
