package blImpl.promotionBl;

import java.util.ArrayList;

import assistant.type.BillCategoryEnum;
import assistant.type.CustomerLevelEnum;
import assistant.utility.Date;
import vo.GiftBillVO;
import vo.GiftVO;
import vo.TotalStrategyVO;

/**
 * �ܼ۴������Ե��߼�����
 * */
public class TotalStrategy {
	private TotalStrategyVO totalStrategyVO;
	
	/**
	 * ��voΪ�����Ĺ��췽��
	 * @param vo���췽������
	 * */
	public TotalStrategy(TotalStrategyVO vo){
		totalStrategyVO = vo;
	}
	
	public TotalStrategyVO geTotalStrategyVO(){
		return this.totalStrategyVO;
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
	private double calcCoupon(){
		return totalStrategyVO.getCoupon();
	}
	
	/**
	 * �����ܵ���Ʒ�ļ�ֵ
	 * */
	private double calcGiftValue(){
		double price = 0;
		ArrayList<GiftVO> gifts = totalStrategyVO.getGifts();
		for(GiftVO gift :gifts){
			price += gift.getPrice()*gift.getGiftAmount();
		}
		return price;
	}
	
	/**
	 * �����ܵ��ۿۼ�ֵ
	 * */
	private double calcDisCount(double consumption){
		double discount = totalStrategyVO.getDiscount();
		return consumption*discount;
	}
	
	/**
	 * �ô��������Ƿ���ʱ�䷶Χ��
	 * @param Date ��ǰʱ��
	 * */
	public boolean isInDateArea(Date date){
		//Date date = new Date();//��ǰʱ��
		Date startDate = totalStrategyVO.getStartDate();
		Date endDate = totalStrategyVO.getEndDate();
		return date.isInDateArea(startDate, endDate);
	}
	
	/**
	 * �Ƿ���ϸô�����������
	 * */
	public boolean isValidConsumption(double consumption){
		return consumption>totalStrategyVO.getTotalConsumption();
	}

	/**
	 * ������Ʒ���ɿ�����͵�
	 * */
	public GiftBillVO generateGiftBill(){
		GiftBillVO giftBillVO = new GiftBillVO();
		giftBillVO.setCategoryEnum(BillCategoryEnum.GIFT_BILL);
		giftBillVO.setCreater(null);
		giftBillVO.setCreateDate(new Date());
		
		ArrayList<GiftVO> gifts = totalStrategyVO.getGifts();
		giftBillVO.setGifts(gifts);
		return giftBillVO;
	}
	
}
