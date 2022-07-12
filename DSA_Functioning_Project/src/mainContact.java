import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class mainContact {
	
	public void contactShow() {
		
		System.out.println("PHONE BOOK ");
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
                case "list":
                    contactFunctions.listContacts(contacts);
                    break;
                case "show":
                	contactFunctions.showContact(contacts, input);
                    break;
                case "find":
                	contactFunctions.findContact(contacts, input);
                    break;
                case "add":
                	contactFunctions.addContact(contacts, input);
                    break;
                case "edit":
                	contactFunctions.editContact(contacts, input);
                    break;
                case "delete":
                	contactFunctions.deleteContact(contacts, input);
                    break;
                case "help":
                	contactFunctions.listCommands();
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }


            System.out.print("\n> ");
            line = input.nextLine().trim();
        }

        System.out.println("Phone Book");
		
	}
}
		

