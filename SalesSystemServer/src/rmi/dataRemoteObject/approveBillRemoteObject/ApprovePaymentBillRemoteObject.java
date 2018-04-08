package rmi.dataRemoteObject.approveBillRemoteObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import blImpl.bill.approveBillBl.ApprovePaymentBillBlController;
import blService.billService.approveBillBlService.ApprovePaymentBillBlService;
import vo.PaymentBillVO;
import vo.UserInfoVO;

/**
 * 单据的审批，包括得到需要审批单据列表，和pass deny单据
 * @author 张傲  161250193
 * @version 2017.12.3
 */
public class ApprovePaymentBillRemoteObject extends UnicastRemoteObject implements ApprovePaymentBillBlService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3338623849331931477L;

	public ApprovePaymentBillRemoteObject() throws RemoteException {
		super();
	}

	private ApprovePaymentBillBlService service = new ApprovePaymentBillBlController();
	
	@Override
	public ArrayList<PaymentBillVO> getBillsList() throws RemoteException {
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
