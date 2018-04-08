/**
 * 
 */
package rmi.register.salesRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.dataRemoteObject.salesRemoteObject.SalesRemoteObject;

/**
 * @author cosx
 *
 */
public class SalesRegister {

	public SalesRegister() {
		
	}
	
	public void register() {
		SalesRemoteObject remoteObject=null;
		
		try {
			remoteObject=new SalesRemoteObject();
			LocateRegistry.createRegistry(9001);
			Naming.bind("rmi://127.0.0.1:9001/SalesRemoteObject", remoteObject);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
