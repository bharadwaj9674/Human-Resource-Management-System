import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
	
	public static void main(String[]args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1.Recruitment");
		System.out.println("2.To Do List");
		System.out.println("3.Annoucements");
		System.out.println("4.Salary");
		System.out.println("5.Contact List");
		System.out.println("6.Apply for the company");
		
		
		System.out.print(terminalColours.WHITE_BACKGROUND_BRIGHT+terminalColours.RED_BOLD_BRIGHT+"Select any of the above:"+terminalColours.RESET+"  ");
		
		int a = scan.nextInt();
		
		switch(a) {
            case 1:
            	recuitQueue recQ = new recuitQueue();
            	recQ.callRecuit();
            	break;
            	
            case 2:
            	toDoLogin login = new toDoLogin();
            	login.login();
                break;	
            case 3:
            	announcements announcement = new announcements();
            	announcement.callAnnouncements();
            	break;
            case 4:
            	binarytree b = new binarytree();
            	b.mainBinary();
            	
            	break;
            case 5:
            	mainContact contact = new mainContact();
            	contact.callContact();
            	break;
            case 6:
            	recuit rec = new recuit();
            	rec.main_recuit();
            	break;
            	
		    default:
		    	System.out.println("Please enter a valid number.....!");
		}
		scan.close();
	}
}
