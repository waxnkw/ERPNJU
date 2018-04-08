package blImpl.logBl;

import java.rmi.RemoteException;

import assistant.exception.Myexception;
import dataImpl.userData.UserData;
import dataService.userDataService.UserDataService;

/**
 * ������Ա��¼��ע���ҵ���߼�
 * @author ����һ
 * @version 2017.11.7
 *
 */

public class LogBl {

	private UserDataService data=new UserData();
	
	/**
	 * �ж��û��Ƿ�Ϊ�Ϸ��û�
	 * @param userId(String)
	 * @param password(String)
	 * @return boolean, true��ʾ�û���������ƥ��, �ǺϷ��û�
	 */
	protected boolean isValidUser(String userId, String password) {
		// TODO Auto-generated method stub
		boolean success;
		try {
			success = data.isValidUser(userId, password);
			return success;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Myexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * ע���û��������˻���, ע��:UI��õ�ȷ����Ϣ��Ӧ����ת������������档
	 * @param userId(String)
	 * @param password(String)
	 * @return boolean, true��ʾ��Ա���ѱ������˺�, ע��ɹ�
	 */
	public boolean registerUser(String userId, String password) {
		// TODO Auto-generated method stub
		boolean success;
		try {
			success = data.registerUser(userId, password);
			return success;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Myexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * �޸�����
	 * @param userId(String)
	 * @param oldPassword(String)
	 * @param password(String)
	 * @return boolean, true��ʾ��������ɹ�
	 */
	public boolean changePassword(String userId, String oldPassword, String password) {
		// TODO Auto-generated method stub
		String newPassword=password;
		boolean success;
		try {
			success = data.changePassword(userId, oldPassword, newPassword);
			return success;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Myexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
