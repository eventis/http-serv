package bootstrap;

import java.io.IOException;

import core.HttpServer;

/**
 * @author Munteanu Ion (imuntean@redhat.com) 
 *
 */
public class HttpServerRunner {

	public static void main(final String[] args) throws IOException {

		if (args != null & args.length > 0) {
			int port = Integer.parseInt(args[0]);
				new HttpServer().start(port); 
		}else {
				throw new NumberFormatException("Invalid port!");
			}
		}

	}
