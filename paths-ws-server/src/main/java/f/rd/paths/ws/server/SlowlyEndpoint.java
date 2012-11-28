package f.rd.paths.ws.server;


import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Endpoint
public class SlowlyEndpoint {
	
	private final static String NAMESPACE_URI = "http://airline.lock.com/slowly/schemas";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "SlowlyRequest")
	public void slowlyRequest(@RequestPayload Element slowly) throws Exception {
		try {
			Namespace namespace = Namespace.getNamespace("slowly", NAMESPACE_URI);
			XPathFactory xPathFactory = XPathFactory.instance();
			XPathExpression<Element> playerExpression = xPathFactory.compile("//slowly:Player", Filters.element(), null, namespace);
			XPathExpression<Element> thresholdExpression = xPathFactory.compile("//slowly:Threshold", Filters.element(), null, namespace);
			
			System.out.println();
			System.out.println("Player: " + playerExpression.evaluateFirst(slowly).getText());
			System.out.println("Threshold: " + thresholdExpression.evaluateFirst(slowly).getText());
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
