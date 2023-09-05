import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            hs.add(num);
        }

        // 2. Set을 List로 바꾸기
        ArrayList<Integer> sorted = new ArrayList<>(hs);
        Collections.sort(sorted, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < sorted.size() ; i++){
            map.put(sorted.get(i), i);
        }

        // 3. 좌표 찾기
        int len = sorted.size()-1;
        for (int num : list) {
            sb.append(len - map.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}
