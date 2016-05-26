package http;

/**
 * @author Munteanu Ion (imuntean@redhat.com)
 *
 *
 *
 *         The Status-Code element is a 3-digit integer result code of the
 *         attempt to understand and satisfy the request
 * 
 *         1xx: Informational - Request received, continuing process 2xx:
 *         Success - The action was successfully received, understood, and
 *         accepted 3xx: Redirection - Further action must be taken in order to
 *         complete the request 4xx: Client Error - The request contains bad
 *         syntax or cannot be fulfilled 5xx: Server Error - The server failed
 *         to fulfill an apparently valid request
 * 
 */

public enum StatusCode {

	CONTINUE(100, "Continue"), CREATED(200, "Created"), NO_CONTENT(204, "No content"), OK(200, "OK"), BAD_REQUEST(400,
			"Bad request"), UNAUTHORIZED(401, "Unauthorized"), FORBIDDEN(403, "Forbidden"), NOT_FOUND(404,
					"Not Found"), METHOD_NOT_ALLOWED(405, "Method not allowed"), GONE(410, "Gone"), URI_TOO_LONG(414,
							"URI too long"), INTERNAL_ERROR(500, "Internal Server Error"), BAD_GATEWAY(502,
									"Bad gateway"), SERVICE_UNAVAILABLE(503,
											"Service Unavailable"), NOT_SUPPORTED(505, "HTTP Version not supported");

	public final int code;
	public final String reasonPhrase;

	private StatusCode(int code, String reasonPhrase) {
		this.code = code;
		this.reasonPhrase = reasonPhrase;
	}

	@Override
	public String toString() {
		return reasonPhrase;
	}

}
