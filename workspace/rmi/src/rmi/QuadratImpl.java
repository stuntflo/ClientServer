package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class QuadratImpl extends UnicastRemoteObject implements Quadrat
{

	protected QuadratImpl() throws RemoteException
	{
		super();
	}

	@Override
	public float quad(float num) 
	{
		return (float) Math.pow(num, 2);
	}
	
}
