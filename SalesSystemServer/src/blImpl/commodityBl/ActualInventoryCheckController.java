/**
 * �ֿ����Ա����ʵ�ʿ������¼��
 * @author BeibeiZhang
 * @version 2017.11.19  2017.11.28
 *
 */
package blImpl.commodityBl;

import java.rmi.RemoteException;

import blService.commodityBlService.ActualInventoryCheckBlService;
import dataImpl.commodityData.GoodsData;
import po.GoodsPO;

public class ActualInventoryCheckController implements ActualInventoryCheckBlService{

	/**
	 * public int actualInventoryCheck(String goodsTag, int actualAmount) throws RemoteException
	 * @param1 String:to find out the goods
	 * @param2 int:actualAmount of the goods in the warehouse
	 * @return int:the D-value between actualAmount and systemAmount
	 * <0:means less |dValue| pieces of the goods
	 * >0:means over dValue pieces of the goods��
	 * =0:means equal
	 */
	@Override
	public int actualInventoryCheck(String goodsID, int actualAmount) throws RemoteException {
		// TODO Auto-generated method stub
		GoodsData goodsData=new GoodsData();
		GoodsPO theGoods=goodsData.find(goodsID);
		int systemAmount=theGoods.getAmount();
		int dValue=actualAmount-systemAmount;
		return dValue;
	}
	//��¼ʵ�ʿ��
	//������ƷID��ʵ�ʿ������Ȼ���̨��ϵͳԭ�ȿ��Ա�,��ֵΪʵ��ֵ��ȥϵͳ���
	//֮����п�������������ͨ��������޸�ϵͳ���


}
