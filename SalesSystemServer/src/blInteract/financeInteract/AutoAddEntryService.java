package blInteract.financeInteract;

import java.rmi.RemoteException;

import vo.SingleEntryVO;

public interface AutoAddEntryService {
	/**
	 * �����տ�͸��ͨ�����ʱ���Զ������˵�����
	 * @param toAddΪҪ���ӵ����ݵ�VO
	 * @return ����ֵ�����Ƿ����ӳɹ�
	 * @throws RemoteException
	 */
	public boolean autoAddEntry(SingleEntryVO toAdd) throws RemoteException;
}
