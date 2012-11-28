package f.rd.paths.ws.client;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.xml.transform.StringSource;

@Service
public class SlowlyRequestClientImpl extends WebServiceGatewaySupport implements
		SlowlyRequsetClient {

	public void sendSlowlyData() {
		
		StringBuilder xml = new StringBuilder();
		xml.append("<SlowlyRequest xmlns=\"http://airline.lock.com/slowly/schemas\">");
		xml.append("<CurrentSpeed>");
		xml.append("<Player>Lock</Player>");
		xml.append("<Start>100</Start>");
		xml.append("<End>1000</End>");
		xml.append("<Threshold>1050</Threshold>");
		xml.append("<Max>1200</Max>");
		xml.append("</CurrentSpeed>");
		xml.append("</SlowlyRequest>");

		Source source = new StringSource(xml.toString());
		String uri = "http://localhost:8080/airline-web-app/ws/slowlySpeedService";
		this.getWebServiceTemplate().sendSourceAndReceiveToResult(uri, source, new StreamResult(System.out));
		
	}

}
