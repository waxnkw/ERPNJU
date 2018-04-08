package blStubs.billStubs.viewBillBlStubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.BillStateEnum;
import assistant.utility.Date;
import blService.billService.viewBillBlService.ViewFinanceStaffBillBlService;
import vo.BillEntryVO;
import vo.CashExpenseBillVO;
import vo.PaymentBillVO;
import vo.ReceiptBillVO;
import vo.UserInfoVO;
/**
 * �鿴�����൥���߼��ӿڵ�׮
 * @author guxinyu
 * @version 2017.12.6
 *
 */
public class ViewFinanceStaffBillBlService_Stub implements ViewFinanceStaffBillBlService{
	@Override
	public PaymentBillVO getPaymentBill(BillStateEnum billState, String billId) throws RemoteException {
		BillEntryVO entry1=new BillEntryVO("�������","5000");
		BillEntryVO entry2=new BillEntryVO("��ͷ��","500");
		BillEntryVO entry3=new BillEntryVO("������","2000");
		ArrayList<BillEntryVO> entries=new ArrayList<BillEntryVO>();
		entries.add(entry1);
		entries.add(entry2);
		entries.add(entry3);
		UserInfoVO maker1=new UserInfoVO();
		maker1.setName("����");
		maker1.setId("123456");
		Date date=new Date();
		
		PaymentBillVO toReturn=new PaymentBillVO("FKD-20160530-00001",
				maker1,"һ���˻�",entries,7500.0,"�ͻ�����",date);
		
		return toReturn;
	}

	@Override
	public ReceiptBillVO getReceiptBill(BillStateEnum billState, String billId) throws RemoteException {
		BillEntryVO entry1=new BillEntryVO("�������","5000");
		BillEntryVO entry2=new BillEntryVO("��ͷ��","500");
		BillEntryVO entry3=new BillEntryVO("������","2000");
		ArrayList<BillEntryVO> entries=new ArrayList<BillEntryVO>();
		entries.add(entry1);
		entries.add(entry2);
		entries.add(entry3);
		UserInfoVO maker1=new UserInfoVO();
		maker1.setName("����");
		maker1.setId("123456");
		
		Date date=new Date();
		
		ReceiptBillVO toReturn=new ReceiptBillVO("SKD-20160530-00001",
				maker1,"һ���˻�",entries,7500.0,"�ͻ�����",date);
		
		return toReturn;
	}

	@Override
	public CashExpenseBillVO getCashExpenseBill(BillStateEnum billState, String billId) throws RemoteException {
		BillEntryVO entry1=new BillEntryVO("�������","5000");
		BillEntryVO entry2=new BillEntryVO("��ͷ��","500");
		BillEntryVO entry3=new BillEntryVO("������","2000");
		ArrayList<BillEntryVO> entries=new ArrayList<BillEntryVO>();
		entries.add(entry1);
		entries.add(entry2);
		entries.add(entry3);
		UserInfoVO maker1=new UserInfoVO();
		maker1.setName("����");
		maker1.setId("123456");
		
		Date date=new Date();
		
		CashExpenseBillVO toReturn=new CashExpenseBillVO("XJFYD-20160530-00001",
				maker1,"һ���˻�",entries,7500.0,"�ͻ�����",date);
		
		return toReturn;
	}
}
