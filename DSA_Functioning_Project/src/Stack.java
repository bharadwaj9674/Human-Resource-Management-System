import java.util.LinkedList;
public class Stack {
    int size;
    int top =-1;
    LinkedList<Integer>st;
    Stack(int size){
      this.size=size;
      this.st=new LinkedList<>();
    }
    public void push(int data){
        if(top==size){
        System.out.println("Stack overflow");
   }
   else{
       st.addLast(data);
       top++;
   }
}
   public int pop(){
       if(top>-1){
        top--;
          return st.removeLast();
       }
      else{
          System.out.println("Stack underflow");
          return-1;
      }
   }
   public int peek(){
       if(top==-1){
           return -1;
       }
       else{
           return st.get(top);
       }
   }
   public void print(){
       for(int i=top;i>=0;i--){
           System.out.println(st.get(i));
       }
   }
   public static void main(String[] args) {
    Stack st=new Stack(5);
       System.out.println("pushing the elements in the stack");
       st.push(1);
       st.push(2);
       st.push(3);
       st.push(4);
       st.print();
       System.out.println("poping the elements");
      st.pop();
      st.pop();
      st.pop();
      st.print();
       System.out.println("Peek the elements");
       System.out.println(st.peek());
       
   }

}
