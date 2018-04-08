package blInteract.financeInteract;

import java.rmi.RemoteException;

/**
 * �ṩ���ܾ���ĸ��������˻����Ľӿ�
 * @author guxinyu
 * @version 2017.12.11
 *
 */
public interface BankAccountSumUpdateBlService {
	/**
	 * ���������˻����
	 * @param accountName ��Ҫ���µ��˻�����
	 * @param change ��Ҫ�������Ŀ�����磬��Ҫ����1000Ԫ��Ϊ-1000.0����Ҫ����5000Ԫ��Ϊ5000.0
	 * @return ����ֵ�����Ƿ���³ɹ�
	 * @throws RemoteException
	 */
	public boolean updateRemainingSum(String accountName,double change);
}
