package assistant.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.BillPO;

/**
 * @author zhangao 161250193
 * @version 2017.11.8
 * ��дBillPO��ser�ļ���utility������
 */
public class ReadAndWriteBillPOSerUtility {
	/**
	 * дbill��ser�ļ���<br/>
	 * @param GiftBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean ��д�ļ��ɹ�
	 */
	public static boolean writeObj(BillPO bill,String path){
		ObjectOutputStream oStream ;
//		System.out.println(path);
		try {
			oStream = new ObjectOutputStream(new FileOutputStream(path));
			oStream.writeObject(bill);
			oStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ��ȡһ�ŵ��ݡ�<br/>
	 * @param path Ҫ��ȡ�ĵ���·��
	 * @return BillPo��ȡ�ĵ���
	 */
	public static BillPO readObj(String path){
//		System.out.println("path: "+path);
		BillPO bill= null;
		ObjectInputStream oInputStream;
		try {
			oInputStream = new ObjectInputStream(new FileInputStream(path));
			bill = (BillPO)oInputStream.readObject();
			oInputStream.close();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return bill;
	}
}
