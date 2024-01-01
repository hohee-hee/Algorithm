import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int[] nums = new int[5];

        for(int i = 0 ; i < 5 ; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            nums[i] = num;
        }

        Arrays.parallelSort(nums);
        sb.append(sum/5).append('\n').append(nums[2]);
        System.out.println(sb);

    }
}
