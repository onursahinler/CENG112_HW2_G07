package CarRentalSimulation;

import java.util.Date;

public class Customer {
	private String id;
    private double qualityThreshold;
    private Date joinDate; // Bekleme listesine eklenme tarihi
    
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String id, double qualityThreshold, Date joinDate) {
		super();
		this.id = id;
		this.qualityThreshold = qualityThreshold;
		this.joinDate = joinDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getQualityThreshold() {
		return qualityThreshold;
	}
	public void setQualityThreshold(double qualityThreshold) {
		this.qualityThreshold = qualityThreshold;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
