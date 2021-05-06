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
          System.out.println("�ɮ׶}�ҿ��~");
          System.exit(-1);
        }
        PrintWriter pp = new PrintWriter(ff);
        // ��ƳB�z�G�N��ƿ�X
        Iterator iter = tree.entrySet().iterator();
        String key="";
        String or = "";
        while((iter).hasNext()) {
        	Map.Entry entry = (Map.Entry)iter.next();
        	key = (String)entry.getKey();
        	or = (String)entry.getValue();
        	pp.println(key+","+or);
        }
        // �����ɮ�
        pp.close();
	}
	public void writename(JTextField name,boolean t) {
        FileWriter f1 = null;
        try {
          f1 = new FileWriter("name",t);
	        } catch (IOException ee) {
          System.out.println("�ɮ׶}�ҿ��~");
          System.exit(-1);
        }
        PrintWriter p1 = new PrintWriter(f1);
        // ��ƳB�z�G�N��ƿ�X
        p1.write("");
        p1.flush();
        p1.println(name.getText());
        
        // �����ɮ�
        p1.close();
	}
	public void writeorder(JTextField name,Cart c) {
		FileWriter f0 = null;
        try {
          f0 = new FileWriter(name.getText());
	        } catch (IOException ee) {
          System.out.println("�ɮ׶}�ҿ��~");
          System.exit(-1);
        }
        PrintWriter p0 = new PrintWriter(f0);
        // ��ƳB�z�G�N��ƿ�X
        int totalCups=0;
    	int totalMoney=0;
    	    for (Integer number : c.arraylist2) {
    	      totalCups +=number;
    	    }

    	for (Integer money : c.arraylist1) {
    	      totalMoney +=money;
    	    }
    	String orders=c.order2() + "\n"+ "�@:"+totalCups + "�M  ;   �`����:"+ totalMoney;
        p0.println(orders);
        // �����ɮ�
        p0.close();
		
	}
	public TreeMap readtreemap() {
		TreeMap<String ,String> tree = new TreeMap <String ,String>();
		FileReader f = null;
        try {
          f = new FileReader("treemap");
        } catch (IOException ee) {
          System.out.println("�ɮ׶}�ҿ��~7");
          System.exit(-1);
        }
        BufferedReader p = new BufferedReader(f);
        // ��ƳB�z�C�`�N�A�ɮצ��i��O�Ū�
        // �̾� API ���A�p�G�ɮ׬O�Ū��Ϊ̤w�gŪ���ɧ��Ainput �|�O null
        try {
          String input = p.readLine(); // ��b�j��}�l�H�e
          while(input != null) {
            String[] columns = input.split(",");
            tree.put(columns[0],columns[1]);
            input = p.readLine();// ��b�j�餺���̫�@��
          }
        } catch (IOException ee) {
          System.out.println("���Ū�����~8");
          System.exit(-2);
        } catch (NumberFormatException ee) {
          System.out.println("�Ʀr�ഫ���~9");
          System.exit(-3);
        }

        // �����ɮ�
        try {
          p.close();
        } catch (IOException ee) {
          System.out.println("�ɮ׵L�k����");
        }
    	return tree;
	}		  
}
