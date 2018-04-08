package blService.billService.approveBillBlService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.BillVO;
import vo.InventoryLossBillVO;
import vo.UserInfoVO;

public interface ApproveInventoryLossBillBlService {

	/**
	 * �õ�������δ���������嵥
	 * @throws RemoteException
	 * */
	public ArrayList<InventoryLossBillVO> getBillsList() throws RemoteException;
	
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
