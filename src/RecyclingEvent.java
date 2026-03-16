import java.time.LocalDate;
import java.time.LocalDateTime;

public class RecyclingEvent {
    private MaterialType materialType;
    private double weightInKillogram;
    private LocalDate recylceDate;
    private int ecoPoints;

    public RecyclingEvent(MaterialType type, double weightInKillogram, LocalDate recylceDate, int ecoPoints){
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
    private LocalDate getRecylceDate() {
        return this.recylceDate;
    }
    private int getEcoPoints() {
        return this.ecoPoints;
    }

    public  void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }
    public void setWeightInKillogram(double weightInKillogram) {
        this.weightInKillogram = weightInKillogram;
    }
    public void setRecylceDate(LocalDate recylceDate) {
        this.recylceDate = recylceDate;
    }
    public void setEcoPoints(int ecoPoints) {
        this.ecoPoints = ecoPoints;
    }



}
