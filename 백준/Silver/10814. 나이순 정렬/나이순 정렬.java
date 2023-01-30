import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;
	
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] info = new String[N][2];
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			info[i] = str.split(" ");
		}
	    Arrays.sort(info, new Comparator<String[]>() {				
            @Override
            public int compare(String[] o1, String[] o2) {  
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }			
        });
	    
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < N ; i++) {
			sb.append(info[i][0]).append(" ").append(info[i][1]).append("\n");
		}				
		
		System.out.println(sb);
				
	}
}
