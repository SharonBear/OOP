
import javax.swing.*;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
public class Test1 extends JFrame{
	Container cp;
	JLabel namLabel, inpLabel;
	JComboBox <String>name;
	JButton refreshButton,addButton, deleteButton,changeButton;
	JTextArea textarea;
	Drink d = null;
	
	static TreeMap<String ,String> treemapt1 = new TreeMap <String ,String>();
	public Test1() {
	    setTitle("UBER真真續續");
	    setSize(800,300);
	    setLocation(250,200);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    namLabel = new JLabel("訂購人姓名");
	    name = new JComboBox<String>();
	   

	    refreshButton = new JButton("重新整理");
	    addButton = new JButton("新增");
	    deleteButton = new JButton("刪除");
	    changeButton = new JButton("修改");
	    textarea = new JTextArea(10,15);
	    textarea.setEditable(false);

	    cp = getContentPane();
	    cp.setLayout(new GridLayout(2,1,5,10));
	    JPanel newp = new JPanel();
	    newp.setLayout(new BorderLayout(5,10));
	    cp.add(newp);
	    cp.add(new JScrollPane(textarea));

	    JPanel cpan = new JPanel();
	    cpan.setLayout(new GridLayout(6,1,5,10));
	    cpan.add(namLabel);
	    cpan.add(name);
	    

	    JPanel span = new JPanel();
	    span.setLayout(new GridLayout(1,2,5,10));
	    span.add(refreshButton);
	    span.add(addButton);
	    span.add(deleteButton);
	    span.add(changeButton);

	    newp.add(cpan, BorderLayout.NORTH);
	    newp.add(span, BorderLayout.SOUTH);

	    // register
	    name.addItemListener(new ListHandler());
	    refreshButton.addActionListener(new RefHandler());
	    addButton.addActionListener(new InputHandler());
	    deleteButton.addActionListener(new DelHandler());
	    changeButton.addActionListener(new ChaButtonHandler());
	}
	private class ListHandler implements ItemListener {
	    public void itemStateChanged(ItemEvent e) {
	    	if(e.getStateChange() == ItemEvent.SELECTED) {
		        FileWriter ff = null;
		        try {
		          ff = new FileWriter("name");
	 	        } catch (IOException ee) {
		          System.out.println("檔案開啟錯誤");
		          System.exit(-1);
		        }
		        PrintWriter pp = new PrintWriter(ff);
		        // 資料處理：將資料輸出		        
		        Iterator iter = treemapt1.entrySet().iterator();
		        String key="";
		        pp.write("");
		        pp.flush();
		        while(iter.hasNext()) {
		        	Map.Entry entry = (Map.Entry)iter.next();
		        	key = (String)entry.getKey();
		        	pp.println(key);
		        }
		        // 關閉檔案
		        pp.close();
	    	}
		        
                if (name.getSelectedItem()!=null) {
    	    		String ret=name.getSelectedItem().toString();
    	    		FileReader f = null;
    		  	    try {
    		  	      //System.out.println(ret);
    		  	      f = new FileReader(ret);
    		  	    } catch (IOException ee) {
    		  	    	JOptionPane.showMessageDialog(null,"請先輸入資料");
    		  	      //System.out.println("檔案開啟錯誤1");
    		  	      //System.exit(-1);
    		  	    }
    		  	    
    		  	    BufferedReader p = new BufferedReader(f);
    		  	    
    		  	    // 資料處理：將資料讀進來併處理
    		  	    try {
    		  	    	String endinput="";
    		  	    	String input = p.readLine(); // 放在迴圈開始以前
    		  	        while(input != null) {
    		  	          // 放在迴圈內的最後一行
    		  	          endinput = endinput+input+"\n";
    		  	          input = p.readLine();
    		  	          //System.out.println(endinput);
    		  	        }
    		  	        textarea.removeAll();
    		  	        textarea.setText(endinput);
    		  	        }catch (IOException ee) {
    		  	        System.out.println("資料讀取錯誤2");
    		  	        System.exit(-2);
    		  	      } 
    		  	    // 關閉檔案
    		  	    try {
    		  	      p.close();
    		  	      }catch (IOException ee){
    		  	      System.out.println("檔案無法關閉");
    		  	    }
    	    	}
            }
	    }
	
	
	private class RefHandler implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	WriteReadFile w=new WriteReadFile();
	    	treemapt1=w.readtreemap();
	    	name.removeAllItems();
	          Iterator iter = treemapt1.entrySet().iterator();
		        String key="";
		        String or = "";
		        while(iter.hasNext()) {
		        	Map.Entry entry = (Map.Entry)iter.next();
		        	key = (String)entry.getKey();
		        	name.addItem(key);
		        }
		        if (name.getSelectedItem()==null) {
					JOptionPane.showMessageDialog(null,"請先輸入資料");
				}
	    }
	}
	private class InputHandler implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	Test2 t2=new Test2();
	    	t2.setVisible(true);
	  }
	}
	
	private class DelHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (name.getSelectedItem()==null) {
				JOptionPane.showMessageDialog(null,"請先輸入資料");
			}else{
	    		String ret=name.getSelectedItem().toString();
	    		String newContent="";
	    		File file = new File(ret);
		  	    try {
		  	      //System.out.println(file.delete());
		  	      treemapt1.remove(ret);
		  	      //System.out.println(treemapt1);
		  	      
		  	      FileReader f = null;
		  	      f = new FileReader("name");
		  	      BufferedReader p = new BufferedReader(f);
			  	  while(p.readLine() != null ) {  //逐行讀入檔案內容
			  	    	 String line=p.readLine();
			  	    	 newContent = newContent+line.replace(ret,"");  //利用String的replace() Method將 ret置換成空字串
			  	    }
			  	  //System.out.println(newContent);
			  	} catch (Exception ee) {
			  		System.out.println("錯誤1");
			  		//System.exit(-1);
			  		}
		  	  FileWriter f1 = null;
		  	  FileWriter ff = null;
		  	  try {
		  		  f1 = new FileWriter("name");
		  		  ff = new FileWriter("treemap");
		  		  } catch (IOException ee) {
		  			  System.out.println("檔案開啟錯誤");
			          System.exit(-1);
			          }
		  	  PrintWriter p1 = new PrintWriter(f1);
		  	  PrintWriter pp = new PrintWriter(ff);
		  	  p1.println(newContent);
		  	  Iterator iter = treemapt1.entrySet().iterator();
		  	  String key="";
		  	  String or = "";
		  	  while(iter.hasNext()) {
		  		  Map.Entry entry = (Map.Entry)iter.next();
		  		  key = (String)entry.getKey();
		  		  or = (String)entry.getValue();
		  		  pp.println(key+","+or);
		  	  }
		  	  p1.close();
		      pp.close();
	    	}
	}
}
	private class ChaButtonHandler implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	if (name.getSelectedItem()!=null) {
		    		Test2 t2=new Test2();
		    		t2.setVisible(true);
		    		String t=name.getSelectedItem().toString();
		    		t2.name.setText(t);
		    		t2.name.setEditable(false);
	    		}else{
	    			JOptionPane.showMessageDialog(null,"請先輸入資料");
	    		}
	    }
	}

	
	
	public static void main(String[] args) {
		Test1 t1=new Test1();
		t1.setVisible(true);
		WriteReadFile w=new WriteReadFile();
		treemapt1=w.readtreemap();
	}
}

	