package http;

/**
 * @author Munteanu Ion (imuntean@redhat.com)
 *
 */
public enum HttpVersion {

	HTTP_1_0("HTTP/1.0"), HTTP_1_1("HTTP/1.1");

	private final String version;

	private HttpVersion(String version) {

		this.version = version;

	}

}
