package blService.listBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import vo.ClassificationVO;
import vo.CustomerInfoVO;
import vo.GoodsVO;
import vo.SalesDetailsListVO;
import vo.UserVO;

/**
 * �鿴������ϸ���߼��ӿ�
 * @author guxinyu
 * @version 2017.12.16
 *
 */
public interface SalesDetailsListBlService extends Remote{
	/**
	 * ��ȡ������ϸ��
	 * @return ����������ϸ���VO
	 * @throws RemoteException
	 */
	public SalesDetailsListVO getSalesDetailsList() throws RemoteException;
	
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
	 * @throws Exception
	 */
	public ArrayList<UserVO> getManagerList() throws Exception;
	
	/**
	 * ��ȡ�ͻ��б�
	 * @return �ͻ���ϢVO����
	 * @throws RemoteException
	 */
	public ArrayList<CustomerInfoVO> getCustomerList() throws RemoteException;
	
	/**
	 * ��ȡ��Ʒ�����б�
	 * @return ��Ʒ�����б�
	 * @throws RemoteException
	 */
	public ArrayList<ClassificationVO> getCommodityClassification() throws RemoteException;
	
	/**
	 * ��ȡ��Ʒ�б�
	 * @return ��Ʒ�б�
	 * @throws RemoteException
	 */
	public ArrayList<GoodsVO> getCommodities() throws RemoteException;
}
