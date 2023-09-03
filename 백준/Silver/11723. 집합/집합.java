import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        HashSet<Integer> S = new HashSet<>();
        for(int tc = 0 ; tc < T ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("all")) {
                for(int i = 1 ; i < 21 ; i++) S.add(i);
                continue;
            }
            if(command.equals("empty")){
                S.clear();
                continue;
            }

            int x = Integer.parseInt(st.nextToken());
            if(command.equals("add")) {
                S.add(x);
                continue;
            }

            if(command.equals("remove")){
                S.remove(x);
                continue;
            }

            if(command.equals("check")){
                if(S.contains(x)) sb.append("1\n");
                else sb.append("0\n");
            }

            if(command.equals("toggle")){
                if(S.contains(x)) S.remove(x);
                else S.add(x);
            }
        }


        System.out.println(sb);
    }
}
