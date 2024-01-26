import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        while(pq.size() != n) {
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                String rev = reverse(str);
                pq.offer(Long.parseLong(rev));
            }

            if(pq.size() != n) st = new StringTokenizer(br.readLine());
        }

        while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");

        System.out.println(sb);
    }

    public static String reverse(String str){
        int len = str.length();
        String num = "";
        for(int i = len - 1; i >= 0 ; i--) {
            num += str.charAt(i);
        }
        return num;
    }
}

