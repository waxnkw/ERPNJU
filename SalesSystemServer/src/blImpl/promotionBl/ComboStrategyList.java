package blImpl.promotionBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.utility.Date;
import vo.ComboStrategyVO;
import vo.SalesGoodsVO;
import vo.SalesManCommodityVO;

public class ComboStrategyList {
	private ArrayList<ComboStrategy> comboStrategies;

	public ComboStrategyList(){
		comboStrategies = new ArrayList<ComboStrategy>();
		PromotionBl bl = new PromotionBl();
		ArrayList<ComboStrategyVO> comboStrategyVOs = null; 
		try {
			comboStrategyVOs = bl.getComoboStrategyList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(ComboStrategyVO vo:comboStrategyVOs){
			comboStrategies.add(new ComboStrategy(vo));
		}
	}
	
	public ComboStrategyVO calcBestComboStrategy(ArrayList<SalesGoodsVO> salesManCommodityVOs,double consumption){
		double price = 0;
		ComboStrategy bestUserStrategy = null;//���ŵ��û�������·
		Date nowDate = new Date();//��������
		for(ComboStrategy strategy : comboStrategies){
			//���ϴ�����������
			if(strategy.isInDateArea(nowDate)&&strategy.isValidCommoditiesCombo(salesManCommodityVOs)){
				double value = strategy.calcTotalValue(consumption); 
				if(price<value){
					bestUserStrategy = strategy;
					price = value;
				}
			}
		}
		return bestUserStrategy.getComboStrategyVO();
	}
}
