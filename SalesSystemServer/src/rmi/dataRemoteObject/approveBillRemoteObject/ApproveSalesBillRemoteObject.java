 package rmi.dataRemoteObject.approveBillRemoteObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import blImpl.bill.approveBillBl.ApproveSalesBillBlController;
import blService.billService.approveBillBlService.ApproveSalesBillBlService;
import vo.SalesBillVO;
import vo.UserInfoVO;

/**
 * ���ݵ������������õ���Ҫ���������б���pass deny����
 * @author �Ű�  161250193
 * @version 2017.12.3
 */
public class ApproveSalesBillRemoteObject extends UnicastRemoteObject implements ApproveSalesBillBlService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476794552195113588L;

	public ApproveSalesBillRemoteObject() throws RemoteException {
		super();
	}

	private ApproveSalesBillBlService service = new ApproveSalesBillBlController();
	
	@Override
	public ArrayList<SalesBillVO> getBillsList() throws RemoteException {
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
