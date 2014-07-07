package servicesbancairesscaClient;

import org.osoa.sca.annotations.Remotable;

@Remotable
public interface WebServiceInterface {
	public double validerCheque(double montantCheque, double soldeDisponible);
}
