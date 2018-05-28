import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Server {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		
		ServerSocket sS = new ServerSocket(1234);
		Socket clientSocket = sS.accept();
		
		OutputStream ops = clientSocket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(ops);
		BufferedWriter bw = new BufferedWriter(osw);
		
		InputStream ips = clientSocket.getInputStream();
		InputStreamReader isr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(isr);

		String message = br.readLine();
		String answer = getURL(message);
		
		bw.write(answer);
		bw.newLine();
		bw.flush();
		
		bw.close();
		br.close();
		sS.close();
		clientSocket.close();
	}
	public static String getURL (String site) throws URISyntaxException, IOException
	{
		URI uri = new URI(site);
		URL url = uri.toURL();
		int c;
		
		InputStream in = url.openStream();
		StringBuilder builder = new StringBuilder();
		byte[] data = new byte[1024];
		
		while((c = in.read(data,0,1024)) != -1)
		{
			builder.append(new String(data,0,c));
		}
		return builder.toString();
	}
}
