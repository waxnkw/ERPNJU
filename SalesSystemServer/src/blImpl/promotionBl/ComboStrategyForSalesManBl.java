package blImpl.promotionBl;

import java.util.ArrayList;

import blInteract.promotionBlInteract.ComboStrategyForSalesManService;
import vo.ComboStrategyVO;
import vo.SalesGoodsVO;
import vo.SalesManCommodityVO;

public class ComboStrategyForSalesManBl implements ComboStrategyForSalesManService{

	/**
	 * �õ���ǰ��õĴ�������
	 * �ܵĽ��۶��:��Ʒ�ܼ�+���۶��+���ʹ���ȯ����,���
	 * @param salesGoods ��������Ʒ�б�
	 * @param consumption ��������Ʒδ����ǰ���ܼ�
	 * */
	@Override
	public ComboStrategyVO getBestStrategy(ArrayList<SalesGoodsVO> salesManCommodityVOs, double consumption) {
		ComboStrategyList comboStrategyList = new ComboStrategyList();
		return comboStrategyList.calcBestComboStrategy(salesManCommodityVOs, consumption);
	}

}
