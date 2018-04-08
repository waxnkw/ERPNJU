 package rmi.linker.approveBillServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.billService.approveBillBlService.ApproveReceiptBillBlService;

public class ApproveReceiptBillServiceLinker {
	private static ApproveReceiptBillServiceLinker linker ;
	private Remote remote ;
	
	private ApproveReceiptBillServiceLinker(){
		setRemote();
	}
	
	/**
	 * �󶨶˿��õ�remote
	 * */
	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:7709/ApproveReceiptBillRemoteObject");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ApproveReceiptBillServiceLinker getInstance(){
		if(linker==null){
			linker = new ApproveReceiptBillServiceLinker();
		}
		return linker;
	}
	
	public ApproveReceiptBillBlService  getApproveReceiptBillBlService(){
		return (ApproveReceiptBillBlService)remote;
	}
}
