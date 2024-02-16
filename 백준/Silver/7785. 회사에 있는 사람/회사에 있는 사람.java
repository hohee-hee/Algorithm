import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        StringTokenizer st;
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String type = st.nextToken();

            if(type.equals("enter")) {
                set.add(name);
            } else if(set.contains(name)) {
                set.remove(name);
            }
        }

        Iterator it = set.iterator();
        while(it.hasNext()) {
            sb.append(it.next()).append("\n");
        }
        
        System.out.println(sb);
    }

}