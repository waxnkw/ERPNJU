 package rmi.register.approveBillRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import rmi.dataRemoteObject.approveBillRemoteObject.ApprovePurchaseReturnBillRemoteObject;
/**
 * ����ͨ�ŵ�ע����
 * @author zhangao
 * @version 2017.12.28
 * */
public class ApprovePurchaseReturnBillRegister {
	public ApprovePurchaseReturnBillRegister(){
		
	}
	
	/**
	 * �÷����ע�᷽��
	 * */
	public void register(){
		ApprovePurchaseReturnBillRemoteObject remoteObject;
		try {
			remoteObject = new ApprovePurchaseReturnBillRemoteObject();
			LocateRegistry.createRegistry(7708);
			Naming.bind("rmi://127.0.0.1:7708/ApprovePurchaseReturnBillRemoteObject",
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
