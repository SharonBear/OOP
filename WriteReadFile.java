import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JTextField;

public class WriteReadFile {
	public void writetreemap(TreeMap<String ,String> tree) {
		FileWriter ff = null;
        try {
          ff = new FileWriter("treemap");
	        } catch (IOException e) {
          System.out.println("檔案開啟錯誤");
          System.exit(-1);
        }
        PrintWriter pp = new PrintWriter(ff);
        // 資料處理：將資料輸出
        Iterator iter = tree.entrySet().iterator();
        String key="";
        String or = "";
        while((iter).hasNext()) {
        	Map.Entry entry = (Map.Entry)iter.next();
        	key = (String)entry.getKey();
        	or = (String)entry.getValue();
        	pp.println(key+","+or);
        }
        // 關閉檔案
        pp.close();
	}
	public void writename(JTextField name,boolean t) {
        FileWriter f1 = null;
        try {
          f1 = new FileWriter("name",t);
	        } catch (IOException ee) {
          System.out.println("檔案開啟錯誤");
          System.exit(-1);
        }
        PrintWriter p1 = new PrintWriter(f1);
        // 資料處理：將資料輸出
        p1.write("");
        p1.flush();
        p1.println(name.getText());
        
        // 關閉檔案
        p1.close();
	}
	public void writeorder(JTextField name,Cart c) {
		FileWriter f0 = null;
        try {
          f0 = new FileWriter(name.getText());
	        } catch (IOException ee) {
          System.out.println("檔案開啟錯誤");
          System.exit(-1);
        }
        PrintWriter p0 = new PrintWriter(f0);
        // 資料處理：將資料輸出
        int totalCups=0;
    	int totalMoney=0;
    	    for (Integer number : c.arraylist2) {
    	      totalCups +=number;
    	    }

    	for (Integer money : c.arraylist1) {
    	      totalMoney +=money;
    	    }
    	String orders=c.order2() + "\n"+ "共:"+totalCups + "杯  ;   總價格:"+ totalMoney;
        p0.println(orders);
        // 關閉檔案
        p0.close();
		
	}
	public TreeMap readtreemap() {
		TreeMap<String ,String> tree = new TreeMap <String ,String>();
		FileReader f = null;
        try {
          f = new FileReader("treemap");
        } catch (IOException ee) {
          System.out.println("檔案開啟錯誤7");
          System.exit(-1);
        }
        BufferedReader p = new BufferedReader(f);
        // 資料處理。注意，檔案有可能是空的
        // 依據 API 文件，如果檔案是空的或者已經讀到檔尾，input 會是 null
        try {
          String input = p.readLine(); // 放在迴圈開始以前
          while(input != null) {
            String[] columns = input.split(",");
            tree.put(columns[0],columns[1]);
            input = p.readLine();// 放在迴圈內的最後一行
          }
        } catch (IOException ee) {
          System.out.println("資料讀取錯誤8");
          System.exit(-2);
        } catch (NumberFormatException ee) {
          System.out.println("數字轉換錯誤9");
          System.exit(-3);
        }

        // 關閉檔案
        try {
          p.close();
        } catch (IOException ee) {
          System.out.println("檔案無法關閉");
        }
    	return tree;
	}		  
}
