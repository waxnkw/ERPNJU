package blService.billService.approveBillBlService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.BillVO;
import vo.ReceiptBillVO;
import vo.UserInfoVO;

public interface ApproveReceiptBillBlService {

	/**
	 * 得到该类型未审批单据清单
	 * @throws RemoteException
	 * */
	public ArrayList<ReceiptBillVO> getBillsList() throws RemoteException;
	
	/**
	 * 根据单据编号通过单据审批
	 * @throws RemoteException
	 * */
	public boolean passBill(String billId,UserInfoVO approver,String approverComment) 
			throws RemoteException;
	 
	/**
	 * 通过单据编号拒绝单据审批
	 * @throws RemoteException
	 * */
	public boolean denyBill(String billId,UserInfoVO approver,String approverComment) 
			throws RemoteException;
}
