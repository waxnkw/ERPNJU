package blImpl.salesBl;
import java.rmi.RemoteException;
import java.util.ArrayList;

import blService.salesBlService.SalesBlService;
import vo.UserInfoVO;
import vo.GoodsVO;
import vo.PurchaseBillVO;
import vo.PurchaseReturnBillVO;
import vo.SalesBillVO;
import vo.SalesReturnBillVO;

/**
 * 进货销售人员制定单据的业务逻辑控制器
 * @author 王宁一
 * @version 2017.11.7
 *
 */

public class SalesBlController implements SalesBlService {

	private SalesBl Impl=new SalesBl();
	/**
	 * 新建一张供应商进货单
	 * @param PurchaseBillVO
	 * @return 返回一个布尔值表示是否操作成功，如果成功则返回True
	 */
	@Override
	public boolean NewPurchase(PurchaseBillVO vo) {
		// TODO Auto-generated method stub
		boolean success=Impl.NewPurchase(vo);
		return success;
	}

	/**
	 * 新建一张供应商进货单草稿
	 * @param PurchaseBillVO
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean NewPurchaseDraft(PurchaseBillVO vo) {
		boolean success=Impl.NewPurchaseDraft(vo);
		return success;
	}
	
	/**
	 * 对已经存在草稿进行内容更新
	 * @param PurchaseBillVO
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean UpdatePurchaseDraft(PurchaseBillVO vo) {
		boolean success=Impl.UpdatePurchaseDraft(vo);
		return success;
	}
	
	/**
	 * 通过Id删除一张进货单草稿
	 * @param String
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean DeletePurchaseDraft(String Id) {
		boolean success=Impl.DeletePurchaseDraft(Id);
		return success;
	}
	
	/**
	 * 将草稿提交为正式单据
	 * @param String
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean SubmitPurchase(String Id) {
		boolean success=Impl.SubmitPurchase(Id);
		return success;
	}
	
	/**
	 * 新建一张供应商进货退货单
	 * @param PurchaseReturnBillVO
	 * @return 返回一个布尔值表示是否操作成功，如果成功则返回True
	 */
	@Override
	public boolean NewPurReturn(PurchaseReturnBillVO vo) {
		boolean success=Impl.NewPurReturn(vo);
		return success;
	}
	
	/**
	 * 新建一张供应商进货退货单草稿
	 * @param PurchaseReturnBillVO
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean NewPurReturnDraft(PurchaseReturnBillVO vo) {
		boolean success=Impl.NewPurReturnDraft(vo);
		return success;
	}
	
	/**
	 * 更新一张供应商进货退货单草稿
	 * @param PurchaseReturnBillVO
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean UpdatePurReturnDraft(PurchaseReturnBillVO vo) {
		boolean success=Impl.UpdatePurReturnDraft(vo);
		return success;
	}

	/**
	 * 通过Id删除一张进货退货单草稿
	 * @param String
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean DeletePurReturnDraft(String Id) {
		boolean success=Impl.DeletePurReturnDraft(Id);
		return success;
	}
	
	/**
	 * 将草稿提交为正式单据
	 * @param String
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean SubmitPurReturn(String Id) {
		boolean success=Impl.SubmitPurReturn(Id);
		return success;
	}
	
	/**
	 * 新建一张销售商出货单
	 * @param SalesBillVO
	 * @return 返回一个布尔值表示是否操作成功，如果成功则返回True
	 */
	@Override
	public boolean NewSales(SalesBillVO vo) {
		boolean success=Impl.NewSales(vo);
		return success;
	}

	/**
	 * 新建一张销售商出货单草稿
	 * @param SalesBillVO
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean NewSalesDraft(SalesBillVO vo) {
		boolean success=Impl.NewSalesDraft(vo);
		return success;
	}
	
	/**
	 * 更新一张销售商出货单草稿
	 * @param SalesBillVO
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean UpdateSalesDraft(SalesBillVO vo) {
		boolean success=Impl.UpdateSalesDraft(vo);
		return success;
	}
	
	/**
	 * 通过Id删除一张出货单草稿
	 * @param String
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean DeleteSalesDraft(String Id) {
		boolean success=Impl.DeleteSalesDraft(Id);
		return success;
	}
	
	/**
	 * 将草稿提交为正式单据
	 * @param String
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean SubmitSales(String Id) {
		boolean success=Impl.SubmitSales(Id);
		return success;
	}
	
	/**
	 * 新建一张销售商出货退货单
	 * @param SalesReturnBillVO
	 * @return 返回一个布尔值表示是否操作成功，如果成功则返回True
	 */
	@Override
	public boolean NewSalReturn(SalesReturnBillVO vo) {
		boolean success=Impl.NewSalReturn(vo);
		return success;
	}

	/**
	 * 新建一张销售商出货退货单草稿
	 * @param SalesReturnBillVO
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean NewSalReturnDraft(SalesReturnBillVO vo) {
		boolean success=Impl.NewSalReturnDraft(vo);
		return success;
	}
	
	/**
	 * 更新一张销售商出货退货单草稿
	 * @param SalesReturnBillVO
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean UpdateSalReturnDraft(SalesReturnBillVO vo) {
		boolean success=Impl.UpdateSalReturnDraft(vo);
		return success;
	}
	
	/**
	 * 通过Id删除一张出货退货单草稿
	 * @param String
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean DeleteSalReturnDraft(String Id) {
		boolean success=Impl.DeleteSalReturnDraft(Id);
		return success;
	}
	
	/**
	 * 将草稿提交为正式单据
	 * @param String
	 * @return boolean, true表示操作成功
	 */
	@Override
	public boolean SubmitSalReturn(String Id) {
		boolean success=Impl.SubmitSalReturn(Id);
		return success;
	}
	
	/**
	 * 制定单据时提供商品列表
	 * @return ArrayList<GoodsVO>，ArrayList中每一项为一种商品
	 */
	@Override
	public ArrayList<GoodsVO> CommoditySelect() {
		ArrayList<GoodsVO> result=new ArrayList<>();
		result=Impl.CommoditySelect();
		return result;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseBillVO> list=Impl.getPurchaseDraftBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseBillVO> list=Impl.getPurchaseTBDBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseBillVO> getPurchaseDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseBillVO> list=Impl.getPurchaseDeniedBillsListByCreater(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseReturnBillVO> list=Impl.getPurchaseReturnDraftBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseReturnBillVO> list=Impl.getPurchaseReturnTBDBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getPurchaseReturnDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<PurchaseReturnBillVO> getPurchaseReturnDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<PurchaseReturnBillVO> list=Impl.getPurchaseReturnDeniedBillsListByCreater(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesBillVO> getSalesDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesBillVO> list=Impl.getSalesDraftBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesBillVO> getSalesTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesBillVO> list=Impl.getSalesTBDBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesBillVO> getSalesDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesBillVO> list=Impl.getSalesDeniedBillsListByCreater(UserInfo);
		return list;
	}
	
	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnDeniedBillsListByCreater(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnDeniedBillsListByCreater(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesReturnBillVO> list=Impl.getSalesReturnDeniedBillsListByCreater(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnDraftBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnDraftBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesReturnBillVO> list=Impl.getSalesReturnDraftBillsList(UserInfo);
		return list;
	}

	/**
	 * @see blService.salesBlService.SalesBlService#getSalesReturnTBDBillsList(po.UserInfoVO)
	 * @param UserInfo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<SalesReturnBillVO> getSalesReturnTBDBillsList(UserInfoVO UserInfo) {
		// TODO Auto-generated method stub
		ArrayList<SalesReturnBillVO> list=Impl.getSalesReturnTBDBillsList(UserInfo);
		return list;
	}

	
}
