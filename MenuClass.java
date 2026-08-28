package FinalCode;



import java.util.InputMismatchException;
import java.util.Scanner;
import FinalCode.Feature1.Item;
import FinalCode.Feature6;


public class MenuClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Feature1 f1 = new Feature1();
		Feature2 f2 = new Feature2();
		
		// assume that the number of buildings is 7
		Feature3 f3 = new Feature3(4);
		Feature4 f4 = new Feature4();
		Feature5 f5 = new Feature5();
		Feature6 f6 = new Feature6();


		int choice=-1;
		do {
			
			try {
				
			
			System.out.println("Welcome to campus Management Syatem");
			System.out.println(" 1 for Lost and Found");
			System.out.println(" 2 for Room Booking");
			System.out.println(" 3 for Orientation Help ");
			System.out.println(" 4 for Undo/Redo ");
			System.out.println(" 5 for Event Participation Registration ");
			System.out.println(" 6 for Student Locker Allocation ");
			System.out.println(" 0 for exit ");
			System.out.println();
            choice = sc.nextInt(); 
            // clear the newline from input buffer
            sc.nextLine();
            
    		if (choice == 1) {
				showLostFoundMenu(sc, f1);  }
			
			
			if(choice ==2) {
				showBookingMenu(sc, f2);}
			
			if(choice ==3) {
				showOrientationHelpMenu(sc, f3);}
			
			
			if ( choice ==4 ) {
				showRedoUndoMenu(sc, f4); }
 
			if (choice == 5) {
				showregister(sc, f5); }

			if (choice == 6) {
				LockerAllocation(sc, f6); }		
			
			}catch(InputMismatchException e) {
				System.out.println("Invalid iNPUT");
				
			}
			
		 } while(choice != 0);
		
		
        System.out.println("System closed ");
        
        

	}

	
	
	
	// menus for each feature:	
		
		
	
	
	
		
		
	// menu for feature 1 : lost and found
	public static void showLostFoundMenu(Scanner sc, Feature1 f1 ) {
		
		int choice ;
		do {
		System.out.println("Lost and found menu");
		System.out.println(" 1. Add lost item \n 2. search for item \n 3. display all lost items");
		choice = sc.nextInt();
        // clear the newline from input buffer
        sc.nextLine();
        
		switch(choice) {
		   case 1:
			   
			   System.out.println("name: ");
			   String name = sc.nextLine();
				if( name == null || name.isEmpty() ) {
					System.out.println("name cannot be empty\n");
					return;}
				
				
			   System.out.println("description: ");
			   String des = sc.nextLine();
				if( des == null || des.isEmpty() ) {
					System.out.println("description cannot be empty\n");
					return; }
				
				
			   System.out.println("Location: ");
			   String loc=sc.nextLine();
				if(  loc == null || loc.isEmpty() ) {
					System.out.println("Location cannot be empty\n");
					return;}
				
				
			   System.out.println("Date YYYY-MM-DD: ");
			   String date = sc.nextLine();
				if( date == null || date.isEmpty()) {
					System.out.println("Date cannot be empty\n");
					return;}
				
				
			   int id=(int)(Math.random()*10000);
			   f1.addItem(id, name, des, loc, date);
			   break;
			   
			   
		
		  case 2:
			 System.out.println("Entre key to search (name or description");
			 String key = sc.nextLine();
			 Item found=f1.search(key);
			 if(found != null) {
			    System.out.println("Found : "+found);
			    System.out.println("You want to remove the found item? ");
			    String answer = sc.nextLine();
			    if(answer.equalsIgnoreCase("yes")) {
			     	 f1.removeItem(found.id);
				 
			 }else {
				 System.out.println("Not found");
			 }
			 }
			 break;
			 
		 case 3:
			 f1.displayAllItems();
  	          break;
   	          
   	          
	     default:
	        	System.out.println("Invalid choice");
	        	}}while(choice!=0); 
             
   	          
   	          
 	
	}
	
	
	
	
	// menu for feature 2 : Room Booking
	public static void showBookingMenu(Scanner sc, Feature2 f2 ) {
		int choice ;
		do {
		System.out.println("Booking menu");
		System.out.println(" 1. Add Booking \n 2. process next booking \n 3.Show next booking \n 4. display all lost items");
		choice = sc.nextInt();
        // clear the newline from input buffer
        sc.nextLine();
        
        switch (choice) {
		case 1:
			   System.out.print("name: ");
			   String name = sc.nextLine();
			   if( name == null || name.isEmpty() ) {
					System.out.println("name cannot be empty\n");
					return;}
			   
			   
			   System.out.print("id: ");
			   int id = sc.nextInt();
			   
			   System.out.print("Booking hours: ");
			   float hour=sc.nextFloat();
			   if(hour >10) { System.out.println("you cannot book more than 10 hr 1");
			   break;}
			   sc.nextLine(); // clear newline
			   f2.addBooking(name, id, hour);
			   break;
		
		  case 2:
			f2.processBookings();
			 break;
			 
		 case 3:
			f2.peek(); 
			break;
			
		 case 4:
			 f2.displayAllBookings();
			 break;
			 
		 case 0 :
			 System.out.println("Back to the main menu");
  	          break;
   	          
   	          
	     default:
	        	System.out.println("Invalid choice");			 
			 }}while(choice != 0); }

	

	
	// menu for feature 3 : show Orientation Help
	public static void showOrientationHelpMenu(Scanner sc, Feature3 f3 ) {
		int choice ;
		do {
		System.out.println("Orientation Help menu");
		System.out.println(" 1. Add path between buildings \n 2. Find shortest path \n 0 back to main menu");
		choice = sc.nextInt();
        // clear the newline from input buffer
        sc.nextLine();
        
        switch (choice) {
        
		case 1:
			System.out.println("Entre start building: 0 to "+(f3.buildNum-1)+" :");
			int from=sc.nextInt();
			
	
			System.out.println("Entre destination building: 0 to "+(f3.buildNum-1)+" :");
			int to=sc.nextInt();
			
			
			System.out.println("Entre distance between buildings :  ");
			int dis=sc.nextInt();
			
	        sc.nextLine();

	        f3.addPath(from,to,dis);
	        break;
			
			
		case 2:
			System.out.println("Entre start building: 0 to "+(f3.buildNum-1)+" :");
			int start=sc.nextInt();
	
			System.out.println("Entre destination building: 0 to "+(f3.buildNum-1)+" :");
			int end=sc.nextInt();
	
	        sc.nextLine();

	        f3.findShortestPath(start, end);
	        break;
	        
	        
		 case 0 :
			 System.out.println("Back to the main menu");
  	          break;
   	          
   	          
	     default:
	        	System.out.println("Invalid choice");
	        	
		}}while(choice != 0); }
			
	
	
	
	
	
	
	
	
	
	
	// menu for feature 4 : Undo/Redo
	public static void showRedoUndoMenu(Scanner sc, Feature4 f4 ) {
		int choice ;
		do {
             System.out.println("\n Undo Redo menu");
             System.out.println("1. perform action \n 2. Undo \n 3.Redo \n 4.Show all actions \n 0 back to menu");
	         choice = sc.nextInt();
	         sc.nextLine();

	         switch (choice) {
	         
	         
	         case 1:
	        	 System.out.println("Add action: ");
	        	 String x = sc.nextLine();
	        	 f4.doAction(x);
	        	 break;
	        	 
	        	 
	         case 2:
	        	 f4.undo();
	        	 break;
	        	 
	         case 3:
	        	 f4.redo();
	        	 break;
	         case 4:
	        	 f4.showActions();
	        	 break;
	        	 
	         case 0:
	        	 System.out.println("Back to menu: ");
      	          break;
       	          
       	          
		     default:
		        	System.out.println("Invalid choice");
		        	
	         }}while(choice!=0); }
	
	
	
	
	
	
	// menu for feature 5 : Event Participation Registration
	public static void showregister(Scanner sc, Feature5 f5 ) {
		int choice ;
		do {
			 System.out.println("\n Event Participation Registration menu");
             System.out.println("1. Register student \n 2. Process next registration \n 3.Show all registrations \n 0 back to menu");
	         choice = sc.nextInt();
	         sc.nextLine();

	         switch (choice) {
     
	         case 1:
	        	 System.out.println("Add name: ");
	        	 String x = sc.nextLine();
	        	 
	        	 if( x == null || x.isEmpty() ) {
						System.out.println("name cannot be empty\n");
						return;}
	        	 
	        	 
	        	 
	        	 System.out.println("Add id: ");
	        	 int id = sc.nextInt();	
	        	 
	        	 if( id<=0 ) {
						System.out.println("id cannot be less than 0 \n");
						return;}
	        	 
	        	 f5.register(x, id);
	        	 break;
   	 
	         case 2:
	        	 f5.processRegisteration();
	        	 break;
	        	 
	         case 3:
	        	 f5.displayAllRegistration();
	        	 break;
	
		     case 0:
       	          System.out.println("Back to main menu: ");
       	          break;
       	          
       	          
		     default:
		        	System.out.println("Invalid choice");
        }}while(choice!=0); }
	
	
	
	
	
	
	
	// menu for feature 6 : Student Locker Allocation
	public static void LockerAllocation(Scanner sc, Feature6 f6 ) {
		int choice ;
		do {
			 System.out.println("\n Student Locker Allocation menu");
             System.out.println("1. Assign a locker for student \n 2. search for locker by student id \n 3.Show all lockers \n 0 back to menu");
	         choice = sc.nextInt();
	         sc.nextLine();

	         switch (choice) {
     
	         case 1:
	        	 System.out.println("Add student id: ");
	        	 int id = sc.nextInt();	   
	        	 if( id<=0 ) {
						System.out.println("id cannot be less than 0 \n");
						return;}
	        	 
	        	 
	        	 System.out.println("Add locker number: ");
	        	 int lockNum = sc.nextInt();	
	        	 if( lockNum<=0 ) {
						System.out.println("lockNum cannot be less than 0 \n");
						return;}
	        	 
	        	 sc.nextLine();
	        	 f6.assignLocker(id, lockNum);
	        	 break;
	        	 
	        	 
	        	 
	         case 2:
	        	 System.out.println("Entre student id to search: ");
	        	 int stdID = sc.nextInt();	 
	        	 sc.nextLine();
	        	 if( stdID<=0 ) {
						System.out.println("id cannot be less than 0 \n");
						return;}
	        	 
	        	 
	        	 Feature6.Node found = f6.searchLocker(stdID);
	        	 if(found !=null) {
	        		 System.out.println("Found , the locker number is "+found.lockerID);
	        	 }break;


	        	 
	         case 3: 
	        	 f6.displayAll();
	        	 break;
	        	 
	         case 0: 
	        	 System.out.println("Back to main menu.....");
	        	 
	        default:
	        	System.out.println("Invalid choice");
	         }
	         }while(choice!=0);
		}
	
	

	
	
	
	
	
	
	
	
	
	
	
}
