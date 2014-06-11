package it.mathchallenger.admin.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Communication {
	private static Communication singleton;

	private Socket			   socket;
	private final static String  HOSTNAME	  = "54.76.113.193"; //ip del server
	private final static int	 HOSTNAME_PORT = 60000;
	private static int		   TIMEOUT_READ  = 10000;		// 10 secondi timeout

	private Communication() {
		super();
	}

	public static synchronized Communication getInstance() {
		if (singleton == null) {
			singleton = new Communication();
		}
		return singleton;
	}

	public void run() {}

	private OutputStream   out;
	private BufferedReader in;

	public boolean connect() throws UnknownHostException, IOException {
		if (socket == null || socket.isClosed()) {
			socket = new Socket(HOSTNAME, HOSTNAME_PORT);
			socket.setSoTimeout(30000);
			out = socket.getOutputStream();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			return true;
		}
		return false;
	}

	public void disconnect() {
		try {
			send(CommunicationMessageCreator.getInstance().createLogoutMessage());
			close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized void send(Messaggio m) throws IOException {
		if (socket == null || socket.isClosed()) {
			connect();
		}

		for(int i=0;i<5;i++){
			try {
				write(m.getComando());
				m.setResponse(read());
				return;
			}
			catch (IOException e) {
				e.printStackTrace();
				close();
				send(m);
			}
		}
	}

	private synchronized String read() throws IOException {
		if(in==null)
			throw new IOException("ConnectionReader null");
		String r = "";
		long timeout = TIMEOUT_READ + System.currentTimeMillis();
		while ((r = in.readLine()) == null) {
			if (System.currentTimeMillis() > timeout)
				throw new IOException("Timeout error");
		}
		System.out.println(r);
		return r;
	}

	public boolean isConnected() {
		if (socket != null)
			return true;
		return false;
	}

	public void close() throws IOException {
		if (in != null){
			in.close();
			in=null;
		}
		if (out != null){
			out.close();
			out=null;
		}
		if (socket != null) {
			socket.close();
			socket=null;
		}
	}

	private synchronized void write(String s) throws IOException {
		if(out==null)
			throw new IOException("ConnectionWriter null");
		out.write((s + "\n").getBytes());
		System.out.println(s);
		out.flush();
	}
}
