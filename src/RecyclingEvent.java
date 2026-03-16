import java.time.LocalDateTime;

public class RecyclingEvent {
    private MaterialType materialType;
    private double weightInKillogram;
    private LocalDateTime recylceDate;
    private int ecoPoints;

    public RecyclingEvent(MaterialType type, double weightInKillogram, LocalDateTime recylceDate, int ecoPoints){
        this.materialType = type;
        this.weightInKillogram = weightInKillogram;
        this.recylceDate = recylceDate;
        this.ecoPoints = ecoPoints;
    }
    private MaterialType getMaterialType() {
        return this.materialType;
    }
    private double getWeightInKillogram() {
        return this.weightInKillogram;
    }
    private LocalDateTime getRecylceDate() {
        return this.recylceDate;
    }
    private int getEcoPoints() {
        return this.ecoPoints;
    }


}
