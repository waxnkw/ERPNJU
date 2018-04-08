package blService.financeBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import vo.InOutDetailsVO;
import vo.InitialInfoVO;

/**
 * �˵������߼��ӿ�
 * @author guxinyu
 * @version 2017.12.23
 *
 */
public interface InOutBlService extends Remote{
	/**
	 * �½��˵�ʱ�����ڳ���Ϣ
	 * @param initialInfoΪ�½��˵�ʱ��д���ڳ���Ϣ��VO
	 * @return ���صĲ���ֵ��������˵��Ƿ��½��ɹ�
	 * @throws RemoteException
	 */
	public boolean newInOut(InitialInfoVO initialInfo) throws RemoteException;
	
	/**
	 * �鿴�ڳ���Ϣ
	 * @param inOutYearΪ��Ҫ�鿴�ڳ���Ϣ����ݣ����˵�����
	 * @return ���ظ����ڳ���Ϣ��VO
	 * @throws RemoteException
	 */
	public InitialInfoVO viewInitialInformation(String inOutYear) throws RemoteException;
	
	/**
	 * �鿴�˵���ϸ
	 * @param inOutYearΪҪ�鿴��ϸ���˵�����ݣ����˵�����
	 * @return ����ֵΪ�����˵���ϸ��VO
	 * @throws RemoteException
	 */
	public InOutDetailsVO viewInOutDetails(String inOutYear) throws RemoteException;
	
	/**
	 * ��ȡ�˵��б�
	 * @return ���������˵������ƣ���String����洢
	 * @throws RemoteException
	 */
	public String[] viewInOutList() throws RemoteException;
}
