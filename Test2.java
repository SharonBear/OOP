import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.TreeMap;
import java.awt.*;
import java.awt.event.*;

public class Test2 extends JFrame {
  private Container cp;
  private JLabel tyLabel1,tyLabel2, namLabel, inpLabel;
  public JComboBox types1,types2;
  TreeMap<String ,String> tree = new TreeMap <String ,String>();
  
  public JTextField name,input;
  private JButton addButton, endButton;
  private JTextArea textarea;
  private final String[] SHOP = {"ShopA", "ShopB","ShopC"};
  private final String[] DRINKa = {"GreenTea($25)", "BlackTea($30)","OolongTea($35)"};
  private final String[] DRINKb = {"GreenTea($25)", "BlackTea($30)","OolongTea($35)","AppleJuice($30)","PapayaJuice($35)","WatermelonJuice($35)"};
  private final String[] DRINKc = {"GreenTea($30)", "BlackTea($35)","OolongTea($40)"};
  private JCheckBox bubble,milk,coconutjelly,pudding;
  private String sbubble="";
  private String smilk="";
  private String scoconutjelly="";
  private String spudding="";
  private String orders="";
  Drink d = new Drink();
  ShopA d0 = new ShopA();
  ShopB d1 = new ShopB();
  ShopC d2 = new ShopC();
  Cart c=new Cart();
  
  public Test2() {
    setTitle("點單");
    setSize(800,300);
    setLocation(250,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    namLabel = new JLabel("訂購人姓名");
    name = new JTextField(20);
    
    tyLabel1 = new JLabel("店家選擇");
    types1 = new JComboBox(SHOP);

    tyLabel2 = new JLabel("選擇飲品");
    types2 = new JComboBox(DRINKa);

    inpLabel = new JLabel("數量");
    input = new JTextField(20);
    
    bubble = new JCheckBox("珍珠 +5");
    milk   = new JCheckBox("加奶 +10");
    coconutjelly = new JCheckBox("椰果 +5");
    pudding   = new JCheckBox("布丁 +10");
    
    addButton = new JButton("加入購物車");
    endButton = new JButton("結帳");
    textarea = new JTextArea(10,15);
    textarea.setEditable(false);

    cp = getContentPane();
    cp.setLayout(new GridLayout(1,2,5,10));
    JPanel newp = new JPanel();
    newp.setLayout(new BorderLayout(5,10));
    cp.add(newp);
    cp.add(new JScrollPane(textarea));

    JPanel cpan = new JPanel();
    cpan.setLayout(new GridLayout(6,1,5,10));
    cpan.add(namLabel);
    cpan.add(name);
    cpan.add(tyLabel1);
    cpan.add(types1);
    cpan.add(tyLabel2);
    cpan.add(types2);
    cpan.add(bubble);
    cpan.add(milk);
    cpan.add(coconutjelly);
    cpan.add(pudding);
    cpan.add(inpLabel);
    cpan.add(input);
    

    JPanel span = new JPanel();
    span.setLayout(new GridLayout(1,2,5,10));
    span.add(addButton);
    span.add(endButton);

    newp.add(cpan, BorderLayout.NORTH);
    newp.add(span, BorderLayout.SOUTH);

    // register
    types1.addItemListener(new List1Handler());
    types2.addItemListener(new List2Handler());
    addButton.addActionListener(new InputHandler());
    endButton.addActionListener(new EndButtonHandler());
    bubble.addItemListener(new CheckBox1Handler());
    milk.addItemListener(new CheckBox2Handler());
    coconutjelly.addItemListener(new CheckBox3Handler());
    pudding.addItemListener(new CheckBox4Handler());
  }

  private class List1Handler implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
      if(types1.getSelectedIndex() == 1) { // 選了第二項
    	  coconutjelly.setVisible(false);
    	  pudding.setVisible(false);
    	  types2.removeAllItems();
    	  for (int i = 0; i < DRINKb.length; i++) {  
    		  types2.addItem(DRINKb[i]);
    	  }
      } else if (types1.getSelectedIndex() == 2){
    	  coconutjelly.setVisible(false);
    	  pudding.setVisible(false);
    	  types2.removeAllItems();
    	  for (int i = 0; i < DRINKc.length; i++) {  
    		  types2.addItem(DRINKc[i]);
    	  }
      } else {
    	  coconutjelly.setVisible(true);
    	  pudding.setVisible(true);
    	  types2.removeAllItems();
    	  for (int i = 0; i < DRINKa.length; i++) {  
    		  types2.addItem(DRINKa[i]);
    	  }
      }
    }
  }

	
  private class List2Handler implements ItemListener {
	    public void itemStateChanged(ItemEvent e) {
	    	if(types1.getSelectedIndex() == 1) {
	    		if(types2.getSelectedIndex() == 1) { // 選了第二項
	  	    	  d1.setGT(false);
	  	    	  d1.setBT(true);
	  	    	  d1.setOT(false);
	  	    	  d1.setapplejuice(false);
	  	    	  d1.setpapayajuice(false);
	  	    	  d1.setwatermelonjuice(false);
	  	      } else if (types2.getSelectedIndex() == 2){
	  	    	  d1.setGT(false);
	  	    	  d1.setBT(false);
	  	    	  d1.setOT(true);
	  	    	  d1.setapplejuice(false);
	  	    	  d1.setpapayajuice(false);
	  	    	  d1.setwatermelonjuice(false);
	  	      } else if (types2.getSelectedIndex() == 3){
	  	    	  d1.setGT(false);
	  	    	  d1.setBT(false);
	  	    	  d1.setOT(false);
	  	    	  d1.setapplejuice(true);
	  	    	  d1.setpapayajuice(false);
	  	    	  d1.setwatermelonjuice(false);
	  	      }else if (types2.getSelectedIndex() == 4){
	  	    	  d1.setGT(false);
	  	    	  d1.setBT(false);
	  	    	  d1.setOT(false);
	  	    	  d1.setapplejuice(false);
	  	    	  d1.setpapayajuice(true);
	  	    	  d1.setwatermelonjuice(false);
	  	      }else if (types2.getSelectedIndex() == 5){
	  	    	  d1.setGT(false);
	  	    	  d1.setBT(false);
	  	    	  d1.setOT(false);
	  	    	  d1.setapplejuice(false);
	  	    	  d1.setpapayajuice(false);
	  	    	  d1.setwatermelonjuice(true);
	  	      }else {
	  	    	  d1.setGT(true);
	  	    	  d1.setBT(false);
	  	    	  d1.setOT(false);
	  	    	  d1.setapplejuice(false);
	  	    	  d1.setpapayajuice(false);
	  	    	  d1.setwatermelonjuice(false);
	  	      }
	  	    }else if(types1.getSelectedIndex() == 0){
	  	    	if(types2.getSelectedIndex() == 1) { // 選了第二項
		  	    	  d0.setGT(false);
		  	    	  d0.setBT(true);
		  	    	  d0.setOT(false);
		  	      } else if (types2.getSelectedIndex() == 2){
		  	    	  d0.setGT(false);
		  	    	  d0.setBT(false);
		  	    	  d0.setOT(true);
		  	      }else {
		  	    	  d0.setGT(true);
		  	    	  d0.setBT(false);
		  	    	  d0.setOT(false);
		  	      }
	  	    }else {
	  	    	if(types2.getSelectedIndex() == 1) { // 選了第二項
		  	    	  d2.setGT(false);
		  	    	  d2.setBT(true);
		  	    	  d2.setOT(false);
		  	      } else if (types2.getSelectedIndex() == 2){
		  	    	  d2.setGT(false);
		  	    	  d2.setBT(false);
		  	    	  d2.setOT(true);
		  	      }else {
		  	    	  d2.setGT(true);
		  	    	  d2.setBT(false);
		  	    	  d2.setOT(false);
		  	      }
	  	    }
	  }
  }
  private class CheckBox1Handler implements ItemListener {
	    public void itemStateChanged(ItemEvent e) {
	      // 兩種情形：click 有可能是選取，也有可能是取消選取
	      if(e.getStateChange() == ItemEvent.SELECTED) {
	    	 d0.setBubble(true);
	    	 d1.setBubble(true);
	    	 d2.setBubble(true);
	         sbubble="加珍珠  ";
	      }else {
	    	  d0.setBubble(false);
	    	  d1.setBubble(false);
	    	  d2.setBubble(false);
	    	  sbubble=" ";
	      }
	    }
	  }
  private class CheckBox2Handler implements ItemListener {
	    public void itemStateChanged(ItemEvent e) {
	      // 兩種情形：click 有可能是選取，也有可能是取消選取
	      if(e.getStateChange() == ItemEvent.SELECTED) {
	    	 d0.setMilk(true);
	    	 d1.setMilk(true);
	    	 d2.setMilk(true);
	         smilk="加奶  ";
	      }else {
	    	  d0.setMilk(false);
	    	  d1.setMilk(false);
	    	  d2.setMilk(false);
	      	  smilk=" ";
	      }
	    }
	  }
  private class CheckBox3Handler implements ItemListener {
	    public void itemStateChanged(ItemEvent e) {
	      // 兩種情形：click 有可能是選取，也有可能是取消選取
	      if(e.getStateChange() == ItemEvent.SELECTED) {
	    	 d0.setcoconutjelly(true);
	    	 scoconutjelly="加椰果  ";
	      }else {
	    	  d0.setcoconutjelly(false);
	    	  scoconutjelly=" ";
	      }
	    }
	  }
  private class CheckBox4Handler implements ItemListener {
	    public void itemStateChanged(ItemEvent e) {
	      // 兩種情形：click 有可能是選取，也有可能是取消選取
	      if(e.getStateChange() == ItemEvent.SELECTED) {
	    	 d0.setpudding(true);
	    	 spudding="加布丁  ";
	      }else {
	    	  d0.setpudding(false);
	    	  spudding=" ";
	      }
	    }
	  }
  
  private class InputHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    	try {
    		int n2 = Integer.parseInt(input.getText());
    		if (n2<=0) {
      			throw new Exception("杯數需要大於零");
      			}
      		if(name.getText().length() == 0) {
        		throw new Exception("名字不能留空");
        		}
    	
	    	if(types1.getSelectedIndex() == 0) {
	    		d0.setNum(n2);
	            textarea.append(d0.getShopName()
	        		  		+ " -- "+d0.getDrink()+smilk+sbubble+scoconutjelly+spudding
	        		  		+ n2  +"杯   "
	        		  		+ "價格 : "+ d0.compPrice() + "\n");
	            name.setEditable(false);
	            c.arraylist1.add(d0.compPrice());
	            c.arraylist2.add(n2);
	            orders = d0.getShopName()+" -- "+d0.getDrink()+smilk+sbubble+scoconutjelly+spudding+ n2 +"杯   "+ "價格 : "+ d0.compPrice();
	            c.arraylist3.add(orders);
	            textarea.setCaretPosition(textarea.getDocument().getLength());
	      	}else if(types1.getSelectedIndex() == 1){
	      		d1.setNum(n2);
	      		textarea.append(d1.getShopName()
        		  		+ " -- "+d1.getDrink()+smilk+sbubble
        		  		+ n2  +"杯   "
        		  		+ "價格 : "+ d1.compPrice() + "\n");
	      		name.setEditable(false);
	            c.arraylist1.add(d1.compPrice());
	            c.arraylist2.add(n2);
	            orders = d1.getShopName()+" -- "+d1.getDrink()+smilk+sbubble+scoconutjelly+spudding+ n2 +"杯   "+ "價格 : "+ d1.compPrice();
	            c.arraylist3.add(orders);
	            textarea.setCaretPosition(textarea.getDocument().getLength());
		     }else {
		    	 d2.setNum(n2);
		    	 textarea.append(d2.getShopName()
	        		  		+ " -- "+d2.getDrink()+smilk+sbubble
	        		  		+ n2  +"杯   "
	        		  		+ "價格 : "+ d2.compPrice() + "\n");
	            name.setEditable(false);
	            c.arraylist1.add(d2.compPrice());
	            c.arraylist2.add(n2);
	            orders = d2.getShopName()+" -- "+d2.getDrink()+smilk+sbubble+ n2 +"杯   "+ "價格 : "+ d2.compPrice();
	            c.arraylist3.add(orders);
	            textarea.setCaretPosition(textarea.getDocument().getLength());
		     }
    	}catch(NumberFormatException ee) {
        	JOptionPane.showMessageDialog(null,"必須輸入數字");
        	}
    	catch(Exception ee) {
        	JOptionPane.showMessageDialog(null,ee.getMessage());
        	}
    	}
  }
  private class EndButtonHandler implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	WriteReadFile w=new WriteReadFile();
	    	tree=w.readtreemap();
	    	orders=c.order() ;
	    	//System.out.println(orders);
	    	tree.put(name.getText(),orders);
	    	w.writename(name,true);
	    	w.writeorder(name,c);
	    	w.writetreemap(tree);
	        dispose();
	    }
  }
}

