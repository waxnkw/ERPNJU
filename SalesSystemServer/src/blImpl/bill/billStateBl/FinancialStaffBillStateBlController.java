package blImpl.bill.billStateBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.FinanceBillsPOVOConvertor;
import assistant.convertors.SalesmanBillsPOVOConvertor;
import assistant.type.BillStateEnum;
import blImpl.bill.billBl.CashExpenseBillBl;
import blImpl.bill.billBl.PaymentBillBl;
import blImpl.bill.billBl.PurchaseBillBl;
import blImpl.bill.billBl.PurchaseReturnBillBl;
import blImpl.bill.billBl.ReceiptBillBl;
import blImpl.bill.billBl.SalesBillBl;
import blImpl.bill.billBl.SalesReturnBillBl;
import blInteract.billBlInteract.CashExpenseBillBlService;
import blInteract.billBlInteract.PaymentBillBlService;
import blInteract.billBlInteract.PurchaseBillBlService;
import blInteract.billBlInteract.PurchaseReturnBillBlService;
import blInteract.billBlInteract.ReceiptBillBlService;
import blInteract.billBlInteract.SalesBillBlService;
import blInteract.billBlInteract.SalesReturnBillBlService;
import blService.billService.billStateBlService.FinancialStaffBillStateBlService;
import po.CashExpenseBillPO;
import po.PaymentBillPO;
import po.PurchaseBillPO;
import po.PurchaseReturnBillPO;
import po.ReceiptBillPO;
import po.SalesBillPO;
import po.SalesReturnBillPO;
import vo.CashExpenseBillVO;
import vo.PaymentBillVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.ReceiptBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;

/**
 * ������Ա����״̬�Ŀ���ģ��
 * @author guxinyu
 * @version 2017.12.20
 *
 */
public class FinancialStaffBillStateBlController implements FinancialStaffBillStateBlService{
	PurchaseBillBlService purchaseBillService=new PurchaseBillBl();
	PurchaseReturnBillBlService purchaseReturnBillService=new PurchaseReturnBillBl();
	SalesBillBlService salesBillService=new SalesBillBl();
	SalesReturnBillBlService salesReturnBillService=new SalesReturnBillBl();
	CashExpenseBillBlService cashExpenseBillService=new CashExpenseBillBl();
	PaymentBillBlService paymentBillService=new PaymentBillBl();
	ReceiptBillBlService receiptBillService=new ReceiptBillBl();
	
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseBillList(BillStateEnum state) throws RemoteException {
		ArrayList<PurchaseBillPO> po=purchaseBillService.getBillListByState(state);
		
		ArrayList<PurchaseBillVO> vo=new ArrayList<PurchaseBillVO>();
		
		for(int i=0;i<po.size();i++){
			PurchaseBillVO eachVO=SalesmanBillsPOVOConvertor.purchaseBillPOtoVO(po.get(i));
			vo.add(eachVO);
		}
		return vo;
	}

	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnBillList(BillStateEnum state) throws RemoteException {
		ArrayList<PurchaseReturnBillPO> po=purchaseReturnBillService.getBillListByState(state);
		
		ArrayList<PurchaseReturnBillVO> vo=new ArrayList<PurchaseReturnBillVO>();
		
		for(int i=0;i<po.size();i++){
			PurchaseReturnBillVO eachVO=SalesmanBillsPOVOConvertor.purchaseReturnBillPOtoVO(po.get(i));
			vo.add(eachVO);
		}
		return vo;
	}

	@Override
	public ArrayList<SalesBillVO> getSalesBillList(BillStateEnum state) throws RemoteException {
		ArrayList<SalesBillPO> po=salesBillService.getBillListByState(state);
		
		ArrayList<SalesBillVO> vo=new ArrayList<SalesBillVO>();
		
		for(int i=0;i<po.size();i++){
			SalesBillVO eachVO=SalesmanBillsPOVOConvertor.salesBillPOtoVO(po.get(i));
			vo.add(eachVO);
		}
		return vo;
	}

	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnBillList(BillStateEnum state) throws RemoteException {
		ArrayList<SalesReturnBillPO> po=salesReturnBillService.getBillListByState(state);
		
		ArrayList<SalesReturnBillVO> vo=new ArrayList<SalesReturnBillVO>();
		
		for(int i=0;i<po.size();i++){
			SalesReturnBillVO eachVO=SalesmanBillsPOVOConvertor.salesReturnBillPOtoVO(po.get(i));
			vo.add(eachVO);
		}
		return vo;
	}

	@Override
	public ArrayList<CashExpenseBillVO> getCashExpenseBillList(BillStateEnum state) throws RemoteException {
		ArrayList<CashExpenseBillPO> po=cashExpenseBillService.getBillListByState(state);
		
		ArrayList<CashExpenseBillVO> vo=new ArrayList<CashExpenseBillVO>();
		
		for(int i=0;i<po.size();i++){
			CashExpenseBillVO each=FinanceBillsPOVOConvertor.cashExpenseBillPOtoVO(po.get(i));
			vo.add(each);
		}
		
		return vo;
	}

	@Override
	public ArrayList<PaymentBillVO> getPaymentBillList(BillStateEnum state) throws RemoteException {
		ArrayList<PaymentBillPO> po=paymentBillService.getBillListByState(state);
		
		ArrayList<PaymentBillVO> vo=new ArrayList<PaymentBillVO>();
		
		for(int i=0;i<po.size();i++){
			PaymentBillVO each=FinanceBillsPOVOConvertor.paymentBillPOtoVO(po.get(i));
			vo.add(each);
		}
		
		return vo;
	}

	@Override
	public ArrayList<ReceiptBillVO> getReceiptBillList(BillStateEnum state) throws RemoteException {
		ArrayList<ReceiptBillPO> po=receiptBillService.getBillListByState(state);
		
		ArrayList<ReceiptBillVO> vo=new ArrayList<ReceiptBillVO>();
		
		for(int i=0;i<po.size();i++){
			ReceiptBillVO each=FinanceBillsPOVOConvertor.receiptBillPOtoVO(po.get(i));
			vo.add(each);
		}
		
		return vo;
	}

	@Override
	public boolean deleteUnpassCashExpenseBill(CashExpenseBillVO toDelete) throws RemoteException {
		CashExpenseBillPO po=FinanceBillsPOVOConvertor.cashExpenseBillVOtoPO(toDelete);
		
		if(cashExpenseBillService.hideBill(po))
			return true;
		else 
			return false;
	}

	@Override
	public boolean deleteUnpassPaymentBill(PaymentBillVO toDelete) throws RemoteException {
		PaymentBillPO po=FinanceBillsPOVOConvertor.paymentBillVOtoPO(toDelete);
		
		if(paymentBillService.hideBill(po))
			return true;
		else 
			return false;
	}

	@Override
	public boolean deleteUnpassReceiptBill(ReceiptBillVO toDelete) throws RemoteException {
		ReceiptBillPO po=FinanceBillsPOVOConvertor.receiptBillVOtoPO(toDelete);
		
		if(receiptBillService.hideBill(po))
			return true;
		else 
			return false;
	}
	
}
