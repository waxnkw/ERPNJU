package dataImpl.userData;

import java.io.File;

/**
 * ���õ���Id��һ������ģʽ��һ�����ݲ����
 * @author zhangao 161250193
 * @version 2017.12.27
 * ���ɵ���ID
 */
public class GenerateIdData {
	
	private static final int ID_LENGTH = 5;
	private static final String ROOT_PATH = "data" + File.separator + "user" + File.separator;//��·��
	
	public String generateId(){
		File dir = new File(ROOT_PATH);
		String[] files = dir.list();
		int maxId=0;
		for(int i=0;i<files.length;i++){
			if(!files[i].equals("record.txt")){
				int id = Integer.parseInt(files[i]);
				maxId = maxId>id?maxId:id;
			}
		}
		maxId++;
		String id = maxId +"";
		int len = id.length();
		for(int i=0;i<ID_LENGTH-len;i++){
			id="0"+id;
		}
		return id;
	}
}
