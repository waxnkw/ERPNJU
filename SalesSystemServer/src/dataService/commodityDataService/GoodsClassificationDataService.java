/**
 * ��Ʒ������ݲ�����
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package dataService.commodityDataService;

import java.util.ArrayList;

import po.ClassificationPO;


public interface GoodsClassificationDataService {
	public ArrayList<ClassificationPO> finds();
	//���������Ʒ������
	public ClassificationPO find(String classificationTag);
	//���ĳ��Ʒ������
	public boolean insert(ClassificationPO po);
	//�����µ���Ʒ������
	public boolean delete(ClassificationPO po);
	//ɾ���ɵ���Ʒ������
	public boolean update(ClassificationPO po);
    //������Ʒ�����Ϣ��������Ʒ������
}
