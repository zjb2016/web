package entity;

public class bycycle {
	private String brand;
	private String price;
	private String id;
	private String owner;
	

	public bycycle(String pinpai, String jiage, String xinghao,String cheng,String id) 
	{
	
		this.brand=pinpai;
		this.price=jiage;
	
		
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String u) {
		this.brand = u;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String r) {
		this.price = r;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String c) {
		this.owner = c;
	}
	
	public String setId() {
		return id;
	}

	public void getId(String c) {
		this.id = c;
	}
}
