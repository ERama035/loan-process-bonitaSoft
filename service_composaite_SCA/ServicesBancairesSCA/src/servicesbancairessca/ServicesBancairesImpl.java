package servicesbancairessca;

import org.osoa.sca.annotations.Service;

@Service(ServicesBancairesService.class)
public class ServicesBancairesImpl implements ServicesBancairesService {
	public double validerCheque(double montantCheque, double soldeDisponible){
		if (soldeDisponible>=montantCheque){
		soldeDisponible=soldeDisponible-montantCheque;
		System.out.println("Le chèque a été validé, votre solde après validation\n Solde disponible = ");		
		return soldeDisponible;
		}
		else{
			System.out.println("Le chèque n'a pas pu être validé, votre solde disponible n'est pas suffisant\n Solde disponible = ");
			return soldeDisponible;
		}
	}
}
