package blService.listBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.BusinessConditionListVO;

/**
 * ��Ӫ������߼��ӿ�
 * @author guxinyu
 * @version 2017.11.7
 *
 */
public interface BusinessConditionListBlService extends Remote{
	/**
	 * ��ȡ��Ӫ�����
	 * @return ���ؾ�Ӫ������VO
	 * @throws RemoteException
	 */
	public BusinessConditionListVO getBusinessConditionList() throws RemoteException;
}
