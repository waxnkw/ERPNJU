package blStubs.promotionBlStubs;

import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.StrategyCategoryEnum;
import blService.promotionBlService.PromotionBlService;
import vo.*;

public class PromotionBlService_Stub implements PromotionBlService {

	@SuppressWarnings("null")
	@Override
	public ArrayList<UserStrategyVO> getUserStrategyList() {
		ArrayList<UserStrategyVO> strategyVos = null;
		strategyVos.add(new UserStrategyVO());
		strategyVos.add(new UserStrategyVO());
		strategyVos.add(new UserStrategyVO());
		return strategyVos;
	}

	@Override
	public ArrayList<TotalStrategyVO> getTotalStrategyList() {
		
		return null;
	}

	@Override
	public ArrayList<ComboStrategyVO> getComoboStrategyList() {
		
		return null;
	}

	@Override
	public boolean deleteStrategy(StrategyCategoryEnum strategyType, String strategyId) {
		
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
	public boolean updateStrategy(StrategyCategoryEnum strategyType, String strategyId,
			PromotionStrategyVO newPromotionStrategyVO) throws RemoteException {
		
		return true;
	}

	@Override
	public GoodsVO goodsINfor(String goodsTag) throws RemoteException {
	
		return null;
	}

}
