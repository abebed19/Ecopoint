import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class EcoPointsRecyclingTracker {

    private static Scanner scanner = new Scanner(System.in);

    private static HashMap<String , Household> households = new HashMap<>();

    public static  void main(String ... args){


        boolean running = true;
        while(true){

            System.out.println("\n=== Eco-Points ReCycling  Tracker ===");
            System.out.println("1. Register Household");
            System.out.println("2. Log Recycling Event");
            System.out.println("3. Display Households");
            System.out.println("4. Display Household recycling Events");
            System.out.println("5. Generate Reports");
            System.out.println("6. Save and exit");
            System.out.print("Choose an option:");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    System.out.println("Please enter unique id:");
                    String id = scanner.nextLine();
                    System.out.println("Please enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Please provide address:");
                    String address = scanner.nextLine();
                    registerHouseHold(id, name, address);
                    break;
                case "2":
                    logReccyclingEvent();
                    break;
                case "3":
                    displayHouseholds();
                    break;

                case "4":
                    displayHouseholdEvents();
                    break;
                case "5":
                    generateReports();
                    break;
                case "6":
                    saveHouseholdsToFile();
                    break;

            }


        }

    }

    private static void registerHouseHold(String id, String name, String address) {
        Household hld = new Household(id,name,address);
        households.put(id, hld);
        System.out.println("Household registered successfully on "+ hld.getJoinDate());

    }
    private static void logReccyclingEvent(){
        System.out.println("Enter household id:");
        String id = scanner.nextLine().trim();

        Household hld = households.get(id);
        if (hld == null){
            System.out.println("Household with id " + id + " not found");
            return;
        }

        System.out.println("Enter material type(Plastic /glass/metal/paper");
        String material = scanner.nextLine().trim();
        double weight = 0.0;

        while(true){
            try{
                System.out.println("Please enter weight in kilogram:");
                weight = Double.parseDouble(scanner.nextLine());

                if(weight <= 0) throw new IllegalArgumentException();
                break;

            }catch (NumberFormatException e){
                System.out.println("Please enter valid weight");
            }catch (IllegalArgumentException e){
                System.out.println("Please enter valid weight");

            }
        }

        RecyclingEvent event = new RecyclingEvent(material, weight);
        hld.addEvent(event);
        System.out.println("Event registered successfully on "+ hld.getJoinDate() );


    }

    public static void displayHouseholds(){
        if(households.isEmpty()){
            System.out.println("No Households found");
            return;
        }

        for(Household h : households.values()){
            System.out.println("ID : " + h.getID()+
                    " ,Name: "+ h.getName()+
                    " ,Address: "+ h.getAddress()+
                    ", Joined: "+ h.getJoinDate()
            );
        }
    }

    public static void displayHouseholdEvents(){
        System.out.println("Enter household id: ");
        String id = scanner.nextLine().trim();

        Household hld = households.get(id);
        if(hld == null){
            System.out.println("Household with id " + id + " not found");
            return;
        }

        System.out.println("Recycling events for "+ hld.getName()+":" );
        if(hld.getEvents().isEmpty()){
            System.out.println("No Recycling events found");
        }else{
            for(RecyclingEvent e : hld.getEvents()){
                System.out.println(e);
            }
            System.out.println("Total Weights: "+ hld.getTotalWeight());
            System.out.println("Total Points: "+ hld.getTotalPoints());

        }

    }

    public static void generateReports(){
        if(households.isEmpty()){
            System.out.println("No Households found");
            return;
        }
        Household top = null;
        for(Household h : households.values()){
            if(top == null|| top.getTotalPoints() < h.getTotalPoints()){
                top = h;
            }
        }
        System.out.println("\n Household with highest points: ");
        System.out.println("Id: " + top.getID()+
                   ", Name " + top.getName()+
                   ", Address "+ top.getAddress()

                );

        double totalWeight = 0.0;
        for(Household h : households.values()){
            totalWeight += h.getTotalWeight();
        }
        System.out.println("Total Community Recycling Weight: "+ totalWeight);
    }
    public  static void saveHouseholdsToFile(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("households.ser"));
            out.writeObject(households);

        }catch (IOException e){
            System.out.println("Error saving Households to file "+e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static void loadHouseholdsFromFile(){
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("households.ser"));
            households = (Map<String,Household>) in.readObject();
            System.out.println("Households loaded successfully");

        }catch (FileNotFoundException e){
            System.out.println("Households file not found");
        }
        catch (IOException e){
            System.out.println("Error in loading Households from File "+e.getMessage());
        }
    }
}
