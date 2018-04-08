package blInteract.promotionBlInteract;

import java.util.ArrayList;

import vo.ComboStrategyVO;
import vo.SalesGoodsVO;
import vo.SalesManCommodityVO;


/**
 * �������Ը�������Ա�ṩ����
 * �����õ�����������Ѳ��Լ��ܵĽ��۶�����
 * �Լ��õ��ܵĽ��۶��:��Ʒ�ܼ�+���۶��+���ʹ���ȯ����
 * @author zhangao
 * @version 2018.1.3
 * */
public interface ComboStrategyForSalesManService {
	/**
	 * �õ���ǰ��õĴ�������
	 * �ܵĽ��۶��:��Ʒ�ܼ�+���۶��+���ʹ���ȯ����,���
	 * @param salesGoods ��������Ʒ�б�
	 * @param consumption ��������Ʒδ����ǰ���ܼ�
	 * */
	public ComboStrategyVO getBestStrategy(ArrayList<SalesGoodsVO> salesManCommodityVOs,double consumption);
}
