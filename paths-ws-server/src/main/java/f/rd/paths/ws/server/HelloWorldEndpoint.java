package f.rd.paths.ws.server;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

@Endpoint
public class HelloWorldEndpoint {
	
	private final static String NAMESPACE_URI = "http://www.lockstd.org/a";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "aaRequest")
	public void say() {
		System.out.println();
		System.out.println("------------------------");
		System.out.println("Hello, world!! ");
		System.out.println("------------------------");
		System.out.println();
	}
}
