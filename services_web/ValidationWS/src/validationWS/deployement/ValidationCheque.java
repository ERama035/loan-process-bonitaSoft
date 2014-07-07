package validationWS.deployement;


public class ValidationCheque {
	public double validerCheque(double montantCheque, double soldeDisponible){
		soldeDisponible=soldeDisponible-montantCheque;
		return soldeDisponible;
	}
}