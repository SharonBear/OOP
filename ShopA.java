
public class ShopA extends Drink {
	public int coconutjelly,pudding;
	public ShopA() {
		super();
		setShopName("ShopA");
		coconutjelly=0;
		pudding=0;
	}
	public void setcoconutjelly(boolean n) {
		if (n==true) {
			coconutjelly=1;
		}else {
			coconutjelly=0;
		}
	}
	public void setpudding(boolean n) {
		if (n==true) {
			pudding=1;
		}else {
			pudding=0;
		}
	}
	public int compPrice() {
		price=super.compPrice()+num*(coconutjelly*5+pudding*10);
		return price;
	}


}
