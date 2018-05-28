package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Quadrat extends Remote 
{
	public float quad(float num) throws RemoteException;
}
