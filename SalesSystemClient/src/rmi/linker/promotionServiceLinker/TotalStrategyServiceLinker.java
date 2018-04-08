package rmi.linker.promotionServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.promotionBlService.TotalStrategyBlService;

public class TotalStrategyServiceLinker {
	private static TotalStrategyServiceLinker linker ;
	private Remote remote ;
	
	private TotalStrategyServiceLinker(){
		setRemote();
	}
	
	/**
	 * �󶨶˿��õ�remote
	 * */
	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:7102/TotalStrategyRemoteObject");
			System.out.println("linked");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static TotalStrategyServiceLinker getInstance(){
		if(linker==null){
			linker = new TotalStrategyServiceLinker();
		}
		return linker;
	}
	
	public TotalStrategyBlService  getTotalStrategyBlService(){
		return (TotalStrategyBlService)remote;
	}
	
}
