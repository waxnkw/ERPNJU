package blImpl.promotionBl;

import java.util.ArrayList;

import assistant.convertors.GiftBillPOVOConvertor;
import assistant.type.BillCategoryEnum;
import assistant.type.CustomerLevelEnum;
import assistant.utility.Date;
import blInteract.billBlInteract.BillBlInteractServiceFactory;
import blInteract.billBlInteract.GiftBillBlService;
import blInteract.promotionBlInteract.UserStrategyForSalesManService;
import po.GiftBillPO;
import vo.GiftBillVO;
import vo.GiftVO;
import vo.UserStrategyVO;

public class UserStrategyForSalesManBl implements UserStrategyForSalesManService{

	/**
	 * �õ���ǰ��õĴ�������
	 * �ܵĽ��۶��:��Ʒ�ܼ�+���۶��+���ʹ���ȯ����,���
	 * */
	@Override
	public UserStrategyVO getBestStrategy(CustomerLevelEnum customerLevel,double consumption) {
		UserStrategyList userStrategyList = new UserStrategyList();
		return userStrategyList.calcBestUserStrategy(customerLevel, consumption);
	}

	/**
	 * ����ĳһ����������������Ӧ�Ŀ�����͵�
	 * �����õ����ύ����
	 * @param UserStrategy vo ��Ҫ���ɿ�����͵����ܼ۴�������
	 * @return ���ɵĿ�����͵�
	 * */
	@Override
	public GiftBillVO generateGiftBillByTotalStrategy(UserStrategyVO vo) {
		UserStrategy userStrategy = new UserStrategy(vo);
		GiftBillVO giftBillVO = userStrategy.generateGiftBill();
		
		//���ô��������ύ����
		GiftBillBlService service = new BillBlInteractServiceFactory().getGiftBillBlService();
		GiftBillPO po = GiftBillPOVOConvertor.giftBillVOtoPO(giftBillVO);
		service.createBill(po);
		
		return giftBillVO;
	}

}
