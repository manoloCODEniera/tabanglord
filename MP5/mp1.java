package mp1;
import java.util.*;

public class mp1 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of generations to be displayed using Rule 30");
		
        int input = sc.nextInt();
        int holder = input;
        int[] ar;
        int[] next;
        ar = new int[holder];
        next = new int[holder];
        
        //////////////////////////////////////////////////////////////
        if(input >= 1){												//
        	for (int i = 0; i < ar.length; i++) {					//
        		if(i==input/2){										//
        			ar[i]=1;										//
        		}													// -------- > WRITES THE SEED IN THE MIDDLE
        		System.out.print(ar[i] + " ");						//
        	}														//
        }															//
        System.out.println();										//
        //////////////////////////////////////////////////////////////
        for (int i = 1; i < holder; i++) {
        	for (int x = 0; x < ar.length; x++) {
        		if(x==0){
        			if(ar[x]==0 && ar[x+1]==1)
        				next[x] = 1;
        			if(ar[x]==1 && ar[x+1]==0)
        				next[x]=1;
        			if(ar[x]==1 && ar[x+1]==1)
        				next[x]=1;
        			if(ar[x]==0 && ar[x+1]==0)
        				next[x]=0;
        		}
        		else if(x==next.length-1){
        			if(ar[x-1]==0 && ar[x]==1)
        				next[x]=1;
        			if(ar[x-1]==1 && ar[x]==0)
        				next[x]=1;
        			if(ar[x-1]==0 && ar[x]==0)
        				next[x]=0;
        			if(ar[x-1]==1 && ar[x]==1)
        				next[x]=0;
        			
        			
        		}
        		else{
        			
        		
        			
        			if(ar[x-1]==1 && ar[x]==0 && ar[x+1]==0)
        				next[x]=1;
        			
        			if(ar[x-1]==0 && ar[x]==1 && ar[x+1]==1)
        				next[x]=1;
        			
        			if(ar[x-1]==0 && ar[x]==1 && ar[x+1]==0)
        				next[x]=1;
        			
        			if(ar[x-1]==0 && ar[x]==0 && ar[x+1]==1)
        				next[x]=1;
        			
        			// 0
        			
        			if(ar[x-1]==1 && ar[x]==1 && ar[x+1]==1)
        				next[x]=0;
        			
        			if(ar[x-1]==1 && ar[x]==0 && ar[x+1]==1)
        				next[x]=0;
        			if(ar[x-1]==0 && ar[x]==0 && ar[x+1]==0)
        				next[x]=0;
        			if(ar[x-1]==1 && ar[x]==1 && ar[x+1]==0)
        				next[x]=0;
        		}
        		System.out.print(next[x] + " ");
        	}
        	for (int x = 0; x < ar.length; x++) {
        		ar[x]=next[x];
        	}
        	System.out.println();
        	
        		
        }
        System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));
        sc.close();
        
    }
}