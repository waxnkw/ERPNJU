package blStubs.listBlStubs;

import blService.listBlService.NewModifyCopyBillBlService;
import vo.CashExpenseBillVO;
import vo.GiftBillVO;
import vo.InventoryLossBillVO;
import vo.InventoryOverBillVO;
import vo.InventoryWarningBillVO;
import vo.PaymentBillVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.ReceiptBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;

/**
 * �½���岢���Ƶ����߼��ӿڵ�׮
 * @author guxinyu
 * @version 2017.11.7
 *
 */
public class NewModifyCopyBillBl_Stub implements NewModifyCopyBillBlService{
	public boolean submitBill(InventoryWarningBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
	
	public boolean submitBill(InventoryOverBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
	
	public boolean submitBill(InventoryLossBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
	
	public boolean submitBill(PurchaseBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
	
	public boolean submitBill(PurchaseReturnBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
	
	public boolean submitBill(SalesBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
	
	public boolean submitBill(SalesReturnBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
	
	public boolean submitBill(ReceiptBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
	
	public boolean submitBill(PaymentBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
	
	public boolean submitBill(CashExpenseBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
	
	public boolean submitBill(GiftBillVO toSubmit){
		System.out.println("Is submitted.");
		return true;
	}
}
