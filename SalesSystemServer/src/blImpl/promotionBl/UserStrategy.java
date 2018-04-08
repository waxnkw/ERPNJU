package blImpl.promotionBl;

import java.util.ArrayList;

import assistant.convertors.UserStrategyPOVOConvertor;
import assistant.type.BillCategoryEnum;
import assistant.type.CustomerLevelEnum;
import assistant.utility.Date;
import po.UserStrategyPO;
import vo.GiftBillVO;
import vo.GiftVO;
import vo.UserStrategyVO;


/**
 * �û��������Ե��߼�����
 * */
public class UserStrategy {
	private UserStrategyVO userStrategyVO;
	
	/**
	 * ��voΪ�����Ĺ��췽��
	 * @param vo���췽������
	 * */
	public UserStrategy(UserStrategyVO vo){
		userStrategyVO = vo;
	}
	
	/**
	 * ��poΪ�����Ĺ��췽��
	 * @param po���췽������
	 * */
	public UserStrategy(UserStrategyPO po){
		userStrategyVO = UserStrategyPOVOConvertor.poToVO(po);
	}
	
	/**
	 * �û��������ԵĹ��췽��
	 * */
	public UserStrategyVO getUserStrategyVO() {
		return userStrategyVO;
	}
	
	/**
	 * �����ܵ����ü�ֵ
	 * */
	public double calcTotalValue(double consumption){
		return calcDisCount(consumption)+ calcGiftValue()+calcCoupon();
	}
	
	/**
	 * �������ȯ��ֵ
	 * */
	public double calcCoupon(){
		return getUserStrategyVO().getCoupon();
	}
	
	/**
	 * �����ܵ���Ʒ�ļ�ֵ
	 * */
	public double calcGiftValue(){
		double price = 0;
		ArrayList<GiftVO> gifts = getUserStrategyVO().getGifts();
		for(GiftVO gift :gifts){
			price += gift.getPrice()*gift.getGiftAmount();
		}
		return price;
	}
	
	/**
	 * �����ܵ��ۿۼ�ֵ
	 * */
	public double calcDisCount(double consumption){
		double discount = getUserStrategyVO().getDiscount();
		return consumption*discount;
	}
	
	/**
	 * �ô��������Ƿ���ʱ�䷶Χ��
	 * @param Date ��ǰʱ��
	 * */
	public boolean isInDateArea(Date date){
		//Date date = new Date();//��ǰʱ��
		Date startDate = getUserStrategyVO().getStartDate();
		Date endDate = getUserStrategyVO().getEndDate();
		return date.isInDateArea(startDate, endDate);
	}
	
	/**
	 * �Ƿ���ϸô�����������
	 * */
	public boolean isValidCustomerLevel(CustomerLevelEnum customerLevel){
		CustomerLevelEnum targetCustomerLevel = getUserStrategyVO().getCustomerLevel();
		return customerLevel.isBiggerThanLevel(targetCustomerLevel);
	}

	/**
	 * ������Ʒ���ɿ�����͵�
	 * */
	public GiftBillVO generateGiftBill(){
		GiftBillVO giftBillVO = new GiftBillVO();
		giftBillVO.setCategoryEnum(BillCategoryEnum.GIFT_BILL);
		giftBillVO.setCreater(null);
		giftBillVO.setCreateDate(new Date());
		
		ArrayList<GiftVO> gifts = userStrategyVO.getGifts();
		giftBillVO.setGifts(gifts);
		return giftBillVO;
	}
}
