import java.awt.*;

import javax.swing.JFrame;

public class View extends JFrame
{
	PopupMenu popup;
	Image image;
	TrayIcon trayIcon;
	SystemTray tray;
	MenuItem aboutItem, portNumber, ipAddress, availableClients, exitItem;
	
	public View()
	{
		image = Toolkit.getDefaultToolkit().getImage("images\\icon2.png");
		popup = new PopupMenu();
	    trayIcon =  new TrayIcon(image, "LinkIT", popup);
	    
	    tray = SystemTray.getSystemTray();
	   
	    aboutItem = new MenuItem("About");
	    Menu displayMenu = new Menu("Informations");
	    ipAddress = new MenuItem("IP-Adresse");
	    portNumber = new MenuItem("Port-Number");
	    exitItem = new MenuItem("Exit");
	    availableClients = new MenuItem("Available Clients");
	    
	    popup.add(aboutItem);
	    popup.addSeparator();
	    popup.add(displayMenu);
	    displayMenu.add(ipAddress);
	    displayMenu.add(portNumber);
	    displayMenu.add(availableClients);
	    popup.addSeparator();
	    popup.add(exitItem);
	    
	    trayIcon.setPopupMenu(popup);
	   
	    try
	    {
	        tray.add(trayIcon);
	     }
	    catch (AWTException e)
	    {
	    	System.out.println("TrayIcon could not be added.");
	    }
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}