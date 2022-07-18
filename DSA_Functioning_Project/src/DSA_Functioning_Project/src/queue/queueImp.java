package queue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

    class queueImp{
    int front=0;
    int rear=0;
    int size;
    String[] queue;
    queueImp(int size){
       this.size=size;
       this.queue=new String[size];
    }
   
    public void enqueue(String data){
         if(size==rear){
            System.out.println("Stack Overflow");
        }
        else{
            queue[rear]=data;
            rear++;
        }
    }
    public String peek(){
        if(front ==rear){
            System.out.println("Empty");
            return "-1";
        }
        else{
            return queue[front];
        }
    }
    public String[] newArray(){
        String [] array=new String[size];
        for(int i=1;i<size;i++){
            array[i-1]=queue[i];
        }
        return array;
    }
    public String dequeue(){
        if(front==rear){
             System.out.println("Stack Underflow");
             return "-1";
        }
        else{
            rear--;
            queue=newArray();
            return queue[front];

        }
    }
    public void print(){
        for(int i=0;i<rear;i++){
            System.out.println(queue[i]);
        }
    }


    }

