/**
 * 
 */
package rmi.register.logRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.dataRemoteObject.logRemoteObject.LogRemoteObject;

/**
 * @author cosx
 *
 */
public class LogRegister {

	public LogRegister() {
		
	}
	
	public void register() {
		LogRemoteObject remoteObject=null;
				
		try {
			remoteObject=new LogRemoteObject();
			LocateRegistry.createRegistry(9002);
			Naming.bind("rmi://127.0.0.1:9002/LogRemoteObject", remoteObject);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
		
	}
