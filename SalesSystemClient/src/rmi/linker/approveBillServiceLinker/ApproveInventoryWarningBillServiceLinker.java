package rmi.linker.approveBillServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.billService.approveBillBlService.ApproveInventoryWarningBillBlService;

public class ApproveInventoryWarningBillServiceLinker {
	private static ApproveInventoryWarningBillServiceLinker linker ;
	private Remote remote ;
	
	private ApproveInventoryWarningBillServiceLinker(){
		setRemote();
	}
	
	/**
	 * °ó¶¨¶Ë¿ÚÄÃµ½remote
	 * */
	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:7705/ApproveInventoryWarningBillRemoteObject");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ApproveInventoryWarningBillServiceLinker getInstance(){
		if(linker==null){
			linker = new ApproveInventoryWarningBillServiceLinker();
		}
		return linker;
	}
	
	public ApproveInventoryWarningBillBlService  getApproveInventoryWarningBillBlService(){
		return (ApproveInventoryWarningBillBlService)remote;
	}
}
