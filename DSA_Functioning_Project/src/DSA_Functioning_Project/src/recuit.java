import java.util.*;
import java.io.*;

class recuit
{
    static Scanner sc=new Scanner(System.in);
    static int age, salary, tier;
    static String name;
    static node nodeage;
    static node nodetier;
    static node nodesalary;
    class node
    {
        int value;
        node next,prev;
        node(int value)
        {
            this.value= value;
            next=null;
            prev=null;
        }
    }
    
    void accept() throws IOException
    {
        System.out.println("Enter name");
        name=sc.next();
        System.out.println("Enter age");
        age=sc.nextInt();
        System.out.println("Enter tier of college");
        tier=sc.nextInt();
        System.out.println("Enter excpected salary");
        salary=sc.nextInt();
        nodeage=new node(age);
        nodetier=new node(tier);
        nodesalary=new node(salary);
        create();
    }

    void create() throws IOException
    {
        nodeage.next=nodetier;
        nodetier.next=nodesalary;
        traversal();
    }

    boolean checkage(int age)
    {
        if(age<45 && age>22){
            
            return true;
        }
        else{
            return false;
        }
    }

    boolean checktier(int tier)
    {
        if(tier<3&&tier>0)
            return true;
        else
            return false;
    }

    boolean checksalary(int salary)
    {
        if(salary<100000&&salary>0){
            System.out.println("true");
            return true;
        }
        else{
            return false;
        }
    }

    void traversal() throws IOException
    {
        if((checkage(nodeage.value)))
        {
            if((checktier(nodetier.value)))
            {
                if((checksalary(nodesalary.value)))
                {
                    System.out.println("the candidate is selected");
                    FileWriter fw=new FileWriter("/Users/bharath/Desktop/DSA_Project/recruit.txt",true);
                    BufferedWriter bw=new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    System.out.println(name+","+age+","+tier+","+salary);

                    pw.println(name+","+age+","+tier+","+salary);

                    pw.close();
                }
                else
                    System.out.println("candidate rejected");
            }
            else
                System.out.println("candidate rejected");
        }
        else{
            System.out.println("candidate rejected");
        }
    }

    void main_recuit() throws IOException
    {
        accept();
    }
}