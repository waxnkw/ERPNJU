package ui.salesUi.salesBl;

import java.util.ArrayList;

import vo.GiftVO;
import vo.UserStrategyVO;

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
	 * �����ܵ����ü�ֵ
	 * */
	public double calcTotalValue(double consumption){
		return calcDisCount(consumption)+ calcGiftValue()+calcCoupon();
	}
	
	/**
	 * �������ȯ��ֵ
	 * */
	public double calcCoupon(){
		return userStrategyVO.getCoupon();
	}
	
	/**
	 * �����ܵ���Ʒ�ļ�ֵ
	 * */
	private double calcGiftValue(){
		double price = 0;
		ArrayList<GiftVO> gifts = userStrategyVO.getGifts();
		for(GiftVO gift :gifts){
			price += gift.getPrice()*gift.getGiftAmount();
		}
		return price;
	}
	
	/**
	 * �����ܵ��ۿۼ�ֵ
	 * */
	private double calcDisCount(double consumption){
		double discount = userStrategyVO.getDiscount();
		return consumption*discount;
	}
}
