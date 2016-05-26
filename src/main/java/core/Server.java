package core;

/**
 * @author Munteanu Ion (imuntean@redhat.com) 
 *
 */
public abstract class Server {

	public abstract void start(int port);	
	public abstract void stop();
}
