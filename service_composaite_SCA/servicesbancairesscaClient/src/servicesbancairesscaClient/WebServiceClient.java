package servicesbancairesscaClient;

import org.osoa.sca.annotations.Reference;

public class WebServiceClient {
	@Reference
	private WebServiceInterface servicesBancairesService;

	public void validerCheque(double montantCheque, double soldeDisponible) {
		System.out.println(servicesBancairesService.validerCheque(montantCheque,soldeDisponible));
	}
}