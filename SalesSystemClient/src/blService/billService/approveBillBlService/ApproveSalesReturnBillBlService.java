package blService.billService.approveBillBlService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.BillVO;
import vo.SalesReturnBillVO;
import vo.UserInfoVO;

public interface ApproveSalesReturnBillBlService {

	/**
	 * �õ�������δ���������嵥
	 * @throws RemoteException
	 * */
	public ArrayList<SalesReturnBillVO> getBillsList() throws RemoteException;
	
	/**
	 * ���ݵ��ݱ��ͨ����������
	 * @throws RemoteException
	 * */
	public boolean passBill(String billId,UserInfoVO approver,String approverComment) 
			throws RemoteException;
	 
	/**
	 * ͨ�����ݱ�žܾ���������
	 * @throws RemoteException
	 * */
	public boolean denyBill(String billId,UserInfoVO approver,String approverComment) 
			throws RemoteException;
}
