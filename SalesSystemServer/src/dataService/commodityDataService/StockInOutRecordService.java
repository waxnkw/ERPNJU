/**
 * �����������ݲ�����
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package dataService.commodityDataService;

import java.util.ArrayList;

import assistant.utility.Date;
import po.StockInOutPO;

public interface StockInOutRecordService {
	public ArrayList<StockInOutPO> finds(String goodsID);
	//������и���Ʒ�ĳ���������Ϣ����
	public ArrayList<StockInOutPO> finds(Date beginTime,Date endTime);
	//���ĳһʱ��ε����г���������Ϣ����
	public boolean insert(StockInOutPO po);
	//����һ���µĳ���������Ϣ����
	//������Ҫ��Ҫ��ɾ���ķ�������ֹӲ�����������
}
