import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < 7 ; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num % 2 == 0) continue;
            if(min > num) min = num;

            sum += num;
        }

        if(sum == 0) {
            System.out.println(-1);
        } else {
            sb.append(sum).append('\n').append(min);
            System.out.println(sb);
        }

    }
}
