package mp5thread;
import java.util.Scanner;



public class Rule30 {
	 public static int THREAD_COUNT = 10;
	  public static int charsPerThread;
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int x = sc.nextInt();
	        long startTime = System.currentTimeMillis();
	        String parent = "";
	        String child = "";
	        int min = 0, max;
	        
	        
	        
	        // ////////////////////////////////////////  WRITES THE SEED ON THE FIRST LINE
	        for(int i = 0; i < x; i++)
	        {
	          if(i == x/2)
	          parent += '1';
	          else
	          parent += '0';
	        }  
	        System.out.println(parent);
	        ////////////////////////////////////////////////
	        if(x < THREAD_COUNT){
	            THREAD_COUNT = x;
	        }
	        
	        Generate[] workers = new Generate[THREAD_COUNT];
	        charsPerThread = x / THREAD_COUNT;
	        max = charsPerThread - 1;
	        
	        for(int i = 0; i < x - 1; i++){
	            
	            for(int j = 0; j < THREAD_COUNT; j++){
	                if(j == THREAD_COUNT - 1){
	                    max = x - 1;
	                }       
	                workers[j] = new Generate(min, max, parent);
	                min = max + 1;
	                max = min + charsPerThread - 1;
	            }
	            
	            for(int j = 0; j < THREAD_COUNT; j++){
	                workers[j].run();
	            }
	            
	           for (int j = 0; j < THREAD_COUNT; j++) {
	            while (workers[j].isAlive()) {
	                try {
	                    workers[j].join();
	                } catch (InterruptedException e) {
	                    System.err.println("thread interrupted: " + e.getMessage());
	                }
	            }
	        }
	           
	           
	            
	            for(int j = 0; j < THREAD_COUNT; j++){
	                child += workers[j].getAns();
	            }
	            
	            System.out.println(child);
	            
	            parent = child;
	            child = "";
	            
	            min = 0;
	            max = charsPerThread - 1;
	            
	        }
	        System.out.println("time consumed in ms: " + (System.currentTimeMillis() - startTime));
	        
	    }
	    
	}

	class  Generate extends Thread{
	    
	    private static String parent;
	    private int min;
	    private int max;
	    private String ans = "";
	    
	    public Generate(int min, int max, String parent) {
	        if (min > max || min < 0 || max < 0) {
	            throw new IllegalArgumentException("Bad arguments");
	        }
	        this.min = min;
	        this.max = max;
	        this.parent = parent;
	    }

	    @Override
	    public void run() {
	        for(int i = min; i <= max; i++){
	            ans += Generate(i);
	        }
	    }
	    
	    public static char Generate(int x){
	        char ans = '0';
	        
	        if(x == 0){
	        if(parent.charAt(x + 1) == '1' && parent.charAt(x) == '1')
	            ans = '1';
	        if(parent.charAt(x) == '1' &&  parent.charAt(x + 1) != '1')
	            ans = '1';
	        if(parent.charAt(x) != '1' && parent.charAt(x + 1) == '1')
	            ans = '1';  
	        }
	        
	        else if(x == parent.length() - 1 ){
	        if(parent.charAt(x - 1) == '1' && parent.charAt(x) != '1')
	            ans = '1';
	        if(parent.charAt(x - 1) != '1' && parent.charAt(x) == '1')
	            ans = '1';
	        }
	        
	        else{
	        if(parent.charAt(x - 1) == '1' && parent.charAt(x) != '1' && parent.charAt(x + 1) != '1')
	            ans = '1';
	        if(parent.charAt(x - 1) != '1' && parent.charAt(x) == '1' && parent.charAt(x + 1) == '1')
	            ans = '1';
	        if(parent.charAt(x - 1) != '1' && parent.charAt(x) == '1' &&  parent.charAt(x + 1) != '1')
	            ans = '1';
	        if(parent.charAt(x - 1) != '1' && parent.charAt(x) != '1' && parent.charAt(x + 1) == '1')
	            ans = '1';  
	        }
	        
	        return ans;
	    }
	    
	    public String getAns(){
	        return ans;
	    }
	    
	}