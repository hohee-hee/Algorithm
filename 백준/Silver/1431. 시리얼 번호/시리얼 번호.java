import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] guitars = new String[N];
        for(int i = 0 ; i < N ; i++) guitars[i] = br.readLine();

        Arrays.parallelSort(guitars, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    int o1sum = 0;
                    for(int i = 0 ; i < o1.length() ; i++) {
                        int ch = o1.charAt(i) - '0';
                        if(ch >= 0 && ch <= 9) o1sum += ch;
                    }

                    int o2sum = 0;
                    for(int i = 0 ; i < o2.length() ; i++) {
                        int ch = o2.charAt(i) - '0';
                        if(ch >= 0 && ch <= 9) o2sum += ch;
                    }

                    if(o1sum == o2sum) return o1.compareTo(o2);

                    return o1sum - o2sum;
                }
                return o1.length() - o2.length();
            }
        });

        for(String sn : guitars) sb.append(sn).append("\n");
        System.out.println(sb);
    }
}