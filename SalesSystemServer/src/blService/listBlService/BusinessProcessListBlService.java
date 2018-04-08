package blService.listBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import vo.BusinessProcessListVO;
import vo.CustomerInfoVO;
import vo.UserVO;

/**
 * �鿴��Ӫ���̱��߼��ӿ�
 * @author guxinyu
 * @version 2017.12.23
 *
 */
public interface BusinessProcessListBlService extends Remote{
	/**
	 * ��ȡ��Ӫ���̱�
	 * @return ���ؾ�Ӫ���̱��VO
	 * @throws RemoteException
	 */
	public BusinessProcessListVO getBusinessProcessList() throws RemoteException;
	
	/**
	 * ��ȡ�ֿ����Ա�б�
	 * @return �ֿ����ԱVO����
	 * @throws RemoteException
	 */
	public ArrayList<UserVO> getWareKeeperList() throws RemoteException;
	
	/**
	 * ��ȡ���۽���Ա�б�
	 * @return ���۽���ԱVO����
	 * @throws RemoteException
	 */
	public ArrayList<UserVO> getSalesmanList() throws RemoteException;
	
	/**
	 * ��ȡ������Ա�б�
	 * @return ������ԱVO����
	 * @throws RemoteException
	 */
	public ArrayList<UserVO> getFinancialStaffList() throws RemoteException;
	
	/**
	 * ��ȡ�ܾ����б�
	 * @return �ܾ���VO����
	 * @throws RemoteException
	 */
	public ArrayList<UserVO> getManagerList() throws RemoteException;
	
	/**
	 * ��ȡ�ͻ��б�
	 * @return �ͻ���ϢVO����
	 * @throws RemoteException
	 */
	public ArrayList<CustomerInfoVO> getCustomerList() throws RemoteException;

}
