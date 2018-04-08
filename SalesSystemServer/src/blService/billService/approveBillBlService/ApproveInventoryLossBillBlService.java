package blService.billService.approveBillBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.InventoryLossBillVO;
import vo.UserInfoVO;

public interface ApproveInventoryLossBillBlService extends Remote{

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
