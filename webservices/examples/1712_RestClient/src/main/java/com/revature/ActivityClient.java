package com.revature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ActivityClient {

	Client client = ClientBuilder.newClient();

	Activity getActivity(String id) {
		// http://localhost:8080/exercise-services/webapi/activities/1234
		WebTarget target = client.target("http://localhost:8081/HelloRestService/web/").path("activities/" + id);
		Response response = target.request(MediaType.APPLICATION_XML).get(Response.class);
		System.out.println(response);
		
		if (response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + " don't know why this exception occured ");
		}
		
		return response.readEntity(Activity.class);
	}
}
