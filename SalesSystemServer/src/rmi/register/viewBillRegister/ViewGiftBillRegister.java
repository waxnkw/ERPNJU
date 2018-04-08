package rmi.register.viewBillRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import rmi.dataRemoteObject.viewBillRemoteObject.ViewGiftBillRemoteObject;

public class ViewGiftBillRegister {
	public ViewGiftBillRegister(){
		
	}
	
	public void register(){
		ViewGiftBillRemoteObject remoteObject;
		try {
			remoteObject = new ViewGiftBillRemoteObject();
			LocateRegistry.createRegistry(7007);
			Naming.bind("rmi://127.0.0.1:7007/ViewGiftBillRemoteObject",
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
