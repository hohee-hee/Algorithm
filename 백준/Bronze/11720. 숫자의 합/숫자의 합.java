import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] nums = br.readLine().toCharArray();
        int answer = 0;
        for(int i = 0 ; i < N ; i++){
            answer += nums[i] - '0';
        }


        System.out.println(answer);
    }
}
