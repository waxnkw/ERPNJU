package blStubs.customerBlStubs;
import java.rmi.RemoteException;
import java.util.ArrayList;

import assistant.type.UserPositionEnum;
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

public class CustomerBlService_Stub implements CustomerBlService, ModifyCustomerMoneyService ,GetCustomerService{

	
	/**
	 * �޸Ŀͻ���Ӧ��Ӧ��
	 * @param �ͻ���ţ��ַ�����
	 * @param �޸ĵ�����
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean ModifyCustomerMoney(String number, double amount) {
		// TODO Auto-generated method stub
		//boolean success=Impl.ModifyCustomerMoney(number, amount);
		if(number.equals("i00001")&&amount==10000) {
			return true;
		}
		return false;	
	}

	/**
	 * ����һλ�ͻ�
	 * @param CustomerVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean AddCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		//boolean success=Impl.AddCustomer(vo);
		if(vo.getId().equals("i00001")) {
			return true;
		}
		return false;		
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
//		boolean success=Impl.DelCustomer(number, name);
//		return success;
		if(number.equals("i00001")&&name.equals("No.1")) {
			return true;
		}
		return false;	
	}

	/**
	 * �޸�һλ�ͻ��Ŀͻ���Ϣ��Ӧ��Ӧ�����⣩
	 * @param CustomerVO
	 * @return ����һ������ֵ��ʾ�Ƿ�����ɹ�������ɹ��򷵻�True
	 */
	@Override
	public boolean ModCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		if(vo.getId().equals("i00001")) {
			return true;
		}
		return false;	
	}

	/**
	 * ��ѯ�ͻ���Ϣ��֧��ģ������
	 * @param �ؼ��ֶ�
	 * @return ArrayList<CustomerVO>�����û���ҵ��򷵻�null
	 */
	@Override
	public ArrayList<CustomerVO> QueryCustomer(String name) {
		// TODO Auto-generated method stub
		ArrayList<CustomerVO> array=new ArrayList<CustomerVO>();
		CustomerVO vo=new CustomerVO();
		array.add(vo);
		return array;
	}
	
	/**
	 * �õ����пͻ��Ĳ�����Ϣ����������Ա��
	 * @return ArrayList<CustomerInfoVO>
	 */
	@Override
	public ArrayList<CustomerInfoVO> GetCustomers(){
		ArrayList<CustomerInfoVO> customers=new ArrayList<CustomerInfoVO>();
		CustomerInfoVO infoVO=new CustomerInfoVO();
		customers.add(infoVO);
		return customers;
	}

	/**
	 * @see blService.customerBlService.CustomerBlService#GetUsers()
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<UserInfoVO> GetUsers() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserInfoVO> users=new ArrayList<>();
		UserInfoVO vo1=new UserInfoVO();
		vo1.setId("00001");
		vo1.setName("People1");
		vo1.setUserPositionEnum(UserPositionEnum.MANAGER);
		UserInfoVO vo2=new UserInfoVO();
		vo1.setId("00002");
		vo2.setName("People2");
		vo2.setUserPositionEnum(UserPositionEnum.SALESMAN);
		users.add(vo1);
		users.add(vo2);
		return users;
	}
	
}
