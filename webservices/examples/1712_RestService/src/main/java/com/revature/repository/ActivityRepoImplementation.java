package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Activity;
import com.revature.model.User;

public class ActivityRepoImplementation implements ActivityRepo {
	public List<Activity> findAllActivities(){
		List<Activity> activities = new ArrayList<>();
		
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration("50");
		activity1.setId("1234");
		
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setDescription("Running");
		activity2.setDuration("30");
		activity2.setId("2345");
		
		activities.add(activity2);
		return activities;
	}
	
	public void createActivity(Activity activity) {
		System.out.println("create activity is called by ");
	}
	
	public Activity findActivity(String activityid){
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration("50");
		activity1.setId("1234");
		
		User u1 = new User();
		u1.setId(10);
		u1.setName("Tom");
		
		activity1.setUser(u1);
		return activity1;
	}
}
