package rmi.register.viewBillRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import rmi.dataRemoteObject.viewBillRemoteObject.ViewFinanceStaffBillRemoteObject;

public class ViewFinanceStaffBillRegister {
	public ViewFinanceStaffBillRegister(){
		
	}
	
	public void register(){
		ViewFinanceStaffBillRemoteObject remoteObject;
		try {
			remoteObject = new ViewFinanceStaffBillRemoteObject();
			LocateRegistry.createRegistry(8007);
			Naming.bind("rmi://127.0.0.1:8007/ViewFinanceStaffBillRemoteObject",
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
