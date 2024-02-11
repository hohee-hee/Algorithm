import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());

        TreeSet<Integer> nums = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < nA ; i++) nums.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < nB ; i++) nums.remove(Integer.parseInt(st.nextToken()));

        sb.append(nums.size()).append("\n");
        Iterator iter = nums.iterator();
        while(iter.hasNext()) sb.append(iter.next()).append(" ");

        System.out.println(sb);
    }
}