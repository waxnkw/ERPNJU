/**
 * 
 */
package rmi.dataRemoteObject.customerRemoteObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import blImpl.customerBl.CustomerBlController;
import blService.customerBlService.CustomerBlService;
import vo.CustomerVO;
import vo.UserInfoVO;

/**
 * @author ����һ
 *
 */
public class CustomerRemoteObject extends UnicastRemoteObject implements CustomerBlService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2262137167334709929L;

	public CustomerRemoteObject() throws RemoteException{
		super();
	}

	CustomerBlService service=new CustomerBlController();
	
	/**
	 * ����VO����һ���ͻ�
	 * @see blService.customerBlService.CustomerBlService#AddCustomer(vo.CustomerVO)
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public boolean AddCustomer(CustomerVO vo) throws RemoteException {
		return service.AddCustomer(vo);
	}

	/**
	 * ɾ���ͻ�
	 * @see blService.customerBlService.CustomerBlService#DelCustomer(java.lang.String, java.lang.String)
	 * @param number
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public boolean DelCustomer(String number, String name) throws RemoteException {
		return service.DelCustomer(number, name);
	}

	/**
	 * @see blService.customerBlService.CustomerBlService#ModCustomer(vo.CustomerVO)
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public boolean ModCustomer(CustomerVO vo) throws RemoteException {
		return service.ModCustomer(vo);
	}

	/**
	 * @see blService.customerBlService.CustomerBlService#QueryCustomer(java.lang.String)
	 * @param name
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<CustomerVO> QueryCustomer(String name) throws RemoteException {
		return service.QueryCustomer(name);
	}

	/**
	 * @see blService.customerBlService.CustomerBlService#GetUsers()
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ArrayList<UserInfoVO> GetUsers() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
