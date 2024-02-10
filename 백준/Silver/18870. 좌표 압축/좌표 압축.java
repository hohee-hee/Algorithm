import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        TreeSet<Integer> sorted = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted.add(arr[i]);
        }

        ArrayList<Integer> arr_sorted = new ArrayList<>(sorted);

        // 2. 찾기
        find: for(int i = 0 ; i < N ; i++) {
            int target = arr[i];
            int sp = 0;
            int ep = arr_sorted.size();
            int mid = (ep+sp) / 2;

            while(sp < ep) {
                if(arr_sorted.get(mid) >= target) ep = mid;
                else sp = mid+1;
                mid = (ep+sp) / 2;
            }


            sb.append(sp).append(" ");
        }
        System.out.println(sb);
    }
}