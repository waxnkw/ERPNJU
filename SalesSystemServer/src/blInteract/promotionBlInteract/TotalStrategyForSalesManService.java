package blInteract.promotionBlInteract;

import vo.GiftBillVO;
import vo.TotalStrategyVO;

/**
 * �������Ը�������Ա�ṩ����
 * �����õ�����������Ѳ��Լ��ܵĽ��۶�����
 * �Լ��õ��ܵĽ��۶��:��Ʒ�ܼ�+���۶��+���ʹ���ȯ����
 * @author zhangao
 * @version 2018.1.3
 * */
public interface TotalStrategyForSalesManService {
	/**
	 * �õ���ǰ��õĴ�������
	 * �ܵĽ��۶��:��Ʒ�ܼ�+���۶��+���ʹ���ȯ����,���
	 * @param customerLevel �û��ĵȼ�
	 * @param consumption�û��������Ѷ�
	 * @return ������������õ��ܼ۴�������
	 * */
	public TotalStrategyVO getBestStrategy(double consumption);
	
	/**
	 * ����ĳһ����������������Ӧ�Ŀ�����͵�
	 * @param TotalStrategy vo ��Ҫ���ɿ�����͵����ܼ۴�������
	 * @return ���ɵĿ�����͵�
	 * */
	public GiftBillVO generateGiftBillByTotalStrategy(TotalStrategyVO vo);
}
