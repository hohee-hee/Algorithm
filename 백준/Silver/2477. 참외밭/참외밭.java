import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[][] info = new int[6][2];
		int col = 0, row = 0, cdx = -1, rdx = -1;
		for(int i = 0 ; i < 6 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			if(info[i][0] == 1 || info[i][0] == 2) {
				col = Math.max(col, info[i][1]);
				if(info[i][1] == col) cdx = i;
			}
			else {
				row = Math.max(row, info[i][1]);
				if(info[i][1] == row) rdx = i;
			}
		}

		int l = cdx - 1;
		int r = cdx + 1;
		if(l < 0) l = 5;
		if(r > 5) r = 0;
		int y = Math.max(info[l][1], info[r][1]) - Math.min(info[l][1], info[r][1]);
		
		l = rdx - 1;
		r = rdx + 1;
		if(l < 0) l = 5;
		if(r > 5) r = 0;
		int x = Math.max(info[l][1], info[r][1]) - Math.min(info[l][1], info[r][1]);
		
		int answer = col * row - x * y;		
		System.out.println(answer * K);
	}	
		
}
