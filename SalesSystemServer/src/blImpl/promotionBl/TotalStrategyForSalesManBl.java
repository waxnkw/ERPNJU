package blImpl.promotionBl;

import assistant.convertors.GiftBillPOVOConvertor;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.GiftBillBlService;
import blInteract.promotionBlInteract.TotalStrategyForSalesManService;
import po.GiftBillPO;
import vo.GiftBillVO;
import vo.TotalStrategyVO;

public class TotalStrategyForSalesManBl implements TotalStrategyForSalesManService{
	/**
	 * �õ���ǰ��õĴ�������
	 * �ܵĽ��۶��:��Ʒ�ܼ�+���۶��+���ʹ���ȯ����,���
	 * @param customerLevel �û��ĵȼ�
	 * @param consumption�û��������Ѷ�
	 * @return ������������õ��ܼ۴�������
	 * */
	@Override
	public TotalStrategyVO getBestStrategy(double consumption) {
		TotalStrategyList totalStrategyList = new TotalStrategyList();
		return totalStrategyList.calcBestTotalStrategy(consumption);
	}

	
	/**
	 * ����ĳһ����������������Ӧ�Ŀ�����͵�
	 * @param TotalStrategy vo ��Ҫ���ɿ�����͵����ܼ۴�������
	 * @return ���ɵĿ�����͵�
	 * */
	@Override
	public GiftBillVO generateGiftBillByTotalStrategy(TotalStrategyVO vo) {
		TotalStrategy totalStrategy = new TotalStrategy(vo);
		GiftBillVO giftBillVO = totalStrategy.generateGiftBill();
		
		//���ô��������ύ����
		GiftBillBlService service = new BillBlInteractServiceFactory().getGiftBillBlService();
		GiftBillPO po = GiftBillPOVOConvertor.giftBillVOtoPO(giftBillVO);
		service.createBill(po);
		
		return giftBillVO;
	}

}
