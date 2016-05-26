package http;

import org.apache.log4j.Logger;

/**
 * @author Munteanu Ion (imuntean@redhat.com)
 *
 */
public class RequestParser {

	private static final Logger log = Logger.getLogger(RequestParser.class);

	private HttpMethod method;
	private String uri;
	private String version;

	public RequestParser(String request) {

		parseRequestLine(request);

	}

	public HttpMethod getMethod() {
		return method;
	}

	public String getUri() {
		return uri;
	}

	public String getVersion() {
		return version;
	}

	private void parseRequestLine(String str) {
		log.info(str);
		String[] split = str.split("\\s+");
		try {
			setMethod(HttpMethod.valueOf(split[0]));
		} catch (Exception e) {
			setMethod(HttpMethod.CONNECT);
		}
		setUri(split[1]);
		setVersion(split[2]);
	}

	private void setVersion(String string) {
		version = string;
	}

	private void setUri(String string) {
		uri = string;

	}

	private void setMethod(HttpMethod method) {
		this.method = method;
	}

}
