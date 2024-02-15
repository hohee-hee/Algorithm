import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> sum = new ArrayList<>();
        int oddCnt = 0;
        st = new StringTokenizer(br.readLine());
        int num = 0;
        for(int i = 0 ; i < N ; i++) {
            num = Integer.parseInt(st.nextToken());
            if(num % 2 == 0) {
                if(sum.isEmpty()) sum.add(0);
                else sum.add(oddCnt+sum.get(sum.size()-1));
                oddCnt = 0;
            } else {
                oddCnt++;
            }
        }

        if(sum.isEmpty()) {
            System.out.println(0);
            return;
        }


        int answer = 0;
        int lp = 0; int rp = 0;
        while(lp <= rp && rp < sum.size()) {
            if(sum.get(rp)-sum.get(lp) > K) {
                lp++;
            } else {
                answer = Math.max(answer, rp-lp+1);
                rp++;
            }
        }

        System.out.println(answer);
    }
}

