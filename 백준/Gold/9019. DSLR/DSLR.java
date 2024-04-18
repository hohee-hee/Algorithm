import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String A = st.nextToken();
            String B = st.nextToken();

            ArrayDeque<String[]> q = new ArrayDeque<>();
            boolean[] isVisited = new boolean[10001];
            q.offerLast(new String[]{A,""});
            isVisited[Integer.parseInt(A)] = true;
            while(!q.isEmpty()) {
                String cs= q.peekFirst()[0];
                String cc = q.pollFirst()[1];

                String ns = D(cs);
                if(ns.equals(B)) {
                    sb.append(cc+"D").append("\n");
                    break;
                }
                if(!isVisited[Integer.parseInt(ns)]) {
                    q.offerLast(new String[]{ns, cc+"D"});
                    isVisited[Integer.parseInt(ns)] = true;
                }

                ns = S(cs);
                if(ns.equals(B)) {
                    sb.append(cc+"S").append("\n");
                    break;
                }
                if(!isVisited[Integer.parseInt(ns)]) {
                    q.offerLast(new String[]{ns, cc+"S"});
                    isVisited[Integer.parseInt(ns)] = true;
                }

                ns = L(cs);
                if(ns.equals(B)) {
                    sb.append(cc+"L").append("\n");
                    break;
                }
                if(!isVisited[Integer.parseInt(ns)]) {
                    q.offerLast(new String[]{ns, cc+"L"});
                    isVisited[Integer.parseInt(ns)] = true;
                }

                ns = R(cs);
                if(ns.equals(B)) {
                    sb.append(cc+"R").append("\n");
                    break;
                }
                if(!isVisited[Integer.parseInt(ns)]) {
                    q.offerLast(new String[]{ns, cc+"R"});
                    isVisited[Integer.parseInt(ns)] = true;
                }
            }
        }

        System.out.println(sb);
    }

    public static String D (String str) {
        int num = Integer.parseInt(str);
        num = num * 2 % 10000;
        return Integer.toString(num);
    }

    public static String S (String str) {
        int num = Integer.parseInt(str);
        num -= 1;
        if(num < 0) num = 9999;
        return Integer.toString(num);
    }

    public static String L (String str) {
        int num = Integer.parseInt(str);
        num = num % 1000 * 10 + num / 1000;
        return Integer.toString(num);
    }

    public static String R (String str) {
        int num = Integer.parseInt(str);
        num = num / 10 + num % 10 * 1000;
        return Integer.toString(num);
    }

}