package blDrivers.approveBillBlController;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blImpl.bill.approveBillBl.ApproveGiftBillBlController;
import blService.billService.approveBillBlService.ApproveGiftBillBlService;
import vo.GiftBillVO;

public class ApproveGiftBillBl_Driver {
	ApproveGiftBillBlService service = new ApproveGiftBillBlController();
	
	private void driveGetBillList() throws RemoteException{
		ArrayList<GiftBillVO> billPOs= service.getBillsList();
		System.out.println(billPOs.get(0).getCreater().getName());
	}
	
	public static void main(String [] args) throws RemoteException{
		ApproveGiftBillBl_Driver driver = new ApproveGiftBillBl_Driver();
		driver.driveGetBillList();
	}
}
