/**
 * �ֿ����Ա����ɾ����Ʒ����Ʒ���⡢��汨������
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package blService.commodityBlService;

import java.rmi.Remote;

import java.rmi.RemoteException;

import vo.*;


public interface DeleteGoodsBlService extends Remote{
	public boolean delete(StockInOutVO vo) throws RemoteException;
	//��Ʒ���⣬�޸�ϵͳ���
	public boolean obsoleteGoods(GoodsVO vo) throws RemoteException;
	//ɾ������Ʒ��������Ʒ����
	public int compareTowarning(String goodsTag,int currentAmount) throws RemoteException;
    //��ɳ�����뾯��ֵ�Ƚϣ�Ϊ������ڿ�澯��ֵ��Ҫ����澯�䵥
	//����澯�䵥��Ϊ�����ܾ���ȥ�����ģ�������ֱ��Ӱ������
}
