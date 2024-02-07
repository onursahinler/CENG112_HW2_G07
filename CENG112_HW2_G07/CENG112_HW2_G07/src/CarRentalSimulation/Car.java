package CarRentalSimulation;

public class Car {
	 private String id;
	 private double qualityScore;
	 private int occupancy; // İşgal süresi
	 
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String id, double qualityScore, int occupancy) {
		super();
		this.id = id;
		this.qualityScore = qualityScore;
		this.occupancy = occupancy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getQualityScore() {
		return qualityScore;
	}
	public void setQualityScore(double qualityScore) {
		this.qualityScore = qualityScore;
	}
	public int getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}
}
