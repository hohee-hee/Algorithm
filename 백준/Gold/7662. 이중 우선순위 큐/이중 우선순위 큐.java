import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int tc = 0 ; tc < T ; tc++) {
            TreeSet<Integer> Q = new TreeSet<>();
            TreeMap<Integer, Integer> cnt = new TreeMap<>();

            int k = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < k ; i++) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                if(command == 'I') {
                    int num = Integer.parseInt(st.nextToken());
                    Q.add(num);
                    if(cnt.containsKey(num)) cnt.put(num, cnt.remove(num)+1);
                    else cnt.put(num, 1);
                } else {
                    if(Q.isEmpty()) continue;

                    int type = Integer.parseInt(st.nextToken());
                    int target = 0;
                    if(type == 1) target = Q.last();
                    else target = Q.first();

                    if(cnt.get(target) == 1) {
                        cnt.remove(target);
                        Q.remove(target);
                    } else {
                        cnt.put(target, cnt.remove(target)-1);
                    }
                }
            }

            if(Q.isEmpty()) sb.append("EMPTY");
            else sb.append(Q.last()).append(" ").append(Q.first());

            sb.append("\n");
        }

        System.out.println(sb);
    }
}