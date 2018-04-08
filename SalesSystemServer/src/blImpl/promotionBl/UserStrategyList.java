package blImpl.promotionBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.CustomerLevelEnum;
import assistant.utility.Date;
import vo.UserStrategyVO;

public class UserStrategyList {
	ArrayList<UserStrategy> userStrategys;
	
	/**
	 * ���췽��,ά�������û��������Եļ���
	 * */
	public UserStrategyList() {
		userStrategys = new ArrayList<UserStrategy>();
		
		PromotionBl bl = new PromotionBl();
		ArrayList<UserStrategyVO> userStrategyVOs = null; 
		try {
			userStrategyVOs = bl.getUserStrategyList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(UserStrategyVO vo:userStrategyVOs){
			userStrategys.add(new UserStrategy(vo));
		}
	}
	
	
	/**
	 * �������õ��û���������
	 * @param customerLevel �����û��ĵȼ�
	 * @param consumption δ����ǰ����Ʒ�ܼ�
	 * */
	public UserStrategyVO calcBestUserStrategy(CustomerLevelEnum customerLevel,double consumption){
		double price = 0;
		UserStrategy bestUserStrategy = null;//���ŵ��û�������·
		Date nowDate = new Date();//��������
		for(UserStrategy strategy : userStrategys){
			//���ϴ�����������
			if(strategy.isInDateArea(nowDate)&&strategy.isValidCustomerLevel(customerLevel)){
				double value = strategy.calcTotalValue(consumption); 
				if(price<value){
					bestUserStrategy = strategy;
					price = value;
				}
			}
		}
		return bestUserStrategy.getUserStrategyVO();
	}
	
}
