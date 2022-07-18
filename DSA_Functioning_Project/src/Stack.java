import java.io.*;

class Stack {
	// Implementing stack using linked list
    static class StackNode {
        String data;
        StackNode next;
        StackNode(String data) { 
            this.data = data; 
        }
    }
     
    static StackNode head;
     
    // pushing data to stack
    
    public void push(String data) throws IOException
    {
        StackNode newNode = new StackNode(data);
        if (head == null) {
            head = newNode;
        }
        else {
            StackNode temp = head;
            head = newNode;
            newNode.next = temp;
            //updateStackFile();
        }
        //System.out.println("Item pushed into stack = "+data);
    }
    
    // deleting and viewing the top most data from stack
  
    public void pop() throws IOException
    {
        //String popped;
        if (head == null) {
            System.out.println("Stack is Empty");
        }
        else {
            //popped = root.data;
          head = head.next;
            updateStackFile();
            //System.out.println(popped);
            
        }
    }
    
    // just viewing the top most data without deleting
  
    public void peek()
    {
        if (head == null) {
            System.out.println("Stack is empty");
        }
        else {
        	System.out.println(head.data);
        }
    }
    
    public void printAll() {
    	if(head==null) {
    		System.out.println("There are no announcements to view...!");
    	}
    	else {
    		while(head!=null) {
    			System.out.println(head.data);
    			head=head.next;
    		}
    		System.out.println();
    		System.out.println("Printed all announcements...!");
    	}
    }
    
    // Activating stack
    
        public Stack activateStack(Stack s) throws IOException {
    	FileReader fr = new FileReader("/Users/bharath/Desktop/DSA_Project/announcements.txt");
    	BufferedReader br = new BufferedReader(fr);
    	
    	String str;
    	
    	while((str=br.readLine())!=null) {
    		s.push(str);
    	}
    	br.close();
    	return s;
    }
    
    // Update file and stack
    
    public void updateStackFile() throws IOException {
    	FileWriter fw1 = new FileWriter("/Users/bharath/Desktop/DSA_Project/announcements.txt");
    	PrintWriter fw = new PrintWriter(fw1);
    	
    	while(head!=null) {
    		fw.println(head.data);
    		
    		head=head.next;

    	}
        
        fw.close();
    }
    
    
}
  
