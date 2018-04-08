package dataImpl.billData;

import java.io.File;

import assistant.type.BillCategoryEnum;
import assistant.utility.ReadAndWriteBillPOSerUtility;
import dataService.billDataService.CreateBillDataService;
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
 * @version 2017.11.9
 * ��������
 */

public class CreateBillData implements CreateBillDataService{
	//private static final int BILL_ID_LENGTH=5;//���ݱ�ŵĳ��ȣ�����Ϊ5.��KCZSD-20171108-00001��00001����
	
	private static final String ROOT_PATH = "data"+File.separator+"bill"+File.separator;//��Ŀ¼��ַ
	private static final String STATE_PATH = "tbd"+File.separator;//��Ӧ��״̬�ļ��е�ַ
	public static final String CREATE_RECORD = "create_record.txt" ;
	private static final String GIFT_BILL_PATH = ROOT_PATH +BillCategoryEnum.GIFT_BILL.toString()+File.separator+STATE_PATH ;//������͵��ĵ�ַ
	private static final String CASH_EXPENSE_BILL_PATH = ROOT_PATH +BillCategoryEnum.CASH_EXPENSE_BILL.toString()+File.separator+STATE_PATH ;//�ֽ���õ��ĵ�ַ
	private static final String INVENTORY_LOSS_BILL_PATH = ROOT_PATH +BillCategoryEnum.INVENTORY_LOSS_BILL.toString()+File.separator+STATE_PATH ;//��汨�𵥵ĵ�ַ
	private static final String INVENTORY_OVER_BILL_PATH = ROOT_PATH +BillCategoryEnum.INVENTORY_OVER_BILL.toString()+File.separator+STATE_PATH ;//��汨�絥�ĵ�ַ
	private static final String INVENTORY_WARNING_BILL_PATH = ROOT_PATH +BillCategoryEnum.INVENTORY_WARNING_BILL.toString()+File.separator+STATE_PATH ;//��汨�����ĵ�ַ
	private static final String PAYMENT_BILL_PATH = ROOT_PATH +BillCategoryEnum.PAYMENT_BILL.toString()+File.separator+STATE_PATH ;//����ĵ�ַ
	private static final String PURCHASE_BILL_PATH = ROOT_PATH +BillCategoryEnum.PURCHASE_BILL.toString()+File.separator+STATE_PATH ;//�������ĵ�ַ
	private static final String PURCHASE_RETURN_BILL_PATH = ROOT_PATH +BillCategoryEnum.PURCHASE_RETURN_BILL.toString()+File.separator+STATE_PATH ;//�����˻����ĵ�ַ
	private static final String RECEIPT_BILL_PATH = ROOT_PATH +BillCategoryEnum.RECEIPT_BILL.toString()+File.separator+STATE_PATH ;//�տ�ĵ�ַ
	private static final String SALES_BILL_PATH = ROOT_PATH +BillCategoryEnum.SALES_BILL.toString()+File.separator+STATE_PATH ;//���۵��ĵ�ַ
	private static final String SALES_RETURN_BILL = ROOT_PATH +BillCategoryEnum.SALES_RETURN_BILL.toString()+File.separator+STATE_PATH ;//�����˻����ĵ�ַ
	
	/**
	 * ����һ���µĿ�����͵���<br/>
	 * @param GiftBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createGiftBill(GiftBillPO bill) {
		String path = GIFT_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĿ�汨�絥��<br/>
	 * @param InventoryOverBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createInventoryOverBill(InventoryOverBillPO bill) {
		String path = INVENTORY_OVER_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĿ�汨������<br/>
	 * @param InventoryWarningBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createInventoryWarningBill(InventoryWarningBillPO bill) {
		String path = INVENTORY_WARNING_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĿ�汨�𵥡�<br/>
	 * @param InventoryLossBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createInventoryLossBill(InventoryLossBillPO bill) {
		String path = INVENTORY_LOSS_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĽ�������<br/>
	 * @param PurchaseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createPurchaseBill(PurchaseBillPO bill) {
		String path = PURCHASE_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĽ����˻�����<br/>
	 * @param PurchaseReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createPurchaseReturnBill(PurchaseReturnBillPO bill) {
		String path =  PURCHASE_RETURN_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µ����۵���<br/>
	 * @param SalesBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createSalesBill(SalesBillPO bill) {
		String path = SALES_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µ������˻�����<br/>
	 * @param SalesReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createSalesReturnBill(SalesReturnBillPO bill) {
		String path = SALES_RETURN_BILL+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µ��տ��<br/>
	 * @param ReceiptBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createReceiptBill(ReceiptBillPO bill) {
		String path = RECEIPT_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĸ����<br/>
	 * @param PaymentBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createPaymentBill(PaymentBillPO bill) {
		String path = PAYMENT_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µ��ֽ���õ���<br/>
	 * @param CashExpenseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean createCashExpenseBill(CashExpenseBillPO bill) {
		String path = CASH_EXPENSE_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}
	
	/**
	 * дbill��ser�ļ���<br/>
	 * @param GiftBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean ��д�ļ��ɹ�
	 */
	private boolean writeObj(BillPO bill,String path){
		return ReadAndWriteBillPOSerUtility.writeObj(bill, path);
	}
}
