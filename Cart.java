
import java.util.*;
public class Cart {
	
	public Cart(){
	}
	ArrayList <Integer> arraylist1=new ArrayList<Integer>();
	ArrayList <Integer> arraylist2=new ArrayList<Integer>();
	ArrayList <String> arraylist3=new ArrayList<String>();
	int all=0;
	int all2=0;
	String order="";
	public int compEndPrice() {
		for(int i=0;i<arraylist1.size();i++) {
			all=all+arraylist1.get(i);
			}
		return all;
	}
	public int compEndNum() {
		for(int i=0;i<arraylist2.size();i++) {
			all2=all2+arraylist2.get(i);
			}
		return all2;
	}
	public String order() {
		for(int i=0;i<arraylist3.size();i++) {
			order=order+arraylist3.get(i);
		}
		return order;
	}
	public String order2() {
		String temporder = "";
		  for(int i=0;i<arraylist3.size();i++) {
		   temporder=temporder+arraylist3.get(i)+"\n";
		  }
		  return temporder;
		 }
}