import java.util.*;
class recruit 
{
    static Scanner sc=new Scanner(System.in);
    static int age, salary, tier;
    class node
    {
        int value;
        node next;
        node(int value)
        {
            this.value= value;
            next=null;
        }
    }
    static node nodeage, nodetier, nodesalary;
    void accept()
    {
        System.out.println("Enter name");
        String name=sc.next();
        System.out.println("Enter age");
        age=sc.nextInt();
        System.out.println("Enter tier of college");
        tier=sc.nextInt();
        System.out.println("Enter excpected salary");
        salary=sc.nextInt();
    }
    void create()
    {
        nodeage=new node(age);
        nodetier=new node(tier);
        nodesalary=new node(salary);
        nodeage.next=nodetier;
        nodetier.next=nodesalary;
    }
    boolean checkage(int age)
    {
        if(age>45 && age<22)
        return false;
        else
        return true;
    }
    boolean checktier(int tier)
    {
        if(tier>2&&tier<0)
        return false;
        else
        return true;
    }
    boolean checksalary(int salary)
    {
        if(salary>100000&&salary<0)
        return false;
        else
        return true;
    }
    void traversal()
    {
        if((checkage(nodeage.value)))
        {
            if((checktier(nodetier.value)))
            {
                if((checksalary(nodesalary.value)))
                {
                    System.out.println("the candidate is selected");
                }
                else
                System.out.println("candidate rejected");
            }
            else
                System.out.println("candidate rejected");
        }
        else
                System.out.println("candidate rejected");
    }
    void list()
    {
        System.out.println("Enter the number of candidates");
        int n=sc.nextInt();
        while(n>0)
        {
            accept();
            create();
            traversal();
            n--;
        }
    }
    public static void main(String args[])
    {
        recruit ob=new recruit();
        ob.list();
    }
}