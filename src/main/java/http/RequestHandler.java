package http;

/**
 * @author Munteanu Ion (imuntean@redhat.com)
 *
 */
public interface RequestHandler {

	public void handle(HttpMethod method);
}
