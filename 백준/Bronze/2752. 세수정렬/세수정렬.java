import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException{
       StringBuilder sb = new StringBuilder();

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       TreeSet<Integer> set = new TreeSet<>();

       for(int i = 0 ; i < 3 ; i++) {
           set.add(Integer.parseInt(st.nextToken()));
       }

       Iterator<Integer> itr = set.iterator();
       while(itr.hasNext()) {
           sb.append(itr.next()).append(' ');
       }
       System.out.println(sb);
   }
}
