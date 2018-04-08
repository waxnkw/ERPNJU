package blImpl.salesBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.convertors.SalesmanBillsPOVOConvertor;
import assistant.convertors.UserInfoPOVOConvertor;
import vo.GoodsVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;

import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.PurchaseBillBlService;
import blInteract.billBlInteract.PurchaseReturnBillBlService;
import blInteract.billBlInteract.SalesBillBlService;
import blInteract.billBlInteract.SalesReturnBillBlService;
import blInteract.commodityInteract.CommodityBlInteractServiceFactory;
import blInteract.commodityInteract.GoodsListService;
import po.PurchaseBillPO;
import po.PurchaseReturnBillPO;
import po.SalesBillPO;
import po.SalesReturnBillPO;
import po.UserInfoPO;
import vo.UserInfoVO;

/**
 * ����������Ա�ƶ����ݵ�ҵ���߼�
 * @author ����һ
 * @version 2017.11.7
 *
 */

public class SalesBl {
	
	BillBlInteractServiceFactory factory=new BillBlInteractServiceFactory();
	PurchaseBillBlService purBillBlService=factory.getPurchaseBillBlService();
	PurchaseReturnBillBlService purReBillBlService=factory.getPurchaseReturnBillBlService();
	SalesBillBlService salesBillBlService=factory.getSalesBillBlService();
	SalesReturnBillBlService salesReBillBlService=factory.getSalesReturnBillBlService();
	CommodityBlInteractServiceFactory GoodsFactory=new CommodityBlInteractServiceFactory();
	GoodsListService goodsListService=GoodsFactory.getGoodsListBlService();
	
	/**
	 * �½�һ�Ź�Ӧ�̽�����
	 * @param PurchaseBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean NewPurchase(PurchaseBillVO vo) {
		PurchaseBillPO bill=SalesmanBillsPOVOConvertor.purchaseBillVOtoPO(vo);
		boolean success=purBillBlService.createBill(bill);
		return success;
	}
	
	/**
	 * �½�һ�Ź�Ӧ�̽������ݸ�
	 * @param PurchaseBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean NewPurchaseDraft(PurchaseBillVO vo) {
		PurchaseBillPO bill=SalesmanBillsPOVOConvertor.purchaseBillVOtoPO(vo);
		boolean success=purBillBlService.saveAsDraftBill(bill);
		return success;
	}
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param PurchaseBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean UpdatePurchaseDraft(PurchaseBillVO vo) {
		PurchaseBillPO bill=SalesmanBillsPOVOConvertor.purchaseBillVOtoPO(vo);
		boolean success=purBillBlService.updateDraftBill(bill);
		return success;
	}
	
	
	/**
	 * ͨ��Idɾ��һ�Ž������ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean DeletePurchaseDraft(String Id) {
		boolean success=purBillBlService.deleteDraftBill(Id);
		return success;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean SubmitPurchase(String Id) {
		boolean success=purBillBlService.submitBill(Id);
		return success;
	}
	
	/**
	 * �½�һ�Ź�Ӧ�̽����˻���
	 * @param PurchaseReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean NewPurReturn(PurchaseReturnBillVO vo) {
		PurchaseReturnBillPO bill=SalesmanBillsPOVOConvertor.purchaseReturnBillVOtoPO(vo);
		boolean success=purReBillBlService.createBill(bill);
		return success;		
	}
	
	/**
	 * �½�һ�Ź�Ӧ�̽����˻����ݸ�
	 * @param PurchaseReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean NewPurReturnDraft(PurchaseReturnBillVO vo) {
		PurchaseReturnBillPO bill=SalesmanBillsPOVOConvertor.purchaseReturnBillVOtoPO(vo);
		boolean success=purReBillBlService.saveAsDraftBill(bill);
		return success;
	}
	
	/**
	 * ����һ�Ź�Ӧ�̽����˻����ݸ�
	 * @param PurchaseReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean UpdatePurReturnDraft(PurchaseReturnBillVO vo) {
		PurchaseReturnBillPO bill=SalesmanBillsPOVOConvertor.purchaseReturnBillVOtoPO(vo);
		boolean success=purReBillBlService.updateDraftBill(bill);
		return success;
	}
	
	/**
	 * ͨ��Idɾ��һ�Ž����˻����ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean DeletePurReturnDraft(String Id) {
		boolean success=purReBillBlService.deleteDraftBill(Id);
		return success;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean SubmitPurReturn(String Id) {
		boolean success=purReBillBlService.submitBill(Id);
		return success;
	}
	
	/**
	 * �½�һ�������̳�����
	 * @param SalesBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean NewSales(SalesBillVO vo) {
		SalesBillPO bill = SalesmanBillsPOVOConvertor.salesBillVOtoPO(vo);
		boolean success = salesBillBlService.createBill(bill);
		return success;
	}
	
	/**
	 * �½�һ�������̳������ݸ�
	 * @param SalesBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean NewSalesDraft(SalesBillVO vo) {
		SalesBillPO bill = SalesmanBillsPOVOConvertor.salesBillVOtoPO(vo);
		boolean success = salesBillBlService.saveAsDraftBill(bill);
		return success;
	}
	
	/**
	 * ����һ�������̳������ݸ�
	 * @param SalesBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean UpdateSalesDraft(SalesBillVO vo) {
		SalesBillPO bill = SalesmanBillsPOVOConvertor.salesBillVOtoPO(vo);
		boolean success = salesBillBlService.updateDraftBill(bill);
		return success;
	}
	
	/**
	 * ͨ��Idɾ��һ�ų������ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean DeleteSalesDraft(String Id) {
		boolean success=salesBillBlService.deleteDraftBill(Id);
		return success;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean SubmitSales(String Id) {
		boolean success=salesBillBlService.submitBill(Id);
		return success;
	}
	
	/**
	 * �½�һ�������̳����˻���
	 * @param SalesReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean NewSalReturn(SalesReturnBillVO vo) {
		SalesReturnBillPO bill=SalesmanBillsPOVOConvertor.salesReturnBillVOtoPO(vo);
		boolean success=salesReBillBlService.createBill(bill);
		return success;
	}
	
	/**
	 * �½�һ�������̳����˻����ݸ�
	 * @param SalesReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean NewSalReturnDraft(SalesReturnBillVO vo) {
		SalesReturnBillPO bill=SalesmanBillsPOVOConvertor.salesReturnBillVOtoPO(vo);
		boolean success=salesReBillBlService.saveAsDraftBill(bill);
		return success;
	}
	
	/**
	 * ����һ�������̳����˻����ݸ�
	 * @param SalesReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean UpdateSalReturnDraft(SalesReturnBillVO vo) {
		SalesReturnBillPO bill=SalesmanBillsPOVOConvertor.salesReturnBillVOtoPO(vo);
		boolean success=salesReBillBlService.updateDraftBill(bill);
		return success;
	}
	
	/**
	 * ͨ��Idɾ��һ�ų����˻����ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean DeleteSalReturnDraft(String Id) {
		boolean success=salesReBillBlService.deleteDraftBill(Id);
		return success;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	protected boolean SubmitSalReturn(String Id) {
		boolean success=salesReBillBlService.submitBill(Id);
		return success;
	}
	
	/**
	 * �ƶ�����ʱ�ṩ��Ʒ�б�
	 * @return ArrayList<GoodsVO>��ArrayList��ÿһ��Ϊһ����Ʒ
	 */
	protected ArrayList<GoodsVO> CommoditySelect() {
		
		ArrayList<GoodsVO> goods=goodsListService.getGoodsList();
		return goods;
	}
	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	protected ArrayList<PurchaseBillVO> getPurchaseDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<PurchaseBillPO> pos=purBillBlService.getDraftBillsListByCreater(user);
		ArrayList<PurchaseBillVO> drafts=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			drafts.add(SalesmanBillsPOVOConvertor.purchaseBillPOtoVO(pos.get(i)));
		}
		return drafts;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	protected ArrayList<PurchaseBillVO> getPurchaseTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<PurchaseBillPO> pos=purBillBlService.getTBDBillsListByCreater(user);
		ArrayList<PurchaseBillVO> list=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			list.add(SalesmanBillsPOVOConvertor.purchaseBillPOtoVO(pos.get(i)));
		}
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	protected ArrayList<PurchaseBillVO> getPurchaseDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<PurchaseBillPO> pos=purBillBlService.getDeniedBillsListByCreater(user);
		ArrayList<PurchaseBillVO> list=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			list.add(SalesmanBillsPOVOConvertor.purchaseBillPOtoVO(pos.get(i)));
		}
		return list;
	}
	
	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<PurchaseReturnBillPO> pos=purReBillBlService.getDraftBillsListByCreater(user);
		ArrayList<PurchaseReturnBillVO> drafts=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			drafts.add(SalesmanBillsPOVOConvertor.purchaseReturnBillPOtoVO(pos.get(i)));
		}
		
		return drafts;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<PurchaseReturnBillPO> pos=purReBillBlService.getTBDBillsListByCreater(user);
		ArrayList<PurchaseReturnBillVO> list=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			list.add(SalesmanBillsPOVOConvertor.purchaseReturnBillPOtoVO(pos.get(i)));
		}
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<PurchaseReturnBillPO> pos=purReBillBlService.getDeniedBillsListByCreater(user);
		ArrayList<PurchaseReturnBillVO> list=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			list.add(SalesmanBillsPOVOConvertor.purchaseReturnBillPOtoVO(pos.get(i)));
		}
		return list;
	}
	
	/**
	 * @see blService.salesBlService.SalesBlService#getSalesDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SalesBillVO> getSalesDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<SalesBillPO> pos=salesBillBlService.getDraftBillsListByCreater(user);
		ArrayList<SalesBillVO> drafts=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			drafts.add(SalesmanBillsPOVOConvertor.salesBillPOtoVO(pos.get(i)));
		}		
		return drafts;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SalesBillVO> getSalesTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<SalesBillPO> pos=salesBillBlService.getTBDBillsListByCreater(user);
		ArrayList<SalesBillVO> list=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			list.add(SalesmanBillsPOVOConvertor.salesBillPOtoVO(pos.get(i)));
		}		
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SalesBillVO> getSalesDeniedBillsListByCreater(UserInfoVO UserInfo){
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<SalesBillPO> pos=salesBillBlService.getDeniedBillsListByCreater(user);
		ArrayList<SalesBillVO> list=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			list.add(SalesmanBillsPOVOConvertor.salesBillPOtoVO(pos.get(i)));
		}		
		return list;
	}
	
	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SalesReturnBillVO> getSalesReturnDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<SalesReturnBillPO> pos=salesReBillBlService.getDeniedBillsListByCreater(user);
		ArrayList<SalesReturnBillVO> list=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			list.add(SalesmanBillsPOVOConvertor.salesReturnBillPOtoVO(pos.get(i)));
		}		
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SalesReturnBillVO> getSalesReturnDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<SalesReturnBillPO> pos=salesReBillBlService.getDraftBillsListByCreater(user);
		ArrayList<SalesReturnBillVO> list=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			list.add(SalesmanBillsPOVOConvertor.salesReturnBillPOtoVO(pos.get(i)));
		}		
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<SalesReturnBillVO> getSalesReturnTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		UserInfoPO user=UserInfoPOVOConvertor.voToPO(UserInfo);
		ArrayList<SalesReturnBillPO> pos=salesReBillBlService.getTBDBillsListByCreater(user);
		ArrayList<SalesReturnBillVO> list=new ArrayList<>();
		for(int i=0;i<pos.size();i++) {
			list.add(SalesmanBillsPOVOConvertor.salesReturnBillPOtoVO(pos.get(i)));
		}		
		return list;
	}
	
}
