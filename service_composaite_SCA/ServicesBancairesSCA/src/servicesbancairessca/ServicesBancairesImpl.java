package servicesbancairessca;

import org.osoa.sca.annotations.Service;

@Service(ServicesBancairesService.class)
public class ServicesBancairesImpl implements ServicesBancairesService {
	public double validerCheque(double montantCheque, double soldeDisponible){
		if (soldeDisponible>=montantCheque){
		soldeDisponible=soldeDisponible-montantCheque;
		System.out.println("Le ch�que a �t� valid�, votre solde apr�s validation\n Solde disponible = ");		
		return soldeDisponible;
		}
		else{
			System.out.println("Le ch�que n'a pas pu �tre valid�, votre solde disponible n'est pas suffisant\n Solde disponible = ");
			return soldeDisponible;
		}
	}
}
