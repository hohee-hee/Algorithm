import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException{

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int yr = Integer.parseInt(br.readLine());

       if(yr % 4 != 0) System.out.println(0);
       else if(yr % 400 == 0) System.out.println(1);
       else if(yr % 100 == 0) System.out.println(0);
       else System.out.println(1);
   }
}
