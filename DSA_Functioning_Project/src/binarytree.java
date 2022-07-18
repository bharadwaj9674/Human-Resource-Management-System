

import java.io.*;
import java.util.*;
import java.util.Stack;

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



public class binarytree{
  static Node root;
  public static class Node {
    int data;
    Node left;
    Node right;
    String[] Employee;
    Node(int data,String[] Employee,Node left,Node right){
        this.data=data;
        this.Employee=Employee;
        this.left=left;
        this.right=right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }
  public static void displaydata(String[] data,Node node) {
    if(node==null){
      return;
    }
    if (data[1].equals(node.Employee[1])) {
      System.out.println("Data  --> " + node.Employee[0]);
      String[] t=node.Employee;
      String st="|";

      for(int i=0;i<6;i++){
        st=st+" "+t[i]+" "+"|";
      }
      System.out.println("-----------------------------------------");
      System.out.println(st);
      System.out.println("-----------------------------------------");
      System.out.println("----------------------------------");
      return;
    }
  
    displaydata(data,node.left);
    displaydata(data,node.right);
  }
  public static Node construct(Integer[] arr) throws FileNotFoundException{
    File f=new File("/Users/bharath/Desktop/DSA_Project/salary.txt");
    Scanner sc1=new Scanner(f);
    String s=sc1.nextLine();
    String[] ceo=s.split(",");

  root = new Node(arr[0],ceo, null, null);
   Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          String s2=sc1.nextLine();
          String[] m1=s2.split(",");
         top.node.left = new Node(arr[idx],m1, null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }
        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          String s2=sc1.nextLine();
          String[] m1=s2.split(",");
          top.node.right = new Node(arr[idx],m1, null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }
        top.state++;
      } else {
        st.pop();
      }
    }
    sc1.close();
    return root;
  }

  public static void displaysalarydata(String data,Node node) {
    if(node==null){
      return;
    }
    if (data.equals(node.Employee[1])) {
      System.out.println(data);
      String[] t=node.Employee;
      String st="|";
        st=st+" "+t[2]+" "+"|"+" "+t[4]+" "+"|";
      
      System.out.println("-------------------");
      System.out.println(st);
      System.out.println("-------------------");
      return;
    }
  
    displaysalarydata(data,node.left);
    displaysalarydata(data,node.right);
  }
  public static void printAtGivenLevelSalary(Node node, int level,String name) {
    if (node == null) {
      return ;
    }
    if(level == 1) {
      if (node.Employee[1].equals(name)) {
        String[] t=node.Employee;
        String st="|";
          st=st+" "+t[2]+" "+"|";
        
        System.out.println("-----------");
        System.out.println(st);
        System.out.println("------------");
        System.out.println("----------------------------------");
        return;
      }
      else{
      return;
      }
    }
   printAtGivenLevelSalary(node.left, level - 1,name);
   printAtGivenLevelSalary(node.right, level - 1,name);
   
  
  }
  public static void save(Node n){
    try{
      File f=new File("/Users/bharath/Desktop/DSA_Project/salary.txt");
          Scanner sc=new Scanner(f);
          queueImp q=new queueImp(8);
          while(sc.hasNextLine()){
            String s=sc.nextLine();
            String[] st=s.split(",");
            if(n.Employee[0].equals(st[0])){
              String stk="";
              for(int i=0;i<6;i++){
                stk=stk +n.Employee[i]+",";
              }
              q.enqueue(stk);
              System.out.println(stk);
          }
          else{
          q.enqueue(s);
          }
        }
        FileWriter fw=new FileWriter(f);
        for(int i=0;i<q.rear;i++){
            fw.write(q.queue[i]);
            System.out.println(q.queue[i]);
            fw.write(System.getProperty ("line.separator"));
        }
        sc.close();
        fw.close();
       
      }
      catch(Exception e){
        System.out.println("File not found");
      }
  
  }
  public static void editSalary(Node node, int level,String name) {
    if (node == null) {
      return ;}
    if(level == 1) {
      if (node.Employee[1].equals(name)) {
        String[] t=node.Employee;
        System.out.println("Bonus %");
        System.out.println("------");
        System.out.println("|"+t[5]+"|");
        System.out.println("------");
        int d=Integer.parseInt(t[2])+(((Integer.parseInt(t[5]))*Integer.parseInt(t[2]))/100);
        System.out.println("----------------------------------");
        boolean tt=false;
        while(tt!=true){
          int salary=0;
          Console console = System.console();
          if (console==null){
             System.out.print("console not available ");
          }else {
            String line = console.readLine("Enter the Salary :");
            salary = Integer.parseInt(line);
            System.out.println("----------------------------------");
            if(salary<=d){
            System.out.println("Salary this Month");
            System.out.println("------");
            System.out.println("|"+salary+"|");
            System.out.println("------");
            System.out.println("----------------------------------");
            tt=true;
            node.Employee[2]=Integer.toString(salary);
          
            System.out.println("Do you want to save the changes?");
            Scanner sc=new Scanner(System.in);
            if(sc.nextBoolean()){
            save(node);
            sc.close(); }
            else{
              System.out.println("Invalid Salary provided is greater than Bonus");}
         sc.close();       }}            }
         System.out.println("----------------------------------");
      return;}}
   
   editSalary(node.right, level-1,name);
   editSalary(node.left, level-1,name);
  }
  
  public  void mainBinary() throws FileNotFoundException{
    Integer[] arr={1,2,4,null,null,5,null,null,3,6,null,null,7,null,null};
    construct(arr);
   //Password p=new Password();
    /*System.out.println("----------------------------------------------------");
    System.out.println(""+"|" +"             "+"Salary" +" "+"MENU"+"                           "+"|"+ " ");
    System.out.println("----------------------------------------------------");
    System.out.println("Enter your designation");
    System.out.println("1.Employee");
    System.out.println("2.Manager");
    System.out.println("3.CEO");
    System.out.println("----------------------------------------------------");
    Scanner sc=new Scanner(System.in);
    System.out.print("Designation:");
    String st=sc.nextLine();*/
   //String[] tds= p.passowrdUsername(st);
   // sc.close();
   System.out.println("----------------------------------------------------");
    System.out.println(""+"|" +"             "+"Salary" +" "+"MENU"+"                           "+"|"+ " ");
    System.out.println("----------------------------------------------------");
    System.out.println("Enter your designation");
    System.out.println("1.Employee");
    System.out.println("2.Manager");
    System.out.println("3.CEO");
    System.out.println("----------------------------------------------------");
   Scanner sc1=new Scanner(System.in);
   String des=sc1.nextLine();
   System.out.println("----------------------------------------------------");
   System.out.print("Enter your name: ");
   String name2=sc1.nextLine();
   String[] tds={des,name2,"true"};
   boolean exit=true;
   if(tds[0].contains("CEO")&&tds[2]=="true"){
    System.out.println("----------------------------------");
    System.out.println("              "+"MENU"+"             ");
    System.out.println("Display salary and details --> 1");
    System.out.println("Display salary  of subordinates --> 2");
    System.out.println("Bonus salary for subordinates --> 3");
    System.out.println("Which option you want to acess?");
    System.out.println("----------------------------------");
    String display=sc1.next();
    System.out.println("----------------------------------");
    if(display.contains("1")){
      displaydata( tds,root);
    }
    else if(display.contains("2")){
      System.out.print("Enter the Designation: ");
      String dest=sc1.next();
      boolean check=false;
      if(dest.contains("Manager")){
        System.out.println("----------------------------------");
        System.out.print("Enter the name of the Manager: ");
        String name=sc1.next();
        printAtGivenLevelSalary( root, 2,name);
      }
      else if(dest.contains("Employee")){
        System.out.println("----------------------------------");
        System.out.print("Enter the name of the Employee: ");
        String name=sc1.next();
        printAtGivenLevelSalary( root, 3,name);
      }
      else{
        System.out.println("invalid designation");
      }

    }
    else if(display.contains("3")){
      System.out.print("Enter the Designation: ");
      String dest=sc1.next();
      System.out.println("----------------------------------");
      if(dest.contains("Manager")){
        System.out.print("Enter the name of the Manager: ");
        String name=sc1.next();
        editSalary( root, 2,name);
      }
      else if(dest.contains("Employee")){
        System.out.print("Enter the name of the Employee: ");
        String name=sc1.next();
        System.out.println("----------------------------------");
        editSalary( root, 3,name);
      }
      else{
        System.out.println("invalid designation");
      }
    }
    else if(display.contains("4")){
      exit=false;
     }

    else{
      System.out.println("Invalid option");
    }
    sc1.close();
   }
   // manager part
   else if(tds[0].contains("Manager")&& tds[2]=="true"){
    System.out.println("----------------------------------");
    System.out.println("              "+"MENU"+"             ");
    System.out.println("Display salary and details --> 1");
    System.out.println("Display salary  of subordinates --> 2");
    System.out.println("Bonus salary for subordinates --> 3");
    System.out.println("Which option you want to acess?");
    System.out.println("----------------------------------");
    String display=sc1.next();
    System.out.println("----------------------------------");
    if(display.contains("1")){
      displaydata( tds,root);
    }
    else if(display.contains("2")){
      System.out.print("Enter the Designation: ");
      String dest=sc1.next();
      System.out.println("----------------------------------");
      if(dest.contains("Employee")){
        System.out.print("Enter the name of the Employee: ");
        String name=sc1.next();
        System.out.println("----------------------------------");
        printAtGivenLevelSalary(root, 3,name);

      }
      else{
        System.out.println("invalid designation");
      }

    }
    else if(display.contains("3")){
      System.out.print("Enter the Designation: ");
      String dest=sc1.next();
      System.out.println("----------------------------------");
      if(dest.contains("Employee")){
        System.out.print("Enter the name of the Employee: ");
        String name=sc1.next();
        System.out.println("----------------------------------");
        editSalary( root, 3,name);
        System.out.println("----------------------------------");
      }
      else{
        System.out.println("invalid designation");
      }
    }
    else if(display.contains("4")){
      System.exit(-1);
     }
      else{
        System.out.println("invalid designation");
      }
      
    }

   else if(tds[0].contains("Employee")&&tds[2]=="true"){
    System.out.println("----------------------------------");
    System.out.println("              "+"MENU"+"             ");
    System.out.println("Display salary and details --> 1");
    System.out.println("Which option you want to acess?");
    System.out.println("----------------------------------");
    String display=sc1.next();
    System.out.println("----------------------------------");
    if(display.contains("1")){
      displaydata( tds,root);
    }
   else if(display.contains("4")){
    exit=false;
   }
    else{
      System.out.println("Invalid option");
    }
    sc1.close();
   }
  
  }
}
