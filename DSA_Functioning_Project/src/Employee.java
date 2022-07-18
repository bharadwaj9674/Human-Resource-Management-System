import java.io.IOException;
import java.util.Scanner;

public class Employee {
	
	public void employee() throws NumberFormatException, IOException {
        PriorityQueue pr = new PriorityQueue();
        
        System.out.println();
		System.out.println("<------   To-Do List     ------>");
		System.out.println();
		
		System.out.println(terminalColours.CYAN_BRIGHT+"1.To view all tasks"+terminalColours.RESET);
		System.out.println(terminalColours.CYAN_BRIGHT+"2.To view the task that has to be done first"+terminalColours.RESET);
		System.out.println();
		System.out.println("Enter the number to select the following function");
		
		System.out.println();
        System.out.print("Select any of the following function:  ");
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		if(a==1) {
			pr.activateQ();
			pr.Display();
		}
		if(a==2) {
			pr.activateQ();
			pr.getMin();
		}
		
		scan.close();
	}

}