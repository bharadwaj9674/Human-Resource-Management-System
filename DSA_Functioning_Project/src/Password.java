import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Password {
   public String UsernamePassword(){
      Scanner sc=new Scanner(System.in);
      System.out.println("----------------------------------------------------");
      System.out.println("                      "+"LOGIN"+"                       ");
      System.out.println("-----------------------------------------------------");
      System.out.print("Username:");
      String username=sc.nextLine();
      System.out.print("Password:");
      String password=sc.nextLine();
      String t=username+","+password;
      System.out.println("----------------------------------------------------");
      sc.close();

      return t;
   }
   public String checkUsernamePassowrd(String[] l)throws FileNotFoundException{
      File f=new File("C:\\Users\\anugr\\Desktop\\Project DSA\\passwordUsername.txt");
      Scanner fsc=new Scanner(f);
      while(fsc.hasNextLine()){
         String t=fsc.nextLine();
         String[] ceo=t.split(",");
          if(ceo[1].contains(l[0])&&(ceo[2].contains(l[1]))){
            fsc.close();
            return "true";
          }
   }
   fsc.close();
   return "false";
}

    public String[] passowrdUsername(String d)throws FileNotFoundException{
     if(d.contains("CEO")){
      String[] l=UsernamePassword().split(",");
      String c=checkUsernamePassowrd(l);
      String[] st=new String[3];
      st[0]="CEO";
      st[1]=l[0];
      st[2]=c;
     return st ;

   }
     else if(d.contains("Manager")){
      String[] l=UsernamePassword().split(",");
      String c=checkUsernamePassowrd(l);
      String[] st=new String[2];
      st[0]=d;
      st[1]=c;
     return st ;
     }
     else if(d.contains("Employee")){
      String[] l=UsernamePassword().split(",");
      String c=checkUsernamePassowrd(l);
      String[] st=new String[2];
      st[0]=d;
      st[1]=c;
     return st ;
    
     }
     else{
        System.out.println("----------------------------------------------------");
        System.out.println(""+"|" +"                 "+"ERROR "+"                     "+ "      "+"|");
        System.out.println("----------------------------------------------------");
     }
     String[] st=new String[2];
     st[0]=d;
     st[1]="none";
    return st ;
    }
    
}
