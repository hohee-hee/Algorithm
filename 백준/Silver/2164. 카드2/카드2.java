import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      ArrayDeque<Integer> q = new ArrayDeque<>();

      for(int i = 1 ; i <= N ; i++) q.offerLast(i);

      int answer = 0;

      while(q.size() > 1) {
          answer = q.pollFirst();
          q.offerLast(q.pollFirst());
      }

      System.out.println(q.pollFirst());
  }
}
