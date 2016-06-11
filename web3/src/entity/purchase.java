package entity;

public class purchase {

	String date;
	String buyer;
	String owner;
	String bycycleID;
	
	public purchase(){}
	
	public void setDate(String i){
		this.date=i;
	    }
    public String getDate(){
		return date;
	    }
	public void setBuyer(String i){
		this.buyer=i;
	    }
    public String getBuyer(){
		return buyer;
	    }
    public void setOwner(String i){
		this.owner=i;
	    }
    public String getOwner(){
		return owner;
	    }
    public void setBycycleID(String i){
		this.bycycleID=i;
	    }
    public String getBycycleID(){
		return bycycleID;
	    }
	
	
	
}
