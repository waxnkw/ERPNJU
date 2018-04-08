package blService.billService.viewBillBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import vo.CashExpenseBillVO;
import vo.PaymentBillVO;
import vo.ReceiptBillVO;


/**
 * �鿴������Ա�����߼��ӿ�
 * @author guxinyu
 * @version 2017.12.6
 *
 */
public interface ViewFinanceStaffBillBlService extends Remote{
	/**
	 * �鿴���
	 * @param billIdΪ������ݱ�ţ���ʽΪ"FKD-yyyymmdd-xxxxx"
	 * @return �������ظø����VO
	 * @throws RemoteException
	 */
	public PaymentBillVO getPaymentBill(String billId)throws RemoteException;
	
	/**
	 * �鿴�տ
	 * @param billIdΪ�տ���ݱ�ţ���ʽΪ"SKD-yyyymmdd-xxxxx"
	 * @return �������ظ��տ��VO
	 * @throws RemoteException
	 */
	public ReceiptBillVO getReceiptBill(String billId) throws RemoteException;
	
	/**
	 * �鿴�ֽ���õ�
	 * @param billIdΪ�ֽ���õ����ݱ�ţ���ʽΪ"XJFYD-yyyymmdd-xxxxx"
	 * @return �������ظ��ֽ���õ���VO
	 * @throws RemoteException
	 */
	public CashExpenseBillVO getCashExpenseBill(String billId)throws RemoteException;
}
