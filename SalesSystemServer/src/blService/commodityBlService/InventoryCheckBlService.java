/**
 * �ֿ����Ա���п���̵�
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package blService.commodityBlService;

import java.rmi.Remote;

import java.rmi.RemoteException;

import vo.*;


public interface InventoryCheckBlService extends Remote{
	public InventoryCheckSheetVO inventoryCheckSheet() throws RemoteException;
	//��ÿ����ն���
	}
