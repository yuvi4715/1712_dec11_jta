package com.revature.resources;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.revature.model.Activity;
import com.revature.model.User;
import com.revature.repository.ActivityRepo;
import com.revature.repository.ActivityRepoImplementation;

@Path("activities") //http://localhost:8080/1712_RestService/rest/activities
public class ActivityResource {

	private ActivityRepo a1 = new ActivityRepoImplementation();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities() {
		return a1.findAllActivities();
	}
	@GET
	@Path("{activityid}")			//http://localhost:8080/1712_RestService/rest/activities/activity
	@Produces(MediaType.APPLICATION_XML)
	public Response getActivity(@PathParam("activityid") String id ) {
		Activity a2 = a1.findActivity(id);
		if (id == null || id.length() < 4)
			return Response.status(Status.NOT_FOUND).build();
		else 
			return Response.ok().entity(a2).build();
	}
	
	@GET
	@Path("{activityid}/user")			//http://localhost:8080/1712_RestService/rest/activities/user
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserActivity(@PathParam("activityid") String activityid ) {
		return a1.findActivity("Tom").getUser();
	}
	
	@POST
	@Path("create")	//http://localhost:8081/HelloRestService/web/activities/create
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivity(Activity activity) {
		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		a1.createActivity(activity);
		return activity;
	}
	
}
