/**
 * �ֿ����Ա������Ʒ��Ϣ�Ĺ���
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package blService.commodityBlService;

import java.rmi.Remote;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.*;

public interface GoodsInforBlService extends Remote{
	public boolean ifGoodsExist(String goodsName,String goodsType) throws RemoteException;
	//ͨ�����Ƽ��ͺż��ĳ����Ʒ�Ƿ����
	public boolean ifGoodsExist(String goodsID) throws RemoteException;
	//ͨ��ID���ĳ����Ʒ�Ƿ����
	public ArrayList<GoodsVO> fuzzyEnquiry(String keyWord) throws RemoteException;
	//������Ʒʱ���Խ���ģ����ѯ����������Ʒ�б�
	public GoodsVO goodsINfor(String goodsTag) throws RemoteException;
	//��ȡһ����Ʒ�����Ի�ø���Ʒ����Ϣ
	public boolean modifyGoodsInfor(GoodsVO vo) throws RemoteException;
	//�޸�ĳ����Ʒ����Ϣ�������޸Ŀ��

}
