package blImpl.logBl;

import blService.logBlService.LogBlService;

/**
 * ������Ա�����˻����¼��ҵ���߼�������
 * @author ����һ
 * @version 2017.11.7
 *
 */

public class LogBlController implements LogBlService{

	private LogBl Impl=new LogBl();
	/**
	 * �ж��û��Ƿ�Ϊ�Ϸ��û�
	 * @param �û������ID���ַ�����
	 * @param �û���������루�ַ�����
	 * @return ����ֵ������û���������ƥ�䷵��True
	 */
	@Override
	public boolean isValidUser(String userId, String password) {
		// TODO Auto-generated method stub
		boolean success=Impl.isValidUser(userId, password);
		return success;
	}

	/**
	 * ע���û��������˻���
	 * @param �û������Ѿ�������õ�ID���ַ�����
	 * @param �û���������루�ַ�����
	 * @return ����ֵ������������̳ɹ��򷵻�True
	 */
	@Override
	public boolean registerUser(String userId, String password) {
		// TODO Auto-generated method stub
		boolean success=Impl.registerUser(userId, password);
		return success;
	}

	/**
	 * �޸�����, ���ܳ���ĳЩ�����ַ�, ��windows��������
	 * @param �û������ID���ַ�����
	 * @param �û�����ľ����루�ַ�����
	 * @param �û�����������루�ַ�����
	 * @return ����ֵ������޸�����ɹ��򷵻�True
	 */
	@Override
	public boolean changePassword(String userId, String oldPassword, String password) {
		// TODO Auto-generated method stub
		boolean success=Impl.changePassword(userId, oldPassword, password);
		return success;
	}

}
