import java.time.LocalDateTime;

public class Household {

    private int ID;
    private String name;
    private String address;
    private LocalDateTime joinDate;

    public Household(int ID, String name, String address, LocalDateTime joinDate) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.joinDate = joinDate;
    }

    public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public LocalDateTime getJoinDate(){
        return this.joinDate;
    }

    public void setID(int ID){
        this.ID = ID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setJoinDate(LocalDateTime joinDate){
        this.joinDate = joinDate;
    }
}

