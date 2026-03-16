import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Household {

    private String ID;
    private String name;
    private String address;
    private LocalDate joinDate;
    private List<RecyclingEvent> events;
    private double totalPoints ;

    public Household(String ID, String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.joinDate = LocalDate.now();
        this.events = new ArrayList<>();
        this.totalPoints = 0.0;
    }

    public String getID(){return this.ID;}
    public String getName(){return this.name;}
    public String getAddress(){return this.address;}
    public LocalDate getJoinDate(){return this.joinDate;}
    public List<RecyclingEvent> getEvents(){return this.events;}
    public double getTotalPoints(){return this.totalPoints;}

    public double getTotalWeight(){
        double total = 0.0;
        for(RecyclingEvent event : this.events){
            total += event.getWeightInKillogram();
        }
        return total;
    }


}

