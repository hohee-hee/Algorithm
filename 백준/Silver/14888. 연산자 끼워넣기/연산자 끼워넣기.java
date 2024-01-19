import java.io.*;
import java.util.*;

public class Main {
    public static int[] nums;
    public static char[] oper;
    public static boolean[] isChosen;
    public static int max, min;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i = 0 ; i < N ; i++) nums[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] map = {'+', '-', '*', '/'};
        oper = new char[N-1];
        isChosen = new boolean[N-1];
        int oidx = 0;
        for(int i = 0 ; i < 4 ; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < cnt ; j++) oper[oidx++] = map[i];
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        bt(1, nums[0], N);


        System.out.println(max);
        System.out.println(min);
    }

    public static void bt(int target, int res, int N){
        if(target == N) {
            if(res > max) max = res;
            if(res < min) min = res;

            return;
        }

        for(int i = 0 ; i < N-1 ; i++) {
            if(isChosen[i]) continue;

            isChosen[i] = true;
            char op = oper[i];
            int next = res;

            if(op == '+') next += nums[target];
            else if(op == '-') next -= nums[target];
            else if(op == '*') next *= nums[target];
            else {
                if(next < 0) {
                    next *= -1;
                    next /= nums[target];
                    next *= -1;
                } else {
                    next /= nums[target];
                }

            }
            
            bt(target+1, next, N);

            isChosen[i] = false;
        }
    }
}
