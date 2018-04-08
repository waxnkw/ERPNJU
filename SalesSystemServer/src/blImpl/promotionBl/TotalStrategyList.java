package blImpl.promotionBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.CustomerLevelEnum;
import assistant.utility.Date;
import vo.TotalStrategyVO;
import vo.UserStrategyVO;

public class TotalStrategyList {
	private ArrayList<TotalStrategy> totalStrategies;
	
	/**
	 * ���췽��,ά�������û��������Եļ���
	 * */
	public TotalStrategyList(){
		totalStrategies = new ArrayList<>();
		
		PromotionBl bl = new PromotionBl();
		ArrayList<TotalStrategyVO> totalStrategyVOs = null; 
		try {
			totalStrategyVOs = bl.getTotalStrategyList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(TotalStrategyVO vo:totalStrategyVOs){
			totalStrategies.add(new TotalStrategy(vo));
		}
	}

	/**
	 * �������õ��û���������
	 * @param consumption δ����ǰ����Ʒ�ܼ�
	 * */
	public TotalStrategyVO calcBestTotalStrategy(double consumption){
		double price = 0;
		TotalStrategy bestTotalStrategy = null;//���ŵ��û�������·
		Date nowDate = new Date();//��������
		for(TotalStrategy strategy : totalStrategies){
			//���ϴ�����������
			if(strategy.isInDateArea(nowDate)&&strategy.isValidConsumption(consumption)){
				double value = strategy.calcTotalValue(consumption); 
				if(price<value){
					bestTotalStrategy = strategy;
					price = value;
				}
			}
		}
		return bestTotalStrategy.geTotalStrategyVO();
	}
	
}
