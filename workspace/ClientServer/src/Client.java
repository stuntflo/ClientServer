import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String host = "localhost";
		String all = "";
		
		Socket mySocket = new Socket(host,1234);
		
		OutputStream ops = mySocket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(ops);
		BufferedWriter bw = new BufferedWriter(osw);
		
		InputStream ips = mySocket.getInputStream();
		InputStreamReader isr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(isr);
		
		bw.write("https://www.google.de/");
		bw.newLine();
		bw.flush();
		
		String answer = br.readLine();
		
		while((answer = br.readLine()) != null)
		{
			all = all + answer;
		}
		
		writeIntoFile(all);
		
		bw.close();
		br.close();
		mySocket.close();
		

	}
	public static void writeIntoFile(String html) throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter pw = new PrintWriter("hoi.html", "UTF-8");
		pw.println(html);
		pw.close();
	}
}
