import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.parallelSort(arr);
        for(int i = 0 ; i < N ; i++) sb.append(arr[i]).append("\n");


        System.out.println(sb);
    }
}