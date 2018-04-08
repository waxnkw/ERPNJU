/**
 * 
 */
package rmi.linker.salesServiceLinker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import blService.salesBlService.SalesBlService;

/**
 * @author ÍõÄþÒ»
 *
 */
public class SalesServiceLinker {
	private static SalesServiceLinker linker;
	private Remote remote;
	
	private SalesServiceLinker() {
		setRemote();
	}
	
	private void setRemote() {
		try {
			this.remote=Naming.lookup("rmi://127.0.0.1:9001/SalesRemoteObject");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static SalesServiceLinker getInstance() {
		if(linker==null) {
			linker=new SalesServiceLinker();
		}
		return linker;
	}
	
	public SalesBlService getSalesBlService() {
		return (SalesBlService)remote;
	}
	
}
