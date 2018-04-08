package blService.financeBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import assistant.exception.AccountNameExistException;
import vo.BankAccountVO;


/**
 * �����˻������߼��ӿ�
 * @author guxinyu
 * @version 2017.12.30
 *
 */
public interface BankAccountBlService extends Remote{
	/**
	 * �½������˻�ʱ���˽ӿڽ��������˻�����
	 * @param toSave��Ҫ������������˻���VO
	 * @return ���صĲ���ֵ���������˻��Ƿ񱣴�ɹ�
	 * @throws RemoteException
	 */
	public boolean newBankAccount(BankAccountVO toSave) throws RemoteException, AccountNameExistException;
	
	/**
	 * ��������˻��б�
	 * @return �������������˻���VO����ArrayList�洢
	 * @throws RemoteException
	 */
	public ArrayList<BankAccountVO> viewBankAccounts() throws RemoteException;
	
	/**
	 * ���������˻���
	 * @param oldAccountNameΪ����ǰ���˻���
	 * @param newAccountNameΪ���º���˻���
	 * @return ���صĲ���ֵ�����Ƿ���³ɹ�
	 * @throws RemoteException
	 */
	public boolean updateAccount(String oldAccountName, String newAccountName) throws RemoteException, AccountNameExistException;
	
	/**
	 * ɾ�������˻�
	 * @param toDeleteΪ��Ҫ��ɾ���������˻�������
	 * @return ���صĲ���ֵ�����Ƿ�ɾ���ɹ�
	 * @throws RemoteException
	 */
	public boolean deleteAccount(String toDelete) throws RemoteException;
	
}
