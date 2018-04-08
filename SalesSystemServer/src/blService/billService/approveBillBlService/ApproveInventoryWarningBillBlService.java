package blService.billService.approveBillBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.InventoryWarningBillVO;
import vo.UserInfoVO;

public interface ApproveInventoryWarningBillBlService extends Remote {

	/**
	 * �õ�������δ���������嵥
	 * @throws RemoteException
	 * */
	public ArrayList<InventoryWarningBillVO> getBillsList() throws RemoteException;
	
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