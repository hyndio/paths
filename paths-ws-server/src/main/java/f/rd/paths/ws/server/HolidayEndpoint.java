package f.rd.paths.ws.server;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.w3c.dom.Element;

@Endpoint
public class HolidayEndpoint {

	private static final String NAMESPACE_URI = "http://lockstd.com/hr/schemas";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "HolidayRequest")
    public void handleHolidayRequest(@RequestPayload Element holidayRequest) throws Exception {
		
		System.out.println("Here i am! ");
		
	}
}
