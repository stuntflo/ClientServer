package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException
	{
		
		String host = "localhost";
		int port = 1234;
		
		Quadrat obj = (Quadrat) Naming.lookup("rmi://" + host + ":" + port + "/" + "QuadratObj");

		float result = obj.quad(5);
		System.out.println(result);
	}

}
