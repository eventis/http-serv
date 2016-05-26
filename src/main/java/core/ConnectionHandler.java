package core;

import java.net.Socket;

/**
 * @author Munteanu Ion (imuntean@redhat.com) 
 *
 */
public interface ConnectionHandler extends Runnable {

	public void handleConnection(Socket socket);

}
