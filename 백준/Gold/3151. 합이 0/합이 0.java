
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] stu = new int[N];
        for(int i = 0 ; i < N ; i++) stu[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(stu);
        long answer = 0;

        for(int i = 0 ; i < N-1 ; i++) {
            for(int j = i+1 ; j < N ; j++) {
                int stat = stu[i] + stu[j];
                int lower_bound = lower_bound(j+1, N, stu, stat);
                int upper_bound = upper_bound(j+1, N, stu, stat);
                answer += upper_bound - lower_bound;
            }
        }
        System.out.println(answer);
    }

    public static int lower_bound(int s, int e, int[] stu, int stat){
        int mid = 0;
        while(s < e) {
            mid = (s+e) / 2;

            if(stat + stu[mid] < 0) s = mid+1;
            else e = mid;
        }
        return s;
    }

    public static int upper_bound(int s, int e, int[] stu, int stat){
        int mid = 0;
        while(s < e) {
            mid = (s+e) / 2;

            if(stat + stu[mid] <= 0) s = mid+1;
            else e = mid;
        }
        return e;
    }
}