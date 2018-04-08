package blStubs.salesBlStubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blService.salesBlService.SalesBlService;
import vo.*;


public class SalesBlService_Stub implements SalesBlService {

	/**
	 * �½�һ�Ź�Ӧ�̽�����
	 * @param PurchaseBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean NewPurchase(PurchaseBillVO vo) {
		return false;
		// TODO Auto-generated method stub
	}

	/**
	 * �½�һ�Ź�Ӧ�̽������ݸ�
	 * @param PurchaseBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean NewPurchaseDraft(PurchaseBillVO vo) {
		return false;
	}
	
	/**
	 * ���Ѿ����ڲݸ�������ݸ���
	 * @param PurchaseBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean UpdatePurchaseDraft(PurchaseBillVO vo) {
		return false;
	}
	
	/**
	 * ͨ��Idɾ��һ�Ž������ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean DeletePurchaseDraft(String Id) {
		return true;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean SubmitPurchase(String Id) {
		return false;
	}
	
	/**
	 * �½�һ�Ź�Ӧ�̽����˻���
	 * @param PurchaseReturnBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean NewPurReturn(PurchaseReturnBillVO vo) {
		return false;
	}
	
	/**
	 * �½�һ�Ź�Ӧ�̽����˻����ݸ�
	 * @param PurchaseReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean NewPurReturnDraft(PurchaseReturnBillVO vo) {
		return false;
	}
	
	/**
	 * ����һ�Ź�Ӧ�̽����˻����ݸ�
	 * @param PurchaseReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean UpdatePurReturnDraft(PurchaseReturnBillVO vo) {
		return false;
	}

	/**
	 * ͨ��Idɾ��һ�Ž����˻����ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean DeletePurReturnDraft(String Id) {
		return true;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean SubmitPurReturn(String Id) {
		return false;
	}
	
	/**
	 * �½�һ�������̳�����
	 * @param SalesBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean NewSales(SalesBillVO vo) {
		return false;
	}

	/**
	 * �½�һ�������̳������ݸ�
	 * @param SalesBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean NewSalesDraft(SalesBillVO vo) {
		return false;
	}
	
	/**
	 * ����һ�������̳������ݸ�
	 * @param SalesBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean UpdateSalesDraft(SalesBillVO vo) {
		return false;
	}
	
	/**
	 * ͨ��Idɾ��һ�ų������ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean DeleteSalesDraft(String Id) {
		return true;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean SubmitSales(String Id) {
		return false;
	}
	
	/**
	 * �½�һ�������̳����˻���
	 * @param SalesReturnBillVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean NewSalReturn(SalesReturnBillVO vo) {
		return false;
	}

	/**
	 * �½�һ�������̳����˻����ݸ�
	 * @param SalesReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean NewSalReturnDraft(SalesReturnBillVO vo) {
		return false;
	}
	
	/**
	 * ����һ�������̳����˻����ݸ�
	 * @param SalesReturnBillVO
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean UpdateSalReturnDraft(SalesReturnBillVO vo) {
		return false;
	}
	
	/**
	 * ͨ��Idɾ��һ�ų����˻����ݸ�
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean DeleteSalReturnDraft(String Id) {
		return true;
	}
	
	/**
	 * ���ݸ��ύΪ��ʽ����
	 * @param String
	 * @return boolean, true��ʾ�����ɹ�
	 */
	@Override
	public boolean SubmitSalReturn(String Id) {
		return false;
	}
	
	/**
	 * �ƶ�����ʱ�ṩ��Ʒ�б�
	 * @return ArrayList<GoodsVO>��ArrayList��ÿһ��Ϊһ����Ʒ
	 */
	@Override
	public ArrayList<GoodsVO> CommoditySelect() {
		ArrayList<GoodsVO> goods=new ArrayList<>();
		for(int i=0;i<5;i++) {
			GoodsVO vo=new GoodsVO();
			vo.setName("Commodity"+i);
			vo.setNumber("0000"+i);
			vo.setType("TypeA");
			vo.setCostPrice(""+100*i);
			vo.setSellingPrice(""+200*i);
			goods.add(vo);
		}
		return goods;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseDraftBillsList(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseDraftBillsList(UserInfoVO UserInfo) throws RemoteException {
		// TODO Auto-generated method stub
		PurchaseBillVO vo=new PurchaseBillVO();
		ArrayList<PurchaseBillVO> test=new ArrayList<>();
		test.add(vo);
		return test;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseTBDBillsList(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseTBDBillsList(UserInfoVO UserInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseDeniedBillsListByCreater(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseDeniedBillsListByCreater(UserInfoVO UserInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnDraftBillsList(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnDraftBillsList(UserInfoVO UserInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnTBDBillsList(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnTBDBillsList(UserInfoVO UserInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnDeniedBillsListByCreater(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnDeniedBillsListByCreater(UserInfoVO UserInfo)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesDraftBillsList(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesBillVO> getSalesDraftBillsList(UserInfoVO UserInfo) throws RemoteException {
		// TODO Auto-generated method stub
		SalesBillVO draft=new SalesBillVO();
		ArrayList<SalesBillVO> drafts=new ArrayList<>();
		drafts.add(draft);
		return drafts;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesTBDBillsList(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesBillVO> getSalesTBDBillsList(UserInfoVO UserInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnDeniedBillsListByCreater(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnDeniedBillsListByCreater(UserInfoVO UserInfo)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnDraftBillsList(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnDraftBillsList(UserInfoVO UserInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnTBDBillsList(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnTBDBillsList(UserInfoVO UserInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesDeniedBillsListByCreater(vo.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesBillVO> getSalesDeniedBillsListByCreater(UserInfoVO UserInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
