import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
	
	public static void main(String[]args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1.To Do List");
		System.out.println("2.Contact List");
		System.out.println("3.Salary");
		
		System.out.print(terminalColours.WHITE_BACKGROUND_BRIGHT+terminalColours.RED_BOLD_BRIGHT+"Select something:"+terminalColours.RESET+"  ");
		
		int a = scan.nextInt();
		
		switch(a) {
            case 1:
            	Login login = new Login();
            	login.login();
			break;
            case 2:
            	mainContact contact = new mainContact();
            	contact.contactShow();
			

		    default:
		    	System.out.println("Please enter a valid number.....!");
		}
		scan.close();
	}
}
