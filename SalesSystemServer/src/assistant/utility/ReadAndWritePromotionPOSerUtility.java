package assistant.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.PromotionStrategyPO;

/**
 * @author zhangao 161250193
 * @version 2017.11.24
 * ��дPromotionPO��ser�ļ���utility������
 */

public class ReadAndWritePromotionPOSerUtility {
	
	/**
	 * дpromotion��ser�ļ���<br/>
	 * @param PromotionStrategyPO promotion ��Ҫд�Ĵ������� 
	 * @return boolean �Ƿ�д�ļ��ɹ�
	 */
	public static boolean writeObj(PromotionStrategyPO promotion,String path){
		ObjectOutputStream oStream ;
//		System.out.println(path);
		try {
			oStream = new ObjectOutputStream(new FileOutputStream(path));
			oStream.writeObject(promotion);
			oStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * ��ȡһ���������ԡ�<br/>
	 * @param path Ҫ��ȡ�Ĵ�������·��
	 * @return PromotionStrategyPO��ȡ�Ĵ�������
	 */
	public static PromotionStrategyPO readObj(String path){
//		System.out.println("path: "+path);
		PromotionStrategyPO promotion= null;
		ObjectInputStream oInputStream;
		try {
			oInputStream = new ObjectInputStream(new FileInputStream(path));
			promotion = (PromotionStrategyPO)oInputStream.readObject();
			oInputStream.close();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return promotion;
	}
}
