package servicesbancairessca;

import org.osoa.sca.annotations.Remotable;

@Remotable
public interface ServicesBancairesService {
	public double validerCheque(double montantCheque, double soldeDisponible);
}
