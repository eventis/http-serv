package core;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

/**
 * @author Munteanu Ion (imuntean@redhat.com) 
 *
 */
public class HttpServer extends Server {

	private static Logger log = Logger.getLogger(HttpServer.class);
	
	private static final int nThreads = 5;
	private static ServerSocket ss;

	public void start(int port)  {

		try {
			ss = new ServerSocket(port);
			log.info("Listening on port " + port);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		while (true) {
			try {
				executor.submit(new ConnectionHandlerImpl(ss.accept()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stop() {
		//TODO:
	}

}
