package clientInfosRestService.deployment;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class UserItemResource extends ServerResource {
	@Get
	public String toString() {
		String id = (String) getRequestAttributes().get("id");
		return "The items that user \"" + id + "\" bought are: <nothing>";
	}
}