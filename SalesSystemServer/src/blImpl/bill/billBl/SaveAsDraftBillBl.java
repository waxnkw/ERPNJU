package blImpl.bill.billBl;

import assistant.type.BillCategoryEnum;
import assistant.utility.Date;
import dataImpl.billData.SaveAsDraftBillData;
import dataService.billDataService.SaveAsDraftBillDataService;
import po.BillPO;
import po.CashExpenseBillPO;
import po.GiftBillPO;
import po.InventoryLossBillPO;
import po.InventoryOverBillPO;
import po.InventoryWarningBillPO;
import po.PaymentBillPO;
import po.PurchaseBillPO;
import po.PurchaseReturnBillPO;
import po.ReceiptBillPO;
import po.SalesBillPO;
import po.SalesReturnBillPO;

/**
 * @author zhangao 161250193
 * @version 2017.11.28
 * �����ݴ���Ϊ�ݸ�״̬
 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
 */

public class SaveAsDraftBillBl {
	
	 private SaveAsDraftBillDataService saveAsDraftBillDataService = new SaveAsDraftBillData();//���ݲ����
	
	 
	/**
	 * ����һ���µĿ�����͵��ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param GiftBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	public boolean saveAsDraftGiftBill(GiftBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftGiftBill(bill);
	}

	/**
	 * ����һ���µĿ�汨�絥��<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param InventoryOverBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */

	public boolean saveAsDraftInventoryOverBill(InventoryOverBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftInventoryOverBill(bill);
	}

	/**
	 * ����һ���µĿ�汨������<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param InventoryWarningBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */

	public boolean saveAsDraftInventoryWarningBill(InventoryWarningBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftInventoryWarningBill(bill);
	}

	/**
	 * ����һ���µĿ�汨�𵥡�<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param InventoryLossBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */

	public boolean saveAsDraftInventoryLossBill(InventoryLossBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftInventoryLossBill(bill);
	}

	/**
	 * ����һ���µĽ�������<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param PurchaseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */

	public boolean saveAsDraftPurchaseBill(PurchaseBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftPurchaseBill(bill);
	}

	/**
	 * ����һ���µĽ����˻�����<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param PurchaseReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */

	public boolean saveAsDraftPurchaseReturnBill(PurchaseReturnBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftPurchaseReturnBill(bill);
	}

	/**
	 * ����һ���µ����۵���<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param SalesBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */

	public boolean saveAsDraftSalesBill(SalesBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftSalesBill(bill);
	}

	/**
	 * ����һ���µ������˻�����<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param SalesReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */

	public boolean saveAsDraftSalesReturnBill(SalesReturnBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftSalesReturnBill(bill);
	}

	/**
	 * ����һ���µ��տ��<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param ReceiptBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */

	public boolean saveAsDraftReceiptBill(ReceiptBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftReceiptBill(bill);
	}

	/**
	 * ����һ���µĸ����<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param PaymentBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */

	public boolean saveAsDraftPaymentBill(PaymentBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftPaymentBill(bill);
	}

	/**
	 * ����һ���µ��ֽ���õ���<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param CashExpenseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */

	public boolean saveAsDraftCashExpenseBill(CashExpenseBillPO bill) {
		setBillId(bill);
		return saveAsDraftBillDataService.saveAsDraftCashExpenseBill(bill);
	}
	
	/**
	 * ����draftģʽ�µ�bill��Id��<br/>
	 * Id�ĸ�ʽΪ ��������+�û��˺�+��-��+����������+Сʱ+����+�� ���磺KCZSD_12345-20170206-02-44-15
	 * @param GiftBillPO bill ��Ҫ�趨Id�ĵ��� 
	 * @return void
	 */
	private void setBillId(BillPO bill){
		if(bill.getId()!=null){return;}//�Ѿ����ù�Id,Ϊ�Ѵ��ڲݸ�
		String Id="";
		BillCategoryEnum category = bill.getCategoryEnum();
		Date createDate = bill.getCreateDate();
		Id += category.toBillIdPart()+"_";
		Id += createDate.getBillDraftIdPart();
		bill.setId(Id);
	}
}
