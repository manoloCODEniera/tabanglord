// coded by Manolo Codeniera and Jimro Quiambao

public class StringQueue{

    private String[] elements;
    private int count;
    private int max = 10;

    private static final int DEFAULT_SIZE = 10;

    StringQueue(){
       count = 0;
       elements = new String[DEFAULT_SIZE];
    }

    StringQueue(int size){
    	count = 0;
    	elements = new String[size];
    }

    private void expand(){
        String[] copy = new String[max];

        System.arraycopy(elements, 0, copy, 0, count);

        max += 5;
        elements = new String[max];

        System.arraycopy(copy, 0, elements, 0, count);
    }

    public String dequeue(){
        String temp = elements[0];
        

        for(int i = 1; i < count; i++){
            elements[i - 1] = elements[i];
        }

        count--;

        return temp;
    }

    public String dequeue(int n){
        String temp = elements[n];

        for(int i = n; i < count; i++)
            elements[i - n] = elements[i];

        count -= n;

        return temp;
    }

    public void enqueue(String input){

        if(count + 1 == max){
            expand();
            System.out.println("in");
        }

        elements[count] = input;

        count++;
    }

    @Override
    public String toString(){
        String ans = "";

        for(int i = 0; i < count - 1; i++)
            ans += elements[i] + ", ";

        return ans + elements[count - 1];
    } 

    public String peek(){ return elements[0]; }

    public void singit(String inp, int ind){
         if(ind < 0 || ind > count)
            throw new ArrayIndexOutOfBoundsException("Invalid Index");
        else if(count + 1 == max)
            expand();

        for(int i = count - 1; i >= ind; i--)
            elements[i + 1] = elements[i];

        count++;

        elements[ind] = inp;


    }

    public int count(){
        return count;
    }

    public static void main(String[] args){
    StringQueue list = new StringQueue();

    list.enqueue("Pig");
    list.enqueue("Platypus");
    list.enqueue("Tiger");

    System.out.println(list);

    System.out.println(list.count());

    list.dequeue();

    System.out.println(list);

    list.enqueue("Doge");

    list.singit("Harambe",1);
    
    list.singit("Pikachu", 1);
    
    list.enqueue("Pig");

    System.out.println(list);
    
    list.dequeue(3);
    
    System.out.println(list);





    
}
}