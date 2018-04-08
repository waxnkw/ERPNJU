package blImpl.adminBl;

import dataImpl.userData.GenerateIdData;

/**
 * �����û�Id��һ������ģʽ��һ���߼���
 * @author zhangao 161250193
 * @version 2017.12.27
 * �õ��û�Id
 */
public class SetUserIdBl {
	private static SetUserIdBl setUserIdBl;
	
	private SetUserIdBl(){
		
	}
	
	public static SetUserIdBl getInstance(){
		if(setUserIdBl==null){
			setUserIdBl = new SetUserIdBl();
		}
		return setUserIdBl;
	}
	
	public String generateId(){
		GenerateIdData generateIdData = new GenerateIdData();
		String id = generateIdData.generateId();
		return id;
	}
}
