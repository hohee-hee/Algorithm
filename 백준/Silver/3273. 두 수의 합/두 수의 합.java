import java.io.*;

import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{		
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		

		for(int i = 0 ; i < n ; i++){

			nums[i] = Integer.parseInt(st.nextToken());

		}

		

		Arrays.parallelSort(nums);

		

		int x = Integer.parseInt(br.readLine());

		

		int lp = 0;

		int rp = n-1;

		int answer = 0;

		

		while(lp < rp){

			if(nums[lp] + nums[rp] < x) lp++;

			else if (nums[lp] + nums[rp] > x) rp--;

			else {

				answer++;

				lp++;

				rp--;

			}

		}

		

		System.out.println(answer);

	}

}