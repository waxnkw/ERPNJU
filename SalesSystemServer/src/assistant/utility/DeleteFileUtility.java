package assistant.utility;

import java.io.File;

/**
 * @author zhangao 161250193
 * @version 2017.11.22
 * ɾ���ļ���utility������
 */

public class DeleteFileUtility {
	
	/**
	 * ɾ���ļ���<br/>
	 * @param String Ҫɾ�����ļ��ĵ�ַ
	 * @return boolean �Ƿ�ɾ���ɹ�
	 */
	public static boolean deleteFile(String path){
		File file = new File(path);
		return file.delete();
	}
}
