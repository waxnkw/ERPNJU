package blMocks.listBlMocks;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.utility.Date;
import vo.BusinessProcessListVO;
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

public class MockBusinessProcessList {
	public BusinessProcessListVO getBills() throws RemoteException {
		InventoryWarningBillVO iwb=new InventoryWarningBillVO();
		ArrayList<InventoryWarningBillVO> iwbArray=new ArrayList<InventoryWarningBillVO>();
		iwbArray.add(iwb);
		
		InventoryOverBillVO iob=new InventoryOverBillVO();
		ArrayList<InventoryOverBillVO> iobArray=new ArrayList<InventoryOverBillVO>();
		iobArray.add(iob);
		
		InventoryLossBillVO ilb=new InventoryLossBillVO();
		ArrayList<InventoryLossBillVO> ilbArray=new ArrayList<InventoryLossBillVO>();
		ilbArray.add(ilb);
		
		String[] b={" "," "};
		PurchaseBillVO pb=new PurchaseBillVO("i4851","����",14," ",b," ", 5000.0," ");
		ArrayList<PurchaseBillVO> pbArray=new ArrayList<PurchaseBillVO>();
		pbArray.add(pb);
		
		PurchaseReturnBillVO prb=new PurchaseReturnBillVO("i4851","����",14," ",b," ", 5000.0," ");
		ArrayList<PurchaseReturnBillVO> prbArray=new ArrayList<PurchaseReturnBillVO>();
		prbArray.add(prb);
		
		String[] a={" "," "};
		SalesBillVO sb=new SalesBillVO("i4541","����","����","����",14,
				a,50.0,50.0,50.0,50.0," ",new Date());
		ArrayList<SalesBillVO> sbArray=new ArrayList<SalesBillVO>();
		sbArray.add(sb);
		
		SalesReturnBillVO srb=new SalesReturnBillVO("i4541","����","����","����",14,
				a,50.0," ",new Date());
		ArrayList<SalesReturnBillVO> srbArray=new ArrayList<SalesReturnBillVO>();
		srbArray.add(srb);
		
		String[] entry1={"�������","5000","�ͻ�����"};
		String[] entry2={"��ͷ��","500","�ͻ�����"};
		String[] entry3={"������","2000","�ͻ�����"};
		ArrayList<String[]> entries1=new ArrayList<String[]>();
		entries1.add(entry1);
		entries1.add(entry2);
		entries1.add(entry3);
		ReceiptBillVO rb=new ReceiptBillVO("XJFYD-20160530-00001",
				"����","һ���˻�",entries1,7500.0,new Date());
		ArrayList<ReceiptBillVO> rbArray=new ArrayList<ReceiptBillVO>();
		rbArray.add(rb);

		String[] entry4={"�������","5000","�ͻ�����"};
		String[] entry5={"��ͷ��","500","�ͻ�����"};
		String[] entry6={"������","2000","�ͻ�����"};
		ArrayList<String[]> entries2=new ArrayList<String[]>();
		entries2.add(entry4);
		entries2.add(entry5);
		entries2.add(entry6);
		PaymentBillVO pmb=new PaymentBillVO("XJFYD-20160530-00001",
				"����","һ���˻�",entries2,7500.0,new Date());
		ArrayList<PaymentBillVO> pmbArray=new ArrayList<PaymentBillVO>();
		pmbArray.add(pmb);
		
		String[] entry7={"�������","5000","�ͻ�����"};
		String[] entry8={"��ͷ��","500","�ͻ�����"};
		String[] entry9={"������","2000","�ͻ�����"};
		ArrayList<String[]> entries3=new ArrayList<String[]>();
		entries3.add(entry7);
		entries3.add(entry8);
		entries3.add(entry9);
		CashExpenseBillVO ceb=new CashExpenseBillVO("XJFYD-20160530-00001",
				"����","һ���˻�",entries3,7500.0,new Date());
		ArrayList<CashExpenseBillVO> cebArray=new ArrayList<CashExpenseBillVO>();
		cebArray.add(ceb);
		
		GiftBillVO gb=new GiftBillVO();
		ArrayList<GiftBillVO> gbArray=new ArrayList<GiftBillVO>();
		gbArray.add(gb);
		
		BusinessProcessListVO toReturn=new BusinessProcessListVO(
				iwbArray,iobArray,ilbArray,pbArray,prbArray,
				sbArray,srbArray,rbArray,pmbArray,cebArray,gbArray);
		
		return toReturn;
	}
}
