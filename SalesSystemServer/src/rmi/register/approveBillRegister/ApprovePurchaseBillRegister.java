 package rmi.register.approveBillRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import rmi.dataRemoteObject.approveBillRemoteObject.ApprovePurchaseBillRemoteObject;
/**
 * ����ͨ�ŵ�ע����
 * @author zhangao
 * @version 2017.12.28
 * */
public class ApprovePurchaseBillRegister {
	public ApprovePurchaseBillRegister(){
		
	}
	
	/**
	 * �÷����ע�᷽��
	 * */
	public void register(){
		ApprovePurchaseBillRemoteObject remoteObject;
		try {
			remoteObject = new ApprovePurchaseBillRemoteObject();
			LocateRegistry.createRegistry(7008);
			Naming.bind("rmi://127.0.0.1:7008/ApprovePurchaseBillRemoteObject",
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
