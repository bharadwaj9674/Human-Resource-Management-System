import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class announcements {
	
	public void callAnnouncements() throws IOException {
		
		Stack s = new Stack();
		
		
		
		System.out.println(terminalColours.RED_BOLD_BRIGHT+"<______________Announcements______________>"+terminalColours.RESET);
		System.out.println();
		System.out.println("1.Director");
		System.out.println("2.Manager");
		System.out.println("3.Employee");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your position: ");
		int position = scan.nextInt();
		System.out.println();
		
		
		switch(position) {
		
		// Director
		
        case 1:
        	s.activateStack(s);
        	System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"<---------Announcements--------->"+terminalColours.RESET);
        	System.out.println();
        	System.out.println(terminalColours.GREEN_BRIGHT+"1.Add announcement"+terminalColours.RESET);
        	System.out.println(terminalColours.RED_BRIGHT+"2.Remove announcements"+terminalColours.RESET);
        	System.out.println(terminalColours.CYAN_BRIGHT+"3.View latest announcements"+terminalColours.RESET);
        	System.out.println(terminalColours.PURPLE_BRIGHT+"4.View all announcements"+terminalColours.RESET);
        	System.out.println();
        	System.out.print("Enter the function you have to perform: ");
        	int function = scan.nextInt();
        	
        	// Adding announcements
        	
        	if(function==1) {
        		System.out.println();
        		System.out.println("1.Add single announcement");
        		System.out.println("2.Add multiple announcements");
        		System.out.println();
        		FileWriter f = new FileWriter("/Users/bharath/Desktop/DSA_Project/announcements.txt",true);
    			PrintWriter fw = new PrintWriter(f);
        		System.out.print("Enter the function you have to perform: ");
        		int multF = scan.nextInt();
        		System.out.println();
        		System.out.println();
        		if(multF==1) {
        			System.out.print("Enter the announcement you want to add:  ");
        			String task = sc.nextLine();
        			System.out.println();
        			
        			fw.println(task);
        			
        			
        			s.push(task);
        			System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"Successfully added announcement.....!"+terminalColours.RESET);
        		}
        		if(multF==2) {
        			System.out.println();
        			System.out.print("Enter the number of announcements you need to add: ");
        			int numF = scan.nextInt();
        			System.out.println();
        			for(int i=0;i<numF;i++) {
        				System.out.print("Enter the announcement you want to add:  ");
            			String task = sc.nextLine();
            			fw.println(task);
            			System.out.println();
            			s.push(task);
        			}
        			System.out.println();
        			System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"Successfully added announcements.....!"+terminalColours.RESET);
        			
        			fw.close();
        		}
        	}
        	
    		// Removing announcements
        	
        	if(function==2) {
    			System.out.println();
        		System.out.println("1.Remove single announcement");
        		System.out.println("2.Remove multiple announcements");
        		System.out.println();
        		System.out.print("Enter the function you have to perform: ");
        		
        		int remF = scan.nextInt();
        		System.out.println();
        		if(remF==1) {
        			s.pop();
        			System.out.println(terminalColours.RED_BRIGHT+"Removed the announcement"+terminalColours.RESET);
        		}
        		if(remF==2) {
        			
        			System.out.println();
        			System.out.print("Enter the number of announcements you wanted to remove: ");
        			int remM = scan.nextInt();
        			for(int i=0;i<remM;i++) {
        				s.pop();
        			}
        			System.out.println(terminalColours.RED_BRIGHT+"Removed the announcements"+terminalColours.RESET);
        		}	
        	}
        	
        	
        	// Viewing the latest announcement
        	
        	
        	if(function==3) {
    			System.out.println();
        		System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"<---------Latest Announcement--------->"+terminalColours.RESET);
        		System.out.println();
        		s.peek();
    		}
        	
        	if(function==4) {
        		System.out.println();
        		System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"<---------Latest Announcement--------->"+terminalColours.RESET);
        		System.out.println();
        		s.printAll();
        	}
        	
        	break;
        	
        	// Manager
        	
        case 2:
        	s.activateStack(s);
        	System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"<---------Announcements--------->"+terminalColours.RESET);
        	System.out.println();
        	System.out.print(terminalColours.GREEN_BRIGHT+"Enter 0 to view the latest announcement...!"+terminalColours.RESET+" :");
        	int b = scan.nextInt();
        	
        	
        	
        	if(b==0) {
        		System.out.println();
        		System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"<---------Latest Announcement--------->"+terminalColours.RESET);
        		System.out.println();
        		s.peek();
        	}
        	break;
        	
        	// Employee
        	
        case 3:
        	s.activateStack(s);
        	System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"<---------Announcements--------->"+terminalColours.RESET);
        	System.out.println();
        	System.out.println(terminalColours.GREEN_BRIGHT+"1.View the latest announcements"+terminalColours.RESET);
        	System.out.println(terminalColours.GREEN_BRIGHT+"2.View all announcements"+terminalColours.RESET);
        	System.out.print("Enter any one of the function:  ");
        	int a = scan.nextInt();
        	
        	
        	if(a==1) {
        		System.out.println();
        		System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"<---------Latest Announcement--------->"+terminalColours.RESET);
        		System.out.println();
        		s.peek();
        	}
        	
        	if(a==2) {
        		System.out.println();
        		System.out.println(terminalColours.GREEN_BOLD_BRIGHT+"<---------All Announcements--------->"+terminalColours.RESET);
        		System.out.println();
        		s.printAll();
        	}
        	
        	break;
        	
        default:
        	System.out.println("Please enter the valid number");	
		}
		scan.close();
		sc.close();
    }
	
}
