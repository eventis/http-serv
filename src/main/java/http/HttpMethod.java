package http;


/**
 * @author Munteanu Ion (imuntean@redhat.com) 
 *
 */
public enum HttpMethod {
	
	OPTIONS("OPTIONS"),
	GET("GET"), 
	HEAD("HEAD"), 
	POST("POST"), 
	PUT("PUT"), 
	DELETE("DELETE"), 
	TRACE("TRACE"), 
	CONNECT("CONNECT"), 
	UNRECOGNIZED("UNRECOGNIZED");

	private final String method;

	private HttpMethod(String method) {
		this.method = method;

	}
}
