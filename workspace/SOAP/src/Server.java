import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;

public class Server {

	public static void main(String[] args) {
	
		Endpoint endpoint = Endpoint.publish("http://localhost:1234/ComputationService", new ComputationService());
		JOptionPane.showMessageDialog( null, "Kill Server?" );
		endpoint.stop();
	}

}
