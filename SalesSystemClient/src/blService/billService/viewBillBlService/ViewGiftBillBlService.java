package blService.billService.viewBillBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import assistant.exception.Myexception;
import vo.GiftBillVO;
/**
 * @author zhangao 
 * @version 2017.12.28
 * */

public interface ViewGiftBillBlService extends Remote {
	
	/**
	 * ���ݵ���Id�õ�һ��giftBill
	 * @param billId���ݵ�ID
	 * @return GiftVO �ñ�ŵĵ���
	 * @throws RemoteException
	 * @throws Myexception �Զ����쳣
	 * */
	public GiftBillVO getGiftBill(String billId) throws RemoteException,Myexception;
}
