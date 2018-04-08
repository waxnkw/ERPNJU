package ui.salesUi.salesBl;

import vo.ComboStrategyVO;

public class ComboStrategy {
	private ComboStrategyVO comboStrategyVO;
	
	public ComboStrategy(ComboStrategyVO vo){
		this.comboStrategyVO = vo;
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
}
