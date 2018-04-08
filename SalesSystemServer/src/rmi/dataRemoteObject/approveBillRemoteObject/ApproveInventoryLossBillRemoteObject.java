package rmi.dataRemoteObject.approveBillRemoteObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import blImpl.bill.approveBillBl.ApproveInventoryLossBillBlController;
import blService.billService.approveBillBlService.ApproveInventoryLossBillBlService;
import vo.InventoryLossBillVO;
import vo.UserInfoVO;

/**
 * �÷����remoteObject
 * @author zhangao
 * @version 2017.12.28
 * */
public class ApproveInventoryLossBillRemoteObject  extends UnicastRemoteObject implements ApproveInventoryLossBillBlService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1237877548674340817L;

	public ApproveInventoryLossBillRemoteObject() throws RemoteException {
		super();
	}

	private ApproveInventoryLossBillBlService service = new ApproveInventoryLossBillBlController();
	
	@Override
	public ArrayList<InventoryLossBillVO> getBillsList() throws RemoteException {
		return service.getBillsList();
	}

	@Override
	public boolean passBill(String billId, UserInfoVO approver, String approverComment) throws RemoteException {
		return service.passBill(billId, approver, approverComment);
	}

	@Override
	public boolean denyBill(String billId, UserInfoVO approver, String approverComment) throws RemoteException {
		return service.denyBill(billId, approver, approverComment);
	}

}
