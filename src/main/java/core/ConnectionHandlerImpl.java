package core;

import java.net.Socket;

import org.apache.log4j.Logger;

import http.HttpRequest;
import http.HttpResponse;

/**
 * @author Munteanu Ion (imuntean@redhat.com) 
 *
 */
public class ConnectionHandlerImpl implements ConnectionHandler {

	private static Logger log = Logger.getLogger(ConnectionHandlerImpl.class);

	private Socket socket;
	
	public ConnectionHandlerImpl(Socket socket) {
		this.socket = socket;
	}

	public void handleConnection(Socket socket) {

		try {
			HttpRequest req = new HttpRequest(socket.getInputStream());
			HttpResponse res = new HttpResponse(req);
			res.write(socket.getOutputStream());
			socket.close();
		} catch (Exception e) {
			log.error("Runtime Error", e);
		}
	}

	public void run() {	
		handleConnection(socket);
	}
}
