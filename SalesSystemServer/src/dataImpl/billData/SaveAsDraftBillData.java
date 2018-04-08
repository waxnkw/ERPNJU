package dataImpl.billData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import assistant.type.BillCategoryEnum;
import assistant.utility.Date;
import assistant.utility.ReadAndWriteTxtUtility;
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
 * @version 2017.11.21
 * �����ݴ���Ϊ�ݸ�״̬
 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
 */
public class SaveAsDraftBillData implements SaveAsDraftBillDataService{

	private static final String FILE_EXTENSION = ".ser";
	private static final String ROOT_PATH = "data"+File.separator+"bill"+File.separator;//��Ŀ¼��ַ
	private static final String STATE_PATH = "draft"+File.separator;//��Ӧ��״̬�ļ��е�ַ
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
	 * ����һ���µĿ�����͵��ݸ塣<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param GiftBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftGiftBill(GiftBillPO bill) {
		String path = GIFT_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĿ�汨�絥��<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param InventoryOverBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftInventoryOverBill(InventoryOverBillPO bill) {
		String path = INVENTORY_OVER_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĿ�汨������<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param InventoryWarningBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftInventoryWarningBill(InventoryWarningBillPO bill) {
		String path = INVENTORY_WARNING_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĿ�汨�𵥡�<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param InventoryLossBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftInventoryLossBill(InventoryLossBillPO bill) {
		String path = INVENTORY_LOSS_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĽ�������<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param PurchaseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftPurchaseBill(PurchaseBillPO bill) {
		String path = PURCHASE_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĽ����˻�����<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param PurchaseReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftPurchaseReturnBill(PurchaseReturnBillPO bill) {
		String path =  PURCHASE_RETURN_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µ����۵���<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param SalesBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftSalesBill(SalesBillPO bill) {
		String path = SALES_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µ������˻�����<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param SalesReturnBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftSalesReturnBill(SalesReturnBillPO bill) {
		String path = SALES_RETURN_BILL+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µ��տ��<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param ReceiptBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftReceiptBill(ReceiptBillPO bill) {
		String path = RECEIPT_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µĸ����<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param PaymentBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftPaymentBill(PaymentBillPO bill) {
		String path = PAYMENT_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��	
		return writeObj(bill, path);
	}

	/**
	 * ����һ���µ��ֽ���õ���<br/>
	 * ���Ѿ����ڸòݸ壬�򸲸��ϴ�����
	 * @param CashExpenseBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean �Ƿ����ӳɹ�
	 */
	@Override
	public boolean saveAsDraftCashExpenseBill(CashExpenseBillPO bill) {
		String path = CASH_EXPENSE_BILL_PATH+bill.getId()+".ser";//��ǰ�ļ�Ҫ���λ��
		return writeObj(bill, path);
	}
	
	/**
	 * дbill��ser�ļ���<br/>
	 * @param GiftBillPO bill ��Ҫ�½��ĵ��� 
	 * @return boolean ��д�ļ��ɹ�
	 */
	private boolean writeObj(BillPO bill,String path){
		ObjectOutputStream oStream ;
//		System.out.println(path);
		try {
			oStream = new ObjectOutputStream(new FileOutputStream(path));
			oStream.writeObject(bill);
			oStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
