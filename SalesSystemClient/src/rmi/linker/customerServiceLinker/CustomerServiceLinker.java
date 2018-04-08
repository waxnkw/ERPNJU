/**
 * 
 */
package rmi.linker.customerServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.customerBlService.CustomerBlService;

/**
 * @author ����һ
 *
 */
public class CustomerServiceLinker {

	private static CustomerServiceLinker linker;
	private Remote remote;
	
	private CustomerServiceLinker() {
		setRemote();
	}
	
	private void setRemote() {
		try {
			this.remote=Naming.lookup("rmi://127.0.0.1:9000/CustomerRemoteObject");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static CustomerServiceLinker getInstance() {
		if(linker==null) {
			linker=new CustomerServiceLinker();
		}
		return linker;
	}
	
	public CustomerBlService getCustomerBlService() {
		return (CustomerBlService)remote;
	}
	
}
