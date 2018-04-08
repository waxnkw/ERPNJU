package blInteract.promotionBlInteract;

import assistant.type.CustomerLevelEnum;
import vo.GiftBillVO;
import vo.TotalStrategyVO;
import vo.UserStrategyVO;

public interface UserStrategyForSalesManService {
	/**
	 * �õ���ǰ��õĴ�������
	 * �ܵĽ��۶��:��Ʒ�ܼ�+���۶��+���ʹ���ȯ����,���
	 * @param customerLevel �û��ĵȼ�
	 * @param consumption�û��������Ѷ�
	 * @return ������������õ��û���������
	 * */
	public UserStrategyVO getBestStrategy(CustomerLevelEnum customerLevel,double consumption);
	
	/**
	 * ����ĳһ����������������Ӧ�Ŀ�����͵�
	 * �����õ����ύ����
	 * @param UserStrategy vo ��Ҫ���ɿ�����͵����ܼ۴�������
	 * @return ���ɵĿ�����͵�
	 * */
	public GiftBillVO generateGiftBillByTotalStrategy(UserStrategyVO vo);
}
