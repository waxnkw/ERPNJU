/**
 * ��Ʒ���ݲ�����
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package dataService.commodityDataService;

import java.util.ArrayList;

import po.GoodsPO;

public interface GoodsDataService {
	public ArrayList<GoodsPO> finds();
	//���������Ʒ����
	public GoodsPO find(String goodsName,String goodsType);
	//�������Ƽ��ͺŻ��ĳһ��Ʒ����
	public GoodsPO find(String goodsTag);
	//����ID���ĳһ��Ʒ����
	public boolean insert(GoodsPO po);
	//����һ��Ʒ����
	public boolean delete(GoodsPO po);
	//ɾ��һ��Ʒ����
	public boolean update(GoodsPO po);
    //������Ʒ���󣬸��¸���Ʒ��Ϣ
}
