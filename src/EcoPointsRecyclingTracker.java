import java.util.HashMap;
import java.util.Scanner;

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

            }


        }

    }

    private static void registerHouseHold(String id, String name, String address) {
        Household hld = new Household(id,name,address);
        households.put(id, hld);
    }
}
