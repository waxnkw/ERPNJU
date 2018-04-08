package blImpl.customerBl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blInteract.customerInteract.GetCustomerService;
import blInteract.customerInteract.ModifyCustomerMoneyService;
import blService.customerBlService.CustomerBlService;
import vo.CustomerInfoVO;
import vo.CustomerVO;
import vo.UserInfoVO;

/**
 * ����������Ա�ͻ�����Ŀ�����
 * @author ����һ
 * @version 2017.11.7
 *
 */

public class CustomerBlController implements CustomerBlService, ModifyCustomerMoneyService ,GetCustomerService{


	private CustomerBl Impl=new CustomerBl();
	
	/**
	 * �޸Ŀͻ���Ӧ��Ӧ��
	 * @param �ͻ���ţ��ַ�����
	 * @param �޸ĵ�����
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean ModifyCustomerMoney(String number, double amount) {
		// TODO Auto-generated method stub
		boolean success=Impl.ModifyCustomerMoney(number, amount);
		return success;
	}

	/**
	 * ����һλ�ͻ�
	 * @param CustomerVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean AddCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		boolean success=Impl.AddCustomer(vo);
		return success;
	}

	/**
	 * ɾ��һλ�ͻ�
	 * @param һ���ͻ���ID
	 * @param һ���ͻ�������
	 * ֻ��ID��������ƥ��֮����ܽ���ɾ������
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean DelCustomer(String number, String name) {
		// TODO Auto-generated method stub
		boolean success=Impl.DelCustomer(number, name);
		return success;
	}

	/**
	 * �޸�һλ�ͻ��Ŀͻ���Ϣ��Ӧ��Ӧ�����⣩
	 * @param CustomerVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean ModCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		boolean success=Impl.ModCustomer(vo);
		return success;
	}

	/**
	 * ��ѯ�ͻ���Ϣ��֧��ģ������
	 * @param �ؼ��ֶ�
	 * @return ArrayList<CustomerVO>�����û���ҵ��򷵻�null
	 */
	@Override
	public ArrayList<CustomerVO> QueryCustomer(String name) {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> customerVOs=new ArrayList<CustomerVO>();
		customerVOs=Impl.QueryCustomer(name);
		
		return customerVOs;
	}
	
	/**
	 * �õ����пͻ��Ĳ�����Ϣ����������Ա��
	 * @return ArrayList<CustomerInfoVO>
	 */
	@Override
	public ArrayList<CustomerInfoVO> GetCustomers(){
		ArrayList<CustomerInfoVO> customers=new ArrayList<CustomerInfoVO>();
		customers=Impl.GetCustomers();
		return customers;
	}

	/**
	 * @see blService.customerBlService.CustomerBlService#GetUsers()
	 * @return ArrayList<UserInfoVO>
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<UserInfoVO> GetUsers() throws RemoteException {
		ArrayList<UserInfoVO> users=new ArrayList<>();
		users=Impl.GetUsers();
		return users;
	}
	
}
