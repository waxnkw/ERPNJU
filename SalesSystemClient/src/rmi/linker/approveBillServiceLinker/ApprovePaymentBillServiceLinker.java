package rmi.linker.approveBillServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.billService.approveBillBlService.ApprovePaymentBillBlService;

public class ApprovePaymentBillServiceLinker {
	private static ApprovePaymentBillServiceLinker linker ;
	private Remote remote ;
	
	private ApprovePaymentBillServiceLinker(){
		setRemote();
	}
	
	/**
	 * �󶨶˿��õ�remote
	 * */
	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:7706/ApprovePaymentBillRemoteObject");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ApprovePaymentBillServiceLinker getInstance(){
		if(linker==null){
			linker = new ApprovePaymentBillServiceLinker();
		}
		return linker;
	}
	
	public ApprovePaymentBillBlService  getApprovePaymentBillBlService(){
		return (ApprovePaymentBillBlService)remote;
	}
}
