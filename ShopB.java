public class ShopB extends Drink{
	public int applejuice,papayajuice,watermelonjuice;
	public ShopB() {
	    super();
	    setShopName("ShopB");
	    setapplejuice(false);
	    setpapayajuice(false);
	    setwatermelonjuice(false);
	  }
	public void setapplejuice(boolean n) {
		if (n==true) {
			applejuice=1;
			}else {
			applejuice=0;
			}
	}
	public void setpapayajuice(boolean n) {
		if (n==true) {
			papayajuice=1;
		    }else {
		    papayajuice=0;
		    }
	}
	public void setwatermelonjuice(boolean n) {
		if (n==true) {
			watermelonjuice=1;
		    }else {
		    watermelonjuice=0;
		    }
	}
 
  
	public String getDrink() {
		if (OT==1){
			return ("OolongTea");
		}else if (BT==1) {
			return ("BlackTea");
		}else if (GT==1){
			return ("GreenTea");
		}else if (applejuice==1){
			return ("AppleJuice");
		}else if (papayajuice==1){
			return ("PapayaJuice");
		}else if (watermelonjuice==1){
			return ("WatermelonJuice");
		}else {
			return("沒有輸入品項");
		}
	}
	public int compPrice() {
		  price=super.compPrice()+num*(applejuice*30+papayajuice*35+watermelonjuice*35);
		  return price;
		 }
}
 
