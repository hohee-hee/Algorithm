import java.io.*;
import java.util.*;

public class Main {
    public static class Student {
        String stuNum;
        int order;
    }

    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        TreeMap<String, Integer> waiting = new TreeMap<>();


        for(int i = 0 ; i < L ; i++) {
            String stu = br.readLine();
            if(waiting.containsKey(stu)) waiting.remove(stu);
            waiting.put(stu, i);
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(waiting.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(int i = 0 ; i < K ; i++) {
            if(i == list.size()) break;
            sb.append(list.get(i).getKey()).append("\n");
        }

        System.out.println(sb);
    }
}