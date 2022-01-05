package test.demo1;

public class VaccineVo implements  Comparable<VaccineVo>{
	
	
	
	
	private String vaccineCount;
	private String inoculateDate;
	private String lastStationName;
	
	
	
	
	
	
	
	public String getVaccineCount() {
		return vaccineCount;
	}
	public void setVaccineCount(String vaccineCount) {
		this.vaccineCount = vaccineCount;
	}
	public String getInoculateDate() {
		return inoculateDate;
	}
	public void setInoculateDate(String inoculateDate) {
		this.inoculateDate = inoculateDate;
	}
	public String getLastStationName() {
		return lastStationName;
	}
	public void setLastStationName(String lastStationName) {
		this.lastStationName = lastStationName;
	}
	
	
	
	@Override
	public int compareTo(VaccineVo o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
