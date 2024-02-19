import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, TreeSet<Integer>> levels = new TreeMap<>(); // key: level, set: 문제 번호 set
        TreeMap<Integer, Integer> problems = new TreeMap<>(); // key: 문제번호, value: 난이도

        StringTokenizer st;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            problems.put(P, L);

            if(!levels.containsKey(L)) {
                levels.put(L, new TreeSet<>());
            }

            TreeSet<Integer> set = levels.remove(L);
            set.add(P);
            levels.put(L, set);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            if(c.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    sb.append(levels.get(levels.lastKey()).last()).append("\n");
                } else {
                    sb.append(levels.get(levels.firstKey()).first()).append("\n");
                }
            } else if(c.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                int L = problems.remove(P);

                TreeSet<Integer> set = levels.remove(L);
                set.remove(P);

                if(set.isEmpty()) continue;
                levels.put(L, set);
            } else {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                problems.put(P, L);

                if(!levels.containsKey(L)) {
                    levels.put(L, new TreeSet<>());
                }

                TreeSet<Integer> set = levels.remove(L);
                set.add(P);
                levels.put(L, set);
            }
        }



        System.out.println(sb);
    }
}