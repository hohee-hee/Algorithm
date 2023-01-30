import java.util.*;

public class Main {
		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int[] weight = new int[N];
			int[] height = new int[N];
			for(int i = 0 ; i < N ; i++) {
				weight[i] = sc.nextInt();
				height[i] = sc.nextInt();
			}
			
			int[] rank = new int[N];
			
			for(int i = 0 ; i < N ; i++) {
				rank[i] = 1;	
				for(int j = 0 ; j < N ; j++) {
					if(weight[i] < weight[j] && height[i] < height[j])
							rank[i]++;					
				}
				System.out.print(rank[i]+ " ");
				
			}			
		}
	}
