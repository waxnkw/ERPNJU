/**
 * �ֿ����Ա���п����飬���ĳʱ����ڵĳ�������
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package blService.commodityBlService;

import java.rmi.Remote;

import java.rmi.RemoteException;

import assistant.utility.Date;
import vo.StockCheckSheetVO;

public interface StockCheckBlService extends Remote{
	public StockCheckSheetVO stockCheckSheet(Date beginTime,Date endTime) throws RemoteException;
    //��ÿ��������
}
