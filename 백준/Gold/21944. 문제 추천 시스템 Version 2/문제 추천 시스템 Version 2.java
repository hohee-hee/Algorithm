import java.io.*;
import java.util.*;

public class Main {
    public static class Problem{
        int num;
        int level;
        int algo;

        Problem(int num, int level, int algo) {
            this.num = num;
            this.level = level;
            this.algo = algo;
        }
    }

    public static HashMap<Integer, Problem> probGroup = new HashMap<>(); // 모든 문제 번호 저장
    public static TreeMap<Integer, TreeSet<Problem>> algoGroup = new TreeMap<>(); // 알고리즘 별 저장
    public static TreeMap<Integer, TreeSet<Problem>> levelGroup = new TreeMap<>(); // 레벨 별 저장

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            Problem p = new Problem(P, L, G);
            insert(p);
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            if(c.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                sb.append(recommend(G, x)).append("\n");
            } else if(c.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                sb.append(recommend2(x)).append("\n");
            } else if(c.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                sb.append(recommend3(L, x)).append("\n");
            } else if(c.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                add(P, L, G);
            } else {
                int P = Integer.parseInt(st.nextToken());
                solved(P);
            }
        }

        System.out.println(sb);
    }

    public static void insert(Problem p) {
        // 기본 set에 넣기
        probGroup.put(p.num, p);

        // algoGroup에 넣기
        if(!algoGroup.containsKey(p.algo)) algoGroup.put(p.algo, new TreeSet<Problem>(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                if(o1.level == o2.level) return o1.num - o2.num;
                return o1.level - o2.level;
            }
        }));

        TreeSet<Problem> algo = algoGroup.remove(p.algo);
        algo.add(p);
        algoGroup.put(p.algo, algo);

        // levelGroup에 넣기
        if(!levelGroup.containsKey(p.level)) levelGroup.put(p.level, new TreeSet<Problem>(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                return o1.num - o2.num;
            }
        }));

        TreeSet<Problem> lev = levelGroup.remove(p.level);
        lev.add(p);
        levelGroup.put(p.level, lev);
    }

    public static int recommend(int G, int x){
        if(x == 1) return algoGroup.get(G).last().num;
        else return algoGroup.get(G).first().num;
    }

    public static int recommend2(int x){
        if(x == 1) return levelGroup.get(levelGroup.lastKey()).last().num;
        else return levelGroup.get(levelGroup.firstKey()).first().num;
    }

    public static int recommend3(int L, int x){
        if(x == 1) {
            if(levelGroup.ceilingKey(L) == null) return -1;

            int target = levelGroup.ceilingKey(L);
            return levelGroup.get(target).first().num;
        } else {
            if(levelGroup.floorKey(L-1) == null) return -1;

            int target = levelGroup.floorKey(L-1);
            return levelGroup.get(target).last().num;
        }
    }

    public static void add(int P, int L, int G){
        insert(new Problem(P, L, G));
    }

    public static void solved(int P){
        // 기본 set 에서 지우기
        Problem target = probGroup.remove(P);

        // algoGroup에서 지우기
        TreeSet<Problem> algo = algoGroup.remove(target.algo);
        algo.remove(target);
        if(!algo.isEmpty()) algoGroup.put(target.algo, algo);

        // levelGroup에서 지우기
        TreeSet<Problem> lev = levelGroup.remove(target.level);
        lev.remove(target);
        if(!lev.isEmpty()) levelGroup.put(target.level, lev);
    }
}