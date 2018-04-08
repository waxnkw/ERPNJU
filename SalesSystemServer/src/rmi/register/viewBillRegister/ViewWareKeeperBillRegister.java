package rmi.register.viewBillRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import rmi.dataRemoteObject.viewBillRemoteObject.ViewWareKeeperBillRemoteObject;

public class ViewWareKeeperBillRegister {
	public ViewWareKeeperBillRegister(){
		
	}
	
	public void register(){
		ViewWareKeeperBillRemoteObject remoteObject;
		try {
			remoteObject = new ViewWareKeeperBillRemoteObject();
			LocateRegistry.createRegistry(8009);
			Naming.bind("rmi://127.0.0.1:8009/ViewWareKeeperBillRemoteObject",
					remoteObject);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
