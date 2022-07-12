import java.io.FileNotFoundException;
import java.util.Scanner; 
public class Main{
    public static void main(String[] args)throws FileNotFoundException {
    binarytree bt=new binarytree();
    //Password p=new Password();
    System.out.println("----------------------------------------------------");
    System.out.println(""+"|" +"             "+"Salary" +" "+"MENU"+"                           "+"|"+ " ");
    System.out.println("----------------------------------------------------");
    System.out.println("Enter your designation");
    System.out.println("1.Employee");
    System.out.println("2.Manager");
    System.out.println("3.CEO");
    System.out.println("----------------------------------------------------");
    Scanner sc=new Scanner(System.in);
    System.out.print("Designation:");
    String st=sc.nextLine();
   //String[] tds= p.passowrdUsername(st);
   sc.close();
   //if(tds[0].contains("CEO")&&tds[2]=="true"){
    System.out.println("----------------------------------");
    System.out.println("              "+"MENU"+"             ");
    System.out.println("Display salary --> 1");
    System.out.println("Display salary of subordinates --> 2");
    System.out.println("Bonus salary for subordinates --> 3");
    System.out.println("Which option you want to acess?");
    Scanner sc1=new Scanner(System.in);
    System.out.println(sc1.nextLine());
    String display=sc1.next();
   if(display=="1"){
      bt.displayContent(tds);
    }
    else if(display=="2"){
      System.out.println("Enter the subordinate name:");
      String sub="rishab";
      bt.adisplaydata(sub,bt.root);
      

    }
    else if(display=="3"){
      bt.editSalary(tds[0],bt.root);
    }
    else{
      System.out.println("ERROR");
    }
    
    System.out.println("----------------------------------");
   }
    }
