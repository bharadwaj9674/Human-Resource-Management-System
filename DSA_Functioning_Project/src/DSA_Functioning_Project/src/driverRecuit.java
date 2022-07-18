import java.util.*;
class driverRecuit extends recuit
{
    static Scanner sc=new Scanner(System.in);
    void menu() throws java.io.IOException
    {
        System.out.println("choose one of the choices:");
        System.out.println("1.continue the recruitment process with next candidate");
        System.out.println("2.stop the recruitment process");
        int ch=sc.nextInt();
        if(ch==2)
        {    
            System.out.println("RECRUITMENT PROCESS FIRST STAGE COMPLETED");
            System.out.println("THE MANAGER WILL CALL THE CANDIDATES FOR SECOND STAGE");
            System.exit(0);
        }
        else if(ch==1)
        {
            call();
            menu();
        }
        else
        {
            System.out.println("invalid entry");
            System.exit(0);
        }
    }
    void call() throws java.io.IOException
    {
        main_recuit();
    }
    public static void main(String args[]) throws java.io.IOException
    {
        driverRecuit ob=new driverRecuit();
        System.out.println("WELCOME TO RECRUITMENT SECTION");
        ob.accept();
        ob.menu();
    }
}