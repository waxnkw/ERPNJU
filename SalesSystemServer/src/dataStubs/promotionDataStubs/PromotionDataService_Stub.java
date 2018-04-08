package dataStubs.promotionDataStubs;

import java.util.ArrayList;

import assistant.type.CustomerLevel;
import assistant.utility.Date;

import dataService.promotionDataService.PromotionDataService;
import vo.*;

public class PromotionDataService_Stub implements PromotionDataService {

	@Override
	public ArrayList<UserStrategyVO> getUserStrategyList() {
		
		ArrayList<UserStrategyVO> userStrategyVos = null;
		userStrategyVos.add(new UserStrategyVO(1,null,null,"stub1",CustomerLevel.VIP1,1.0,100,null));
		userStrategyVos.add(new UserStrategyVO(2,null,null,"stub2",CustomerLevel.VIP1,1.0,100,null));
		userStrategyVos.add(new UserStrategyVO(3,null,null,"stub3",CustomerLevel.VIP1,1.0,100,null));
		userStrategyVos.add(new UserStrategyVO(4,null,null,"stub4",CustomerLevel.VIP1,1.0,100,null));
		return userStrategyVos;
	}

	@Override
	public ArrayList<TotalStrategyVO> getTotalStrategyList() {
		 
		ArrayList<TotalStrategyVO> totalStrategyVos = null;
		totalStrategyVos.add(new TotalStrategyVO(1,null,null,"stub1",100,1.0,100,null));
		totalStrategyVos.add(new TotalStrategyVO(2,null,null,"stub2",100,1.0,100,null));
		totalStrategyVos.add(new TotalStrategyVO(3,null,null,"stub3",100,1.0,100,null));
		totalStrategyVos.add(new TotalStrategyVO(4,null,null,"stub4",100,1.0,100,null));
		return totalStrategyVos;
	}

	@Override
	public ArrayList<ComboStrategyVO> getComoboStrategyList() {

		ArrayList<ComboStrategyVO> comboStrategyVos = null;
		comboStrategyVos.add(new ComboStrategyVO(1,null,null,"stub1","combo1",1.0,null));
		comboStrategyVos.add(new ComboStrategyVO(2,null,null,"stub2","combo2",1.0,null));
		comboStrategyVos.add(new ComboStrategyVO(3,null,null,"stub3","combo3",1.0,null));
		comboStrategyVos.add(new ComboStrategyVO(4,null,null,"stub4","combo4",1.0,null));
		return comboStrategyVos;
	}

	@Override
	public boolean deleteStrategy(String strategyType, String strategyId) {
		
		return true;
	}

	@Override
	public boolean addUserStrategy(UserStrategyVO strategy) {
		
		return true;
	}

	@Override
	public boolean addTotalStrategy(TotalStrategyVO strategy) {
		
		return true;
	}

	@Override
	public boolean addComoboStrategy(ComboStrategyVO strategy) {
		
		return true;
	}

	@Override
	public boolean updateStrategy(String strategyType, String strategyId, PromotionStrategyVO newPromotionStrategyVO) {
		// TODO Auto-generated method stub
		return false;
	}

}
