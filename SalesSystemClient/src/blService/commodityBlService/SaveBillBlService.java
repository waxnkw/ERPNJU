/**
 * �ֿ����Ա���п������󱣴浥�ݣ�ʵ�������߼�����һ�ֵ��ݱ��棬�����ڴ�����ļ��У��ȴ��ܾ������
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */package blService.commodityBlService;

import java.rmi.Remote;

import java.rmi.RemoteException;

import vo.*;

public interface SaveBillBlService extends Remote{
	public boolean saveInventoryWarningBill(InventoryWarningBillVO  bill) throws RemoteException;
	//�����澯�䵥
	public boolean saveInventoryLossBill(InventoryLossBillVO  bill) throws RemoteException;
	//�����汨��
	public boolean saveInventoryOverBill(InventoryOverBillVO  bill) throws RemoteException;
    //�����汨�絥
}
