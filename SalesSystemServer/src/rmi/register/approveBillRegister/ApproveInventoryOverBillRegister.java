 package rmi.register.approveBillRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.dataRemoteObject.approveBillRemoteObject.ApproveInventoryOverBillRemoteObject;
/**
 * ����ͨ�ŵ�ע����
 * @author zhangao
 * @version 2017.12.28
 * */
public class ApproveInventoryOverBillRegister {
	public ApproveInventoryOverBillRegister(){
		
	}
	
	/**
	 * �÷����ע�᷽��
	 * */
	public void register(){
		ApproveInventoryOverBillRemoteObject remoteObject;
		try {
			remoteObject = new ApproveInventoryOverBillRemoteObject();
			LocateRegistry.createRegistry(7704);
			Naming.bind("rmi://127.0.0.1:7704/ApproveInventoryOverBillRemoteObject",
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
