import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
	    int[] height = new int[9];
	    int sum = 0;
	    
	    for(int i = 0 ; i < 9 ; i ++){
	        height[i] = sc.nextInt();
	        sum += height[i];
	    }
	    
	    int last = sum - 100;
	    int temp = 0;
	    
	    for(int j = 0 ; j<9;j++) {
	    	temp = last - height[j];
	    	for(int i = 0; i<9;i++) {
	    		if(height[j] != height[i] && height[i] == temp) {

	    			height[i] = 0;
	    			height[j] = 0;
	    			break;
	    		}
	    	}
	    	if(height[j] == 0)
	    		break;
	    }
	    
	    Arrays.sort(height);
	    for(int i = 2 ; i < 9 ; i ++)
	    	System.out.println(height[i]);
    }
}