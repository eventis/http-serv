package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


/**
 * @author Munteanu Ion (imuntean@redhat.com) 
 *
 */
public class HttpRequest {

	private static final Logger log = Logger.getLogger(HttpRequest.class);


	List<String> headers = new ArrayList<String>();

	private HttpMethod method;
	private String uri;
	private String version;

	public HttpRequest(InputStream is) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String str = reader.readLine();
		log.info("Here is parse Line parseRequestLine" + str);
		parseRequestLine(str);

		while (!str.equals("")) {
			str = reader.readLine();
			parseRequestHeader(str);
			log.info("Here is parse Line parseRequestHeader" + str);
		}
	}

	private void parseRequestLine(String str) {
		log.info(str);
		String[] split = str.split("\\s+");
		try {
			method = HttpMethod.valueOf(split[0]);
		} catch (Exception e) {
			method = HttpMethod.UNRECOGNIZED;
		}
		uri = split[1];
		version = split[2];
	}

	private void parseRequestHeader(String str) {
		log.info(str);
		headers.add(str);
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
