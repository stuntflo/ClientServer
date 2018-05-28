import java.awt.HeadlessException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Model 
{
	public String getLocalIp() throws UnknownHostException
	{
		return InetAddress.getLocalHost().getHostAddress();
	}
	
	public void checkHosts() throws UnknownHostException, IOException
	{
		int timeout=500;
        int port = 1234;

        try 
        {
            String currentIP = InetAddress.getLocalHost().toString();
            String subnet = getSubnet(currentIP);
            System.out.println("subnet: " + subnet);

            ProgressBar balken = null;
            
            for (int i = 1;i < 254; i++)
            {
            	if(balken == null)
            	{
            		// balken = new ProgressBar(1, 254, i);
            	}
            	
            	// balken.setValue(i);
            	
                String host = subnet + i;
                // System.out.println("Checking :" + host);

                if(InetAddress.getByName(host).isReachable(timeout))
                {
                	InetAddress addr = InetAddress.getByName(host);
                	System.out.println("Name: " + addr.getHostName());
                	
                    System.out.println(host + " is reachable");
                    
                    try
                    {
                        Socket connected = new Socket(host, port);
                    }
                    catch (Exception s)
                    {
                        // System.out.println(s);
                    }
                }
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("Fehler: " + e);
        }
    }

    public static String getSubnet(String currentIP)
    {
        int firstSeparator = currentIP.lastIndexOf("/");
        int lastSeparator = currentIP.lastIndexOf(".");
        
        return currentIP.substring(firstSeparator+1, lastSeparator+1);
    }
}