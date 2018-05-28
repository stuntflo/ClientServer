import java.awt.HeadlessException;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;


public class Controller implements ActionListener
{
	Model model;
	View gui;
	
	public Controller(View gui, Model model)
	{
		this.model = model;
		this.gui = gui;
		
		gui.exitItem.addActionListener(this);
		gui.aboutItem.addActionListener(this);
		gui.ipAddress.addActionListener(this);
		gui.portNumber.addActionListener(this);
		gui.availableClients.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(gui.exitItem))
		{
			gui.trayIcon.displayMessage("Wird beendet...", "...", MessageType.INFO);
			
			System.exit(0);
		}
		else if(e.getSource().equals(gui.aboutItem))
		{
			JOptionPane.showMessageDialog(null, "Jakob Engl | Thomas Sapelza | Florian Unterhofer", "Developers", JOptionPane.DEFAULT_OPTION);
		}
		else if(e.getSource().equals(gui.ipAddress))
		{
			try
			{
				JOptionPane.showMessageDialog(null, "Host:   " + model.getLocalIp() + "\nClient: 10.10.30.254", "About", JOptionPane.DEFAULT_OPTION);
			}
			catch (HeadlessException | UnknownHostException e1)
			{
				JOptionPane.showMessageDialog(null, "Fehler, IP-Adresse nicht gefunden!", "Fehler", JOptionPane.ERROR_MESSAGE);
			}	
		}
		else if(e.getSource().equals(gui.portNumber))
		{
			ServerSocket s;
			try 
			{
				s = new ServerSocket(0);
				JOptionPane.showMessageDialog(null, "Freier Port: " + s.getLocalPort(), "About", JOptionPane.DEFAULT_OPTION);
			}
			catch (IOException e1) 
			{
				JOptionPane.showMessageDialog(null, "Fehler, Port  nicht gefunden!", "Fehler", JOptionPane.ERROR_MESSAGE);

			}
		}
		else if(e.getSource().equals(gui.availableClients))
		{
			try 
			{
				model.checkHosts();
			}
			catch (IOException e1)
			{
				JOptionPane.showMessageDialog(null, "Fehler, Zeitüberschreitung bei der Verbidung!", "Fehler", JOptionPane.ERROR_MESSAGE);	// Todo - Geeignete Fehlermeldung

			}
		}
	}
}