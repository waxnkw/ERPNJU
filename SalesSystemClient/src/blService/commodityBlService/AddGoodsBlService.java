/**
 * �ֿ����Ա������������Ʒ����Ʒ���
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package blService.commodityBlService;

import java.rmi.Remote;

import java.rmi.RemoteException;

import vo.*;

//do some change 2017.10.30
public interface AddGoodsBlService extends Remote{

public boolean addNewGoods(GoodsVO goodsVO,StockInOutVO stockVO) throws RemoteException;
//�������Ʒ��������Ʒ����
public boolean add(StockInOutVO vo) throws RemoteException;
//��Ʒ��⣬�޸Ŀ������
}
