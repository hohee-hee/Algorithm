import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    	String nums = br.readLine();
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(nums);
        int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	Hashtable<String, String> ht = new Hashtable<>();
    	for(int i = 0 ; i < N ; i++){
    	    String str = br.readLine();
    	    StringTokenizer st1 = new StringTokenizer(str);
    	    ht.put(st1.nextToken(), st1.nextToken());
    	}
	
    	for(int i = 0 ; i < M ; i++){
    	       	    String page = br.readLine();
            	    sb.append(ht.get(page)).append("\n");
    	}
    	System.out.println(sb);
	}
}