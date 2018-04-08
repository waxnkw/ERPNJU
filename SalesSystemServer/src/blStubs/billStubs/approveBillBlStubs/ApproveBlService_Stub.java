package blStubs.billStubs.approveBillBlStubs;

import java.util.ArrayList;

import assistant.type.BillCategoryEnum;
import blService.billService.approveBillBlService.ApproveCashExpenseBillBlService;
import vo.BillVO;

public class ApproveBlService_Stub implements ApproveCashExpenseBillBlService {

	@Override
	public ArrayList<BillVO> getBillsList(BillCategoryEnum billCategoryEnum) {
		ArrayList<BillVO> bills = null;
		bills.add(new BillVO());
		bills.add(new BillVO());
		bills.add(new BillVO());
		bills.add(new BillVO());
		return bills;
	}

	@Override
	public boolean passBill(String billName, String billId) {
		if(billName==""&&billId=="KCBYD-20160530-00001"){return true;}
		return false;
	}

	@Override
	public boolean denyBill(String billName, String billId) {
		if(billName==""&&billId=="KCBYD-20160530-00001"){return true;}
		return false;
	}

}
