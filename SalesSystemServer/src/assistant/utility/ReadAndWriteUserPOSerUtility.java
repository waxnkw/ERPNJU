package assistant.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import po.UserPO;

/**
 * @author zhangao 161250193
 * @version 2017.12.5
 * ��дUserPO��ser�ļ���utility������
 */
public class ReadAndWriteUserPOSerUtility {
	/**
	 * д�û�PO��<br/>
	 * @param path Ҫд���û�PO��·��
	 * @return boolean�Ƿ�д�ɹ�
	 */
	public static boolean writeObj(UserPO user,String path){
		ObjectOutputStream oStream ;
//		System.out.println(path);
		try {
			oStream = new ObjectOutputStream(new FileOutputStream(path));
			oStream.writeObject(user);
			oStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ���û�PO��<br/>
	 * @param path Ҫ�����û�PO��·��
	 * @return UserPO��ȡ���û�PO
	 */
	public static UserPO readObj(String path) {
//		System.out.println("path: "+path);
		UserPO user = null ;
		ObjectInputStream oInputStream;
		try {
			oInputStream = new ObjectInputStream(new FileInputStream(path));
			user = (UserPO)oInputStream.readObject();
			oInputStream.close();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
}
