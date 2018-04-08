package blService.logBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * ������Ա�����˻����¼��ҵ���߼��ӿ�
 * @author ����һ
 * @version 2017.11.7
 *
 */

public interface LogBlService extends Remote {

	/**
	 * �ж��û��Ƿ�Ϊ�Ϸ��û�
	 * @param �û������ID���ַ�����
	 * @param �û���������루�ַ�����
	 * @return ����ֵ������û���������ƥ�䷵��True
	 * @throws RemoteException
	 */
	public boolean isValidUser(String userId, String password) throws RemoteException;
	
	/**
	 * ע���û��������˻���
	 * @param �û������Ѿ�������õ�ID���ַ�����
	 * @param �û���������루�ַ�����
	 * @return ����ֵ������������̳ɹ��򷵻�True
	 * @throws RemoteException
	 */
	public boolean registerUser(String userId, String password) throws RemoteException;
	
	/**
	 * �޸�����
	 * @param �û������ID���ַ�����
	 * @param �û�����ľ����루�ַ�����
	 * @param �û�����������루�ַ�����
	 * @return ����ֵ������޸�����ɹ��򷵻�True
	 * @throws RemoteException
	 */
	public boolean changePassword(String userId, String oldPassword, String password) throws RemoteException;
}
