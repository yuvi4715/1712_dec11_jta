package com.revature.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.revature.model.Activity;
import com.revature.repository.ActivityRepo;
import com.revature.repository.ActivityRepoImplementation;

@Path("activities") //http://localhost:8080/1712_RestService/rest/activities
public class ActivityResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities() {
		ActivityRepo a1 = new ActivityRepoImplementation();
		return a1.findAllActivities();
	}
	@GET
	@Path("{activity}")			//http://localhost:8080/1712_RestService/rest/activities/activity
	@Produces(MediaType.APPLICATION_XML)
	public Activity getActivity() {
		return new ActivityRepoImplementation().findActivity("1234");
	}
	
}
