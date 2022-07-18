import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class mainContact {
	
	public void callContact() {

        System.out.println("CONTACT MANAGEMENT SYSTEM");
        System.out.println("===========================");
        System.out.println("Type a command or 'exit' to quit:");
        contactFunctions.listCommands();
        System.out.print("> ");

        Map<String, List<String>> contacts = new TreeMap<>();
        contactFunctions.loadContact(contacts);

        Scanner input = new Scanner(System.in);
        String line = input.nextLine().trim();

        while (!line.equals("exit")) {

            switch (line) {
                case "1":
                	contactFunctions.listContacts(contacts);
                    break;
                case "2":
                	contactFunctions.showContact(contacts, input);
                    break;
                case "3":
                	contactFunctions.findContact(contacts, input);
                    break;
                case "4":
                	contactFunctions.addContact(contacts, input);
                    break;
                case "5":
                	contactFunctions.editContact(contacts, input);
                    break;
                case "6":
                	contactFunctions.deleteContact(contacts, input);
                    break;
                case "7":
                	contactFunctions.listCommands();
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
            System.out.print("\n> ");
            line = input.nextLine().trim();
        }
        System.out.println("'CONTACT MANAGEMENT SYSTEM'");
	}
}


		

