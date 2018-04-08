package blImpl.promotionBl;

import java.util.ArrayList;

import assistant.type.CustomerLevelEnum;
import assistant.utility.Date;
import vo.ComboStrategyVO;
import vo.GiftBillVO;
import vo.GiftVO;
import vo.SalesGoodsVO;
import vo.SalesManCommodityVO;

public class ComboStrategy {
	private ComboStrategyVO comboStrategyVO;
	
	public ComboStrategy(ComboStrategyVO vo){
		this.comboStrategyVO = vo;
	}
	
	public ComboStrategyVO getComboStrategyVO(){
		return this.comboStrategyVO;
	}
	

	/**
	 * �����ܵ����ü�ֵ
	 * */
	public double calcTotalValue(double consumption){
		return calcDisCount(consumption);
	}
	
	
	/**
	 * �����ܵ��ۿۼ�ֵ
	 * */
	public double calcDisCount(double consumption){
		double discount = comboStrategyVO.getDiscount();
		return consumption*discount;
	}
	
	/**
	 * �ô��������Ƿ���ʱ�䷶Χ��
	 * @param Date ��ǰʱ��
	 * */
	public boolean isInDateArea(Date date){
		//Date date = new Date();//��ǰʱ��
		Date startDate = comboStrategyVO.getStartDate();
		Date endDate = comboStrategyVO.getEndDate();
		return date.isInDateArea(startDate, endDate);
	}
	
	/**
	 * �Ƿ���ϸô�����������
	 * */
	public boolean isValidCommoditiesCombo(ArrayList<SalesGoodsVO> salesManCommodityVOs){
		ArrayList<GiftVO> gifts = new ArrayList<>();
		for(GiftVO gift: gifts){
			for(SalesGoodsVO commodity: salesManCommodityVOs){
				if(commodity.getGoodsId().equals(gift.getId())
						&&commodity.getNumber()<gift.getGiftAmount()){
					return false;
				}
			}
		}
		return true;
	}

}
