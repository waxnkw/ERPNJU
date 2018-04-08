/**
 * �ֿ����Ա������Ʒ������������Ʒ�������ɾ��
 * @author BeibeiZhang
 * @version 2017.11.19
 *
 */
package blService.commodityBlService;

import java.rmi.Remote;

import java.rmi.RemoteException;

import vo.*;

/////do some change 2017.10.30
public interface GoodsClassificationBlService extends Remote{
	public ClassificationTreeVO getClassificationTree() throws RemoteException;
	//�������������Գ������������ʼ����
	public boolean ifClassificationExist(String classificationTag) throws RemoteException;
	//����ĳ������Ƿ��Ѵ���
	public boolean addNewClassification(ClassificationVO vo)throws RemoteException;
	//�����µĸ����
	public ClassificationVO classificationInfor(String classificationNum) throws RemoteException;
	//��ȡ���������˽��������Ϣ
	public boolean addClassification(ClassificationVO vo) throws RemoteException;
	//�����µ������
	public boolean deleteClassification(ClassificationVO vo) throws RemoteException;
	//ɾ��ĳ���
	public boolean modifyClassificationInfor(ClassificationVO vo) throws RemoteException;
	//�޸�ĳ�����Ϣ��ֻ���޸�����������丸���
}
