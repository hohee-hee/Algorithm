import java.io.*;
import java.util.*;

public class Main {
    public static Long N, P, Q;
    public static HashMap<Long, Long> A;

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        A = new HashMap<>();
        A.put(0L, 1L);
        long answer = recur(N);
        System.out.println(answer);
    }

    public static long recur(long i){
        if(A.containsKey(i)) return A.get(i);

        long recurP = recur(i/P);
        long recurQ = recur(i/Q);
        A.put(i, recurP + recurQ);
        return recurP + recurQ;
    }
}