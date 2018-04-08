 package rmi.register.approveBillRegister;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import rmi.dataRemoteObject.approveBillRemoteObject.ApproveReceiptBillRemoteObject;
/**
 * ����ͨ�ŵ�ע����
 * @author zhangao
 * @version 2017.12.28
 * */
public class ApproveReceiptBillRegister {
	public ApproveReceiptBillRegister(){
		
	}
	
	/**
	 * �÷����ע�᷽��
	 * */
	public void register(){
		ApproveReceiptBillRemoteObject remoteObject;
		try {
			remoteObject = new ApproveReceiptBillRemoteObject();
			LocateRegistry.createRegistry(7709);
			Naming.bind("rmi://127.0.0.1:7709/ApproveReceiptBillRemoteObject",
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
