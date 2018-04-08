package rmi.linker.promotionServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.promotionBlService.UserStrategyBlService;

public class UserStrategyServiceLinker {

	private static UserStrategyServiceLinker linker ;
	private Remote remote ;
	
	private UserStrategyServiceLinker(){
		setRemote();
	}
	
	/**
	 * �󶨶˿��õ�remote
	 * */
	private void setRemote(){
		try {
			this.remote = Naming.lookup("rmi://127.0.0.1:7101/UserStrategyRemoteObject");
			System.out.println("linked");
		}catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static UserStrategyServiceLinker getInstance(){
		if(linker==null){
			linker = new UserStrategyServiceLinker();
		}
		return linker;
	}
	
	public UserStrategyBlService  getUserStrategyBlService(){
		return (UserStrategyBlService )remote;
	}
	
}
