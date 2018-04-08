package rmi.dataRemoteObject.billStateRemoteObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import assistant.type.BillStateEnum;
import blImpl.bill.billStateBl.SalesmanBillStateBlController;
import blService.billService.billStateBlService.SalesmanBillStateBlService;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;

public class SalesmanBillStateRemoteObject extends UnicastRemoteObject implements SalesmanBillStateBlService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4551441387013868109L;

	public SalesmanBillStateRemoteObject() throws RemoteException {
		super();
	}

	SalesmanBillStateBlService service=new SalesmanBillStateBlController();
	
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseBillList(BillStateEnum state) throws RemoteException {
		return service.getPurchaseBillList(state);
	}

	@Override
	public boolean deletePurchaseBill(PurchaseBillVO bill) throws RemoteException {
		return service.deletePurchaseBill(bill);
	}

	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnBillList(BillStateEnum state) throws RemoteException {
		return service.getPurchaseReturnBillList(state);
	}

	@Override
	public boolean deletePurchaseReturnBill(PurchaseReturnBillVO bill) throws RemoteException {
		return service.deletePurchaseReturnBill(bill);
	}

	@Override
	public ArrayList<SalesBillVO> getSalesBillList(BillStateEnum state) throws RemoteException {
		return service.getSalesBillList(state);
	}

	@Override
	public boolean deleteSalesBill(SalesBillVO bill) throws RemoteException {
		return service.deleteSalesBill(bill);
	}

	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnBillList(BillStateEnum state) throws RemoteException {
		return service.getSalesReturnBillList(state);
	}

	@Override
	public boolean deleteSalesReturnBill(SalesReturnBillVO bill) throws RemoteException {
		return service.deleteSalesReturnBill(bill);
	}

}
