package blService.customerBlService;

import java.rmi.Remote;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.CustomerVO;
import vo.UserInfoVO;

/**
 * ����������Ա�ͻ������ҵ���߼��ӿ�
 * @author ����һ
 * @version 2017.11.7
 *
 */

public interface CustomerBlService extends Remote{

	/**
	 * �����¿ͻ�
	 * @param CustomerVO
	 * @return boolean, true��ʾ�����ɹ�
	 * @throws RemoteException
	 */
	public boolean AddCustomer(CustomerVO vo) throws RemoteException;
	
	/**
	 * ɾ���ͻ�
	 * @param �ͻ�ID
	 * @param �ͻ�����
	 * ɾ��Ϊ���в���, �����ź�������ȫƥ�����ɾ��
	 * @return boolean, true��ʾ�����ɹ�
	 * @throws RemoteException
	 */
	public boolean DelCustomer(String number, String name) throws RemoteException;
	
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param CustomerVO
	 * @return boolean, true��ʾ�����ɹ�
	 * @throws RemoteException
	 */
	public boolean ModCustomer(CustomerVO vo) throws RemoteException;
	
	/**
	 * �õ�ҵ��Ա
	 * @return ArrayList<UserInfoVO>
	 * @throws RemoteException
	 */
	public ArrayList<UserInfoVO> GetUsers() throws RemoteException;
	
	/**
	 * ��ѯ�ͻ���Ϣ
	 * @param �ؼ���, ������ID�������ؼ���
	 * @return ArrayList<CustomerVO>
	 * @throws RemoteException
	 */
	public ArrayList<CustomerVO> QueryCustomer(String name) throws RemoteException;
	
}

