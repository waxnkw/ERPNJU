package rmi.dataRemoteObject.billStateRemoteObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import assistant.type.BillStateEnum;
import blImpl.bill.billStateBl.WareKeeperBillStateBlController;
import blService.billService.billStateBlService.WareKeeperBillStateBlService;
import vo.GiftBillVO;
import vo.InventoryLossBillVO;
import vo.InventoryOverBillVO;
import vo.InventoryWarningBillVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;

public class WareKeeperBillStateRemoteObject extends UnicastRemoteObject implements WareKeeperBillStateBlService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6160796736759148259L;

	public WareKeeperBillStateRemoteObject() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	WareKeeperBillStateBlService service=new WareKeeperBillStateBlController();

	@Override
	public ArrayList<InventoryWarningBillVO> getInventoryWarningList(BillStateEnum state) throws RemoteException {
		return service.getInventoryWarningList(state);
	}

	@Override
	public boolean deleteUnpassInventoryWarningBill(InventoryWarningBillVO bill) throws RemoteException {
		return service.deleteUnpassInventoryWarningBill(bill);
	}

	@Override
	public ArrayList<InventoryLossBillVO> getInventoryLossList(BillStateEnum state) throws RemoteException {
		return service.getInventoryLossList(state);
	}

	@Override
	public boolean deleteUnpassInventoryLossBill(InventoryLossBillVO bill) throws RemoteException {
		return service.deleteUnpassInventoryLossBill(bill);
	}

	@Override
	public boolean doneInventoryLossBill(InventoryLossBillVO bill) throws RemoteException {
		return service.doneInventoryLossBill(bill);
	}

	@Override
	public ArrayList<InventoryOverBillVO> getInventoryOverList(BillStateEnum state) throws RemoteException {
		return service.getInventoryOverList(state);
	}

	@Override
	public boolean deleteUnpassInventoryOverBill(InventoryOverBillVO bill) throws RemoteException {
		return service.deleteUnpassInventoryOverBill(bill);
	}

	@Override
	public boolean doneInventoryOverBill(InventoryOverBillVO bill) throws RemoteException {
		return service.doneInventoryOverBill(bill);
	}

	@Override
	public ArrayList<PurchaseBillVO> getPurchaseBillList(BillStateEnum state) throws RemoteException {
		return service.getPurchaseBillList(state);
	}

	@Override
	public boolean donePurchaseBill(PurchaseBillVO bill) throws RemoteException {
		return service.donePurchaseBill(bill);
	}

	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnBillList(BillStateEnum state) throws RemoteException {
		return service.getPurchaseReturnBillList(state);
	}

	@Override
	public boolean donePurchaseReturnBill(PurchaseReturnBillVO bill) throws RemoteException {
		return service.donePurchaseReturnBill(bill);
	}

	@Override
	public ArrayList<SalesBillVO> getSalesBillList(BillStateEnum state) throws RemoteException {
		return service.getSalesBillList(state);
	}

	@Override
	public boolean doneSalesBill(SalesBillVO bill) throws RemoteException {
		return service.doneSalesBill(bill);
	}

	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnBillList(BillStateEnum state) throws RemoteException {
		return service.getSalesReturnBillList(state);
	}

	@Override
	public boolean doneSalesReturnBill(SalesReturnBillVO bill) throws RemoteException {
		return service.doneSalesReturnBill(bill);
	}

	@Override
	public ArrayList<GiftBillVO> getGiftBillList(BillStateEnum state) throws RemoteException {
		return service.getGiftBillList(state);
	}

	@Override
	public boolean doneGiftBill(GiftBillVO bill) throws RemoteException {
		return service.doneGiftBill(bill);
	}
	
}
