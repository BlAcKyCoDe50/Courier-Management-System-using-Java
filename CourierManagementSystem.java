import java.util.*;
import java.util.Random;

// import javafx.scene.paint.Stop;  


public class CourierManagementSystem {
    static Scanner scanner= new Scanner(System.in);
    static Random random = new Random();   
    static Integer id = random.nextInt(2000);
    static String name,Destinaion;
    static String[] Locations= {"Jalandhar","Phagwara","Chandigarh","Amritsar","Ludhiana"};
    static String[] new_Locations= new String[1];
   static int ons,size;
    static Integer[] new_id= new Integer[size];
    static int newid;
    static String[] newLocations = new String[1];
    // static String[] Admin= new String[3];
    

    static Double packageWeight,cost;
    static String Admin[]={"Vishvajeet","Nikhil","Dipanshu"};
    static Integer[] Admin_Pass={6267,72096,9111};
    private static String[] packages;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("***************");
        System.out.println("**** Welcome to the Courier Management System ****");
        System.out.println("***************\n");
        do {
            System.out.println("1. Create Shipment");
            System.out.println("2. Track Shipment");
            System.out.println("3. View All Shipments  (For Admin)");
            System.out.println("4. View Invoice");
            System.out.println("5. Exit");
            System.out.println("6. Return to Main Menu");
            System.out.print("Choose an option: ");
    
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    addPackage();
                    break;
                case 2:
                    trackPackage();
                    break;
                case 3:
                view_All_Shipmetns();
                    break;
                case 4:
                    viewInvoice();
                    break;
                case 5:
                    System.out.println("Exiting......");
                    break;
                case 6:
                    System.out.println("Return to main Menu");
                 default:
                    System.out.println("!!Oops Invalid Option Try Again :(");
            }
        } while (option != 5);
    }
//Create Shipment
    public static void addPackage() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter the name of the Package: ");
        String name = scanner.next();
    
        System.out.print("Enter the weight of the Package in KG: ");
        double packageWeight = scanner.nextDouble();
        // scanner.nextLine();

    while (packageWeight <= 0 || packageWeight > 50) {
    if (packageWeight == 0) {
        System.out.println("You have entered an invalid weight. Please enter a valid weight.");
        System.out.println("Enter the weight again: ");
        packageWeight = scanner.nextDouble();
    } else if (packageWeight > 50) {
        System.out.println("Sorry! We cannot deliver packages above 50KG.");
        System.out.println("Enter the weight again: ");
        packageWeight = scanner.nextDouble();
        scanner.nextLine();
    }
}
    
    System.out.println("Enter the Destination of the Package:- ");
    String destination=scanner.next();
    
        boolean destinationFound = true;
        for (int i=0;i<Locations.length;i++) {
            if (Locations[i]==destination) {
                destinationFound = false;
                System.out.println(destinationFound);
                break;
            }
        }
        System.out.println(destinationFound);
    
        if (destinationFound==false) {
            System.out.println("Package added successfully!");
            int id = random.nextInt(2000);
            System.out.println("Your Tracking ID is: " + id);
        } 
        else {
            
            System.out.println("Sorry, our services are not available in " + destination);
            System.out.println("To send the Package to " + destination + " you have to pay extra charges:");
            System.out.println("NOTE: For other locations we need help of third-party courier services, so the charges may be high compared to domestic locations.");
    
            System.out.print("Enter the name of the Destination: ");
            String newLocation = scanner.next();
    
            newid = random.nextInt(2000);
            System.out.println("Package added successfully!");
            System.out.println("Your Tracking ID is: " + newid);
    
            // add the new location to the Locations array
            
            for (int i = 0; i < newLocations.length; i++) {
                newLocations[i]=newLocation;
            }
            
        }
    }
    

            
    //track Shipment 
    public static void trackPackage() {
        //    System.out.println("This Functionality is Coming Soon....:)");
        System.out.println("Enter the Tracking id of the Package:- ");
        int track_id=scanner.nextInt();
        int time=random.nextInt(10);
        if (track_id==id || track_id==newid) {
            System.out.println("Your Package will be Delivered Within "+time+" Hour at your Desired Destination");
            System.out.println("Thanks for choosing Our Service :)");
        }
        else{
            System.out.println("Your Package was not Found....");
            
        }
    }

    
    //View all Shipments
    public static void view_All_Shipmetns() {
        boolean t1=false;
        
        System.out.println("Enter  Admin ID:- ");
        String Admin_id=scanner.next();
        if (t1==false) {
            for (int i = 0; i < Admin.length;i++) {
                if(Admin[i]==Admin_id)
                    t1=true;
            }
        } 
        else 
        {
            System.out.println("Invalid Admin ID...!!");
        }
        
        System.out.println("Enter  Admin Password:- ");
        int adminpass=scanner.nextInt();
        System.out.println(t1);
        if (t1==false) {
            for (int i = 0; i<Admin_Pass.length;i++) {
                if(Admin_Pass[i]==adminpass)
                    System.out.println("Login Successfull.....");
                }
        } else {
            System.out.println("Invalid Password...!!");
            System.out.println("Exiting.........");
            System.exit(0);
        }
        
        System.out.println("\nEnter the Destination Type:- \n1.Predefined Locations\n2.Custom Locations");
        int loc_type=scanner.nextInt();
        switch (loc_type) {
            case 1:
                for (int i = 0; i < Locations.length; i++) {
                    System.out.println("*"+Locations[i]+"\n");
                }
                break;
        
            case 2:
                for (int i = 0; i < newLocations.length; i++) {
                    System.out.println(newLocations[i]);
                }
                break;
            
                default:
                    System.out.println("Invalid Input...");
                break;
        }
        
    }
//View Invoice
    public static void viewInvoice() {
        // System.out.println("This Functionality is Coming Soon....");
        System.out.println("Enter the ID of the Package :- ");
        int invoice_id=scanner.nextInt();
        if (invoice_id==id) {
            System.out.println("Thanks...");   
            System.out.println("************************************");        
            System.out.println("                                        ");
            System.out.println("ID:- "+id);
            System.out.println("Package:- "+name);
            System.out.println("Destination:- "+Destinaion);
            System.out.println("Weight:- "+packageWeight);
            Double cost=50*packageWeight;
            System.out.println("Total Cost:- "+cost);
            System.out.println("***********************************************************");
            System.out.println("Thanks for Choosing Our Service :)");
            
    }
         else{
            System.out.println("Thanks...");   
            System.out.println("************************************");        
            System.out.println("                                        ");
            System.out.println("ID:- "+id);
            System.out.println("Package:- "+name);
            System.out.println("Destination:- "+Destinaion);
            System.out.println("Weight:- "+packageWeight);
           Double cost= 50*packageWeight;
            System.out.println("Total Cost:- "+cost);
            System.out.println("75 Rupees/KG Additional Charges...");
            System.out.println("***********************************************************");
            System.out.println("Thanks for Choosing Our Service :)");
        }
        while(invoice_id==id){
        if(invoice_id!=id){
            System.out.println("Invalid Package id...");
        }
        }
    //  
      
    }
    
}
//