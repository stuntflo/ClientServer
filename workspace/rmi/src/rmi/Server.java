package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{

	public static void main(String[] args) throws RemoteException
	{
		
		QuadratImpl obj = new QuadratImpl();
		String objName = "QuadratObj";
		int port = 1234;
		
		Registry registry = LocateRegistry.getRegistry(port);
		boolean bound = false;
		
		for(int i = 0;! bound &&  i < 2; i++)
		{
			try 
			{			
				registry.rebind(objName,obj);
				bound = true;	
			}
			catch(RemoteException e)
			{
				System.out.println("Error");
				registry = LocateRegistry.createRegistry (port);
			}
		}
	}

}


