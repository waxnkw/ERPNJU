/**
 * 
 */
package rmi.register.customerRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.dataRemoteObject.customerRemoteObject.CustomerRemoteObject;

/**
 * @author ����һ
 *
 */
public class CustomerRegister {

	public CustomerRegister() {
		
	}
	
	public void register() {
		CustomerRemoteObject remoteObject=null;
		try {
			remoteObject=new CustomerRemoteObject();
			LocateRegistry.createRegistry(9000);
			Naming.bind("rmi://127.0.0.1:9000/CustomerRemoteObject", remoteObject);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
