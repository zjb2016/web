package entity;

public class item implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
		private int num=0;
		private String brand=null;
		private String xinghao=null;
		
		public item()
		{ 
		  
		}
		
		public void setBrand(String s){
			this.brand=s;
		    }
		public String getBrand(){
			return brand;
		    }
		public void setXinghao(String s){
			this.xinghao=s;
		    }
		public String getXinghao(){
			return xinghao;
		    }
		public void setNum(int i){
			this.num=i;
		    }
		public int getNum(){
			return num;
		    }
}
