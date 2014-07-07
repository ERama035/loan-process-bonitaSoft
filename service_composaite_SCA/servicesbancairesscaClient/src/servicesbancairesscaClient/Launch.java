package servicesbancairesscaClient;

import org.apache.tuscany.sca.host.embedded.SCADomain;

public class Launch {
	public final static void main(String[] args) throws Exception {
		SCADomain scaDomain = SCADomain
				.newInstance("servicesbancairesscawsclient.composite");
		WebServiceClient use = scaDomain.getService(WebServiceClient.class,"WebServiceClient");
		use.validerCheque(2000, 50000);
		scaDomain.close();
	}
}
