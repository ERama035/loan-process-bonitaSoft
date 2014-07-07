package clientInfosRestService.deployment;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
 
public class UserResource extends ServerResource {  	
	@Get  
	public String toString() {
		String id = (String) getRequestAttributes().get("id");
		double soldeDisponibleJohn=50000;
		double soldeDisponibleMarie=30000;
		double soldeDisponibleGeorge=8000;

		if (id.equals("111")){
			return "<users>" +
					"<user>" +
					"<id>"+id+"</id>" +
					"<nom>Dupont</nom>" +
					"<prenom>John</prenom>" +
					"<adresse>Evry 91000</adresse>" +
					"<mail>john.dupond@mail.fr</mail>" +
					"<tel>0606060606</tel>" +
					"<soldeDisponible>"+soldeDisponibleJohn+"</soldeDisponible>" +	
					"</user>" +
					"</users>";
		}
		else if(id.equals("222")){
			return "<users>" +
					"<user>" +
					"<id>"+id+"</id>" +
					"<nom>Durand</nom>" +
					"<prenom>Marie</prenom>" +
					"<adresse>Paris 75016</adresse>" +
					"<mail>marie.durand@mail.fr</mail>" +
					"<tel>0707070707</tel>" +
					"<soldeDisponible>"+soldeDisponibleMarie+"</soldeDisponible>" +					
					"</user>" +
					"</users>";			
		}
		else if(id.equals("333")){
			return "<users>" +
					"<user>" +
					"<id>"+id+"</id>" +
					"<nom>Martin</nom>" +
					"<prenom>George</prenom>" +
					"<adresse>Paris 75216</adresse>" +
					"<mail>george.martin@mail.fr</mail>" +
					"<tel>0767676767</tel>" +
					"<soldeDisponible>"+soldeDisponibleGeorge+"</soldeDisponible>" +					
					"</user>" +
					"</users>";			
		}
		else{
			return "No information found.";  
		}
	}  
}