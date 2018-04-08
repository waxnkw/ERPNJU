package assistant.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhangao 161250193
 * @version 2017.11.8
 * ��дtxt�ļ���utility������
 */
public class ReadAndWriteTxtUtility {
	/**
	 * ��ȡtxt�ļ������ݡ�<br/>
	 * @param String path ��ȡ���ļ���·��
	 * @return String �ļ�������
	 */
	public static String readTxt(String path){
		File file = new File(path);
		String content = "";
		try{
			InputStreamReader read=new InputStreamReader(new FileInputStream(file));
			BufferedReader bf=new BufferedReader(read);
			String line=null;
			while((line=bf.readLine())!=null){
				content+=line+System.lineSeparator();
			}
			bf.close();
			return content;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * дtxt�ļ���<br/>
	 * @param String path Ҫд���ļ���·��
	 * @param String content Ҫд���ļ�������
	 * @return boolean �Ƿ�д�ļ��ɹ�
	 */
	public static boolean writeTxtAppend(String path,String content){
		File file;
		file = new File(path);
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(content);
			fw.flush();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
