/**
 * �ֿ����Ա����ʵ�ʿ������¼��
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package blService.commodityBlService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ActualInventoryCheckBlService extends Remote{
	public int actualInventoryCheck(String goodsTag,int actualAmount) throws RemoteException;
	//��¼ʵ�ʿ��
	//������ƷID��ʵ�ʿ������Ȼ���̨��ϵͳԭ�ȿ��Ա�
	//֮����п�������������ͨ��������޸�ϵͳ���
}
