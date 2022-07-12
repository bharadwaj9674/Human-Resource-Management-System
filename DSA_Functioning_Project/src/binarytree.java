import java.io.*;
import java.util.*;

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
  public static void adisplaydata(String data,Node node) {
    if(node==null){
      return;
    }
    if (data.equals(node.Employee[0])) {
      System.out.println(data);
      String[] t=node.Employee;
      String st="|";

      for(int i=0;i<6;i++){
        st=st+" "+t[i]+" "+"|";
      }
      System.out.println("------------------------------------------");
      System.out.println(st);
      System.out.println("-------------------------------------------");
      return;
    }
  
    adisplaydata(data,node.left);
    adisplaydata(data,node.right);
  }
  public static Node construct(Integer[] arr) throws FileNotFoundException{
    File f=new File("C:\\Users\\anugr\\Desktop\\Project DSA\\salary.txt");
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
  public static void displayContent(String[]check) {
    System.out.println("Which option you want to acess?");
    if(check[0]=="CEO"){
  adisplaydata(check[0],root);
    }
  }
  public static void editSalary(String data,Node node) {

    if(node==null){
      return;
    }
    if (data.equals(node.Employee[1])) {
      System.out.println(node.Employee[1]);
      String[] t=node.Employee;
      String st="|";
      node.Employee[6]="20000";

      for(int i=0;i<7;i++){
        st=st+" "+t[i]+" "+"|";
      }
      System.out.println("------------------------------------------");
      System.out.println(st);
      System.out.println("-------------------------------------------");
      return;
    }
  
    adisplaydata(data,node.left);
    adisplaydata(data,node.right);

  }
  
  public static void main(String[] args)throws FileNotFoundException{
    Integer[] arr={1,2,4,null,null,5,null,null,3,6,null,null,7,null,null};
    construct(arr);
   

  }
}