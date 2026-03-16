import java.time.LocalDate;
import java.time.LocalDateTime;

public class RecyclingEvent {
    private String materialType;
    private double weight;
    private LocalDate recylceDate;
    private Double totalPoints;

    public RecyclingEvent(String type, double weight){
        this.materialType = type;
        this.weight = weight;
        this.recylceDate = LocalDate.now();
        this.totalPoints = this.weight * 10;
    }
    public String getMaterialType() {
        return this.materialType;
    }
    public double getWeightInKillogram() {
        return this.weight;
    }
    public LocalDate getRecylceDate() {
        return this.recylceDate;
    }
    public double getEcoPoints() {
        return this.totalPoints;
    }
    @Override
    public String toString(){
        return "Date:"+ this.recylceDate +
                "\nMaterial Type: "+ this.materialType+
                "\nWeight: "+ this.weight+
                "\nTotal Points: "+ this.totalPoints;

    }





}
