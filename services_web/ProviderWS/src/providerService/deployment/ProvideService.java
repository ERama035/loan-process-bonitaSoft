package providerService.deployment;

public class ProvideService {
	public double verserPretDansLeCompteClient(double soldeDisponible, double montantPret) {
		soldeDisponible= soldeDisponible + montantPret;
		return soldeDisponible;
	}

}
