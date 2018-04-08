package ui.salesUi.salesBl;

import java.util.ArrayList;

import vo.GiftVO;
import vo.TotalStrategyVO;

public class TotalStrategy {
	private TotalStrategyVO totalStrategyVO;
	
	/**
	 * ��voΪ�����Ĺ��췽��
	 * @param vo���췽������
	 * */
	public TotalStrategy(TotalStrategyVO vo){
		totalStrategyVO = vo;
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
}
