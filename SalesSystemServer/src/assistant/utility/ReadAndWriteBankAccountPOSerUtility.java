package assistant.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.BankAccountPO;

/**
 * ���л��ͷ����л������˻��������
 * @author guxinyu
 * @version 2017.12.2
 *
 */
public class ReadAndWriteBankAccountPOSerUtility {
	/**
	 * ���л����������˻�����
	 * @param toWrite Ҫ����Ķ���
	 * @param path Ҫ����Ķ����·��
	 * @return �Ƿ񱣴�ɹ�
	 */
	public static boolean writeObj(BankAccountPO toWrite, String path){
		ObjectOutputStream os;
		
		try{
			os=new ObjectOutputStream(new FileOutputStream(path));
			os.writeObject(toWrite);
			os.close();
			return true;
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * �����л���ȡһ�������˻�����
	 * @param path Ҫ���Ķ����·��
	 * @return ����ȡ�Ķ���
	 */
	public static BankAccountPO readObj(String path){
		BankAccountPO account=null;
		ObjectInputStream is;
		
		try{
			is=new ObjectInputStream(new FileInputStream(path));
			account=(BankAccountPO)is.readObject();
			is.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return account;
	}
}
