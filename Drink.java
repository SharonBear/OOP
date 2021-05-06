
public class Drink {
	public String name,shopname;
	public int GT,BT,OT;
	public int bubble,milk;
	public int perprice,price;
	public int num;
	
	public Drink() {
		name="";
		num=0;
		setName("");
		setShopName("");
		setNum(0);
		GT=1;
	}
	
	public void setName(String n) {
		name=n;
	}
	public void setShopName(String n) {
		shopname=n;
	}
	public String getShopName() {
		return shopname;
	}
	public void setNum(int n) {
		if (n<0) {
			System.out.println("輸入的數量錯誤");
		}else {
			num=n;
		}
	}
	public void setGT(boolean n) {
		if (n==true) {
			GT=1;
		}else {
			GT=0;
		}
	}
	public void setBT(boolean n) {
		if (n==true) {
			BT=1;
		}else {
			BT=0;
		}
	}
	public void setOT(boolean n) {
		if (n==true) {
			OT=1;
		}else {
			OT=0;
		}
	}
	public String getDrink() {
		if (OT==1){
			return ("OolongTea");
		}else if (BT==1) {
			return ("BlackTea");
		}else if (GT==1){
			return ("GreenTea");
		}else {
			return("沒有輸入品項");
		}
	}
	
	public void setBubble(boolean n) {
		if (n==true) {
			bubble=1;
		}else {
			bubble=0;
		}
	}
	
	public void setMilk(boolean n) {
		if (n==true) {
			milk=1;
		}else {
			milk=0;
		}
	}
	public void setapplejuice() {
	}
	public void setpapayajuice() {
	}
	public void setwatermelonjuice() {
	}
	public void setsmallBubble() {
	}
	public void setmixBubble() {
	}
	
	
	public String getName() {
		return name;
	}
	public int getNum() {
		return num;
	}

	public int compPrice() {
		perprice=GT*25+BT*30+OT*35+bubble*5+milk*10;
		price=perprice*num;
		return price;
	}

}
