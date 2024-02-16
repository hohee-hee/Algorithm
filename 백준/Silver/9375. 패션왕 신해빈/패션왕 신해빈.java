import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            HashSet<String> keys = new HashSet<>();
            for(int i = 0 ; i < N ; i++) {
                String kind = br.readLine().split(" ")[1];
                keys.add(kind);

                if(map.containsKey(kind)) {
                    int cnt = map.get(kind);
                    map.remove(kind);
                    map.put(kind, cnt+1);
                } else {
                    map.put(kind, 1);
                }
            }

            Iterator<String> it = keys.iterator();
            long answer = 1;
            while(it.hasNext()) {
                String tKey = it.next();
                answer *= map.get(tKey) + 1;
            }

            sb.append(answer-1).append("\n");
        }

        System.out.println(sb);
    }
}