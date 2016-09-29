public class StringStack {
    
    public static final int DEFAULT_SIZE = 10;
	private String[] elements;
    private int count;
    int max = 12;

   
    public StringStack(){
        elements = new String[DEFAULT_SIZE];
    }

    public StringStack(int size){
        if (size <= 0){
            throw new IllegalArgumentException("size must be greater than 0");
        } else{
            elements = new String[size];
        }
    }


    public String pop(){
        if (count <= 0){
            throw new ArrayIndexOutOfBoundsException("no element to pop");
        } else{
        	count--;
            return elements[count];
        }
    }
    
    private void expand(){
        String copy[] = new String[max];

        for(int i = 0; i < count; i++)
            copy[i] = elements[i];

        max += 5;
        elements = new String[max];

        for(int i = 0; i < count; i++)
            elements[i] = copy[i];
    }


    public String pop(int n){
        if (n <= 0){
            throw new IllegalArgumentException("can't reverse pop");
        } else{
            String poplast = "";
            for(int i = 0; i < n; i++){
                poplast = pop();
            }
            return poplast;
        }
    }

    
    public void push(String item){
        if(count +1 >= elements.length){
       //  --> ez way -->    throw new ArrayIndexOutOfBoundsException("Stack is full!");
        	expand();
        }
           
            elements[count] = item;
            count++;
        
    }

    public int size(){
        return count;
    }


    public String toString(){
        if (size() == 0) {
            return "nothing in stack";
        }

        String str = "";
        for (int i = 0; i < count - 1; i++) {
            str += elements[i] + ", ";
        }
        return str + elements[size() - 1];
    }

    public String peek(){
    	int top = count - 1;
        return elements[top];
    }

    public static void main(String[] args) {
        
    	StringStack stack = new StringStack(20);
        
    	stack.push("pig");
        stack.push("Platypus");
        stack.push("Tiger");
        stack.push("Rats");
        stack.push("Hipon");
        
        System.out.println(stack);
        System.out.println(stack.size());
        
        
        
        String item1 = stack.pop();
        String item2 = stack.pop();
        
        System.out.println(stack);
        
        String item3 = stack.pop();
        String item4 = stack.pop();
        String item5 = stack.pop();


        System.out.println(item1);
        System.out.println(item2); 
        System.out.println(item3); 
        System.out.println(stack); 
        
        System.out.println(item4);
        System.out.println(item5);
        System.out.println(stack); 
        
        System.out.println(stack.size());

        stack.push("Never gonna give you up");
        stack.push("Doge");
        stack.push("Harambe");
        
        System.out.println(stack.pop(2));
        
        System.out.println(stack); 
    }

}