package http;


/**
 * @author Munteanu Ion (imuntean@redhat.com) 
 *
 */
public enum ContentType {
	
	HTM("HTM"), 
	HTML("HTML"), 
	ICO("ICO"), 
	JPEG("JPEG"), 
	PNG("PNG"), 
	TXT("TXT"), 
	XML("XML"),
	MPEG("MP3"); 

	private final String ext;

	ContentType(String ext) {
		this.ext = ext;
	}

	@Override
	public String toString() {
		switch (this) {
			case HTML:
				return "Content-Type: text/html";
			case ICO:
				return "Content-Type: image/gif";
			case JPEG:
				return "Content-Type: image/jpeg";
			case PNG:
				return "Content-Type: image/png";
			case TXT:
				return "Content-type: text/plain";
			case XML:
				return "Content-type: text/xml";
			case MPEG:
				return "Content-type: audio/mpeg";
			default:
				return null;
		}
	}
}
