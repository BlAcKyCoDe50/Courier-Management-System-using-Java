import java.util.*;
import java.util.Random;  


public class CourierManagementSystem {
    static Scanner scanner= new Scanner(System.in);
    static Random random = new Random();   
    static Integer id = random.nextInt(2000);
    static String name,Destinaion;
    static String[] Locations= new String[6];
    static String[] new_Locations= new String[1];
   static int ons,size;
    static Integer[] new_id= new Integer[size];
    static int newid;

    static Double packageWeight,cost;
   
   
    private static String[] packages;

    public static void main(String[] args) {
        
        Locations[0]="Jalandhar";
        Locations[1]="Phagwara";
        Locations[3]="Chandigarh";
        Locations[4]="Amritsar";
        Locations[5]="Ludhiana";
        
        
        
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("***************");
        System.out.println("**** Welcome to the Courier Management System ****");
        System.out.println("***************\n");
        do {
            System.out.println("1. Create Shipment");
            System.out.println("2. Track Shipment");
            System.out.println("3. View All Shipments");
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
                    listPackages();
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
        String name = scanner.nextLine();
    
        System.out.print("Enter the weight of the Package in KG: ");
        double packageWeight = scanner.nextDouble();
        scanner.nextLine();
        try {
            if(packageWeight==0){
               System.out.println("You have entered Invalid Weight Please enter Valid weight");
            }
        } catch (Exception e) {
                
        }
    
        if (packageWeight > 50) {
            System.out.println("Sorry!!...We can't deliver the Packages Above 50KG");
            return;
        }
    
        System.out.print("Enter the Destination of the Package: ");
        String destination = scanner.nextLine();
    
        boolean destinationFound = false;
        for (String location : Locations) {
            if (destination.equals(location)) {
                destinationFound = true;
                break;
            }
        }
    
        if (destinationFound) {
            System.out.println("Package added successfully!");
            int id = random.nextInt(2000);
            System.out.println("Your Tracking ID is: " + id);
        } else {
            System.out.println("Sorry, our services are not available in " + destination);
            System.out.println("To send the Package to " + destination + " you have to pay extra charges:");
            System.out.println("NOTE: For other locations we need help of third-party courier services, so the charges may be high compared to domestic locations.");
    
            System.out.print("Enter the name of the Destination: ");
            String newLocation = scanner.nextLine();
    
              newid = random.nextInt(2000);
            System.out.println("Package added successfully!");
            System.out.println("Your Tracking ID is: " + newid);
    
            // add the new location to the Locations array
            String[] newLocations = new String[Locations.length + 1];
            for (int i = 0; i < Locations.length; i++) {
                newLocations[i] = Locations[i];
            }
            newLocations[newLocations.length - 1] = newLocation;
            Locations = newLocations;
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
    public static void listPackages() {
        for (int i = 0; i < packages.length; i++) {
            System.out.println("Package " + (i + 1) + ": " + packages[i]);
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