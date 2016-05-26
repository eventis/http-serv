package http;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Munteanu Ion (imuntean@redhat.com)
 *
 */
public class HttpResponse {

	private static Logger log = Logger.getLogger(HttpResponse.class);

	private List<String> headers = new ArrayList<String>();
	private byte[] body;

	public HttpResponse(HttpRequest req) throws IOException {

		switch (req.getMethod()) {
		case HEAD:
			fillHeaders(StatusCode.OK);
			break;
		case GET:
			try {
				fillHeaders(StatusCode.OK);

				File file = new File(req.getUri());
				if (file.isDirectory()) {
					headers.add(ContentType.HTML.toString());
					StringBuilder result = new StringBuilder("<html><head>");
					result.append(req.getUri());
					result.append("</head><body>");
					result.append(req.getUri());
					result.append("</h1><pre>");

					File[] files = file.listFiles();

					for (File file1 : files) {
						result.append(" <a href=\"" + file1.getPath() + "\">" + file1.getAbsolutePath() + "</a>\n");
					}

					result.append("</pre></body></html>");
					fillResponse(result.toString());

				} else if (file.exists()) {
					setContentType(req.getUri(), headers);
					fillResponse(getBytes(file));
				} else {
					log.info("File not found:" + req.getUri());
					fillHeaders(StatusCode.NOT_FOUND);
					fillResponse(StatusCode.NOT_FOUND.toString());
				}
			} catch (Exception e) {
				log.error("Response Error", e);
			}

			break;
		default:
		}

	}

	private byte[] getBytes(File file) {

		Path path = Paths.get(file.getPath());
		byte[] data = null;
		try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {
			log.error("Could not retrieve bytes from file");
		}

		return data;
	}

	private void fillHeaders(StatusCode status) {
		headers.add(HttpVersion.HTTP_1_1 + " " + status.toString());
	}

	private void fillResponse(String response) {
		body = response.getBytes();
	}

	private void fillResponse(byte[] response) {
		body = response;
	}

	public void write(OutputStream os) throws IOException {

		DataOutputStream output = new DataOutputStream(os);
		for (String header : headers) {
			output.writeBytes(header + "\r\n");
		}
		output.writeBytes("\r\n");
		if (body != null) {
			output.write(body);
		}
		output.writeBytes("\r\n");
		output.flush();
	}

	private void setContentType(String uri, List<String> list) {
		try {

			String ext = uri.substring(uri.indexOf(".") + 1);
			list.add(ContentType.valueOf(ext.toUpperCase()).toString());
		} catch (Exception e) {
			log.error("ContentType not found: " + e, e);
		}
	}
}
