import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        int target = 0; int lp = 0; int rp = 0;
        HashSet<Integer> set = new HashSet<>();
        long answer = 0;
        while(lp <= rp && rp < N) {
            if(target == 0 && !set.contains(arr[rp])) {
                set.add(arr[rp++]);
                continue;
            }

            target = arr[rp];
            answer += rp-lp;
            if(arr[lp] == target) target = 0;
            set.remove(arr[lp++]);
        }

        if(rp == N && lp < rp) {
            long inter = rp - lp;
            answer += inter * (inter+1) / 2;
        }



        System.out.println(answer);
    }
}

