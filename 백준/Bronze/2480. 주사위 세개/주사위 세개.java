import java.io.*;
import java.util.*;

public class Main {


   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int d1 = Integer.parseInt(st.nextToken());
       int d2 = Integer.parseInt(st.nextToken());
       int d3 = Integer.parseInt(st.nextToken());


       int price = 0;

       if(d1 == d2 && d2 == d3) {
           price = 10000 + d1 * 1000;
       } else if (d1 == d2 || d2 == d3 || d3 == d1) {
           price = 1000 + pips(d1,d2,d3) * 100;
       } else {
           price =  max(d1,d2,d3) * 100;
       }

       System.out.println(price);
   }

   public static int pips(int d1, int d2, int d3) {
       if(d1 == d2) return d1;
       if(d2 == d3) return d2;
       if(d3 == d1) return d3;

       return -1;
   }

   public static int max(int d1, int d2, int d3) {
       if(d1 > d2 && d1 > d3) return d1;
       if(d2 > d1 && d2 > d3) return d2;
       return d3;
   }
}
