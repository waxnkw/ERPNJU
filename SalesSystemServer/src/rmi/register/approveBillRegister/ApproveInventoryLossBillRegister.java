 package rmi.register.approveBillRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import rmi.dataRemoteObject.approveBillRemoteObject.ApproveInventoryLossBillRemoteObject;
/**
 * ����ͨ�ŵ�ע����
 * @author zhangao
 * @version 2017.12.28
 * */
public class ApproveInventoryLossBillRegister {
	public ApproveInventoryLossBillRegister(){
		
	}
	
	/**
	 * �÷����ע�᷽��
	 * */
	public void register(){
		ApproveInventoryLossBillRemoteObject remoteObject;
		try {
			remoteObject = new ApproveInventoryLossBillRemoteObject();
			LocateRegistry.createRegistry(7703);
			Naming.bind("rmi://127.0.0.1:7703/ApproveInventoryLossBillRemoteObject",
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
